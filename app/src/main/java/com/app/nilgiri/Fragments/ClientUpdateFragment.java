package com.app.nilgiri.Fragments;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.nilgiri.Adapter.UpdateKycPagerAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.BuildConfig;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static android.app.Activity.RESULT_OK;

@RuntimePermissions
public class ClientUpdateFragment extends Fragment implements View.OnClickListener {

    private ViewPager mViewPager;
    private ArrayList<String> images;
    private Button upload_govt_id, upload_pan_card, upload_bank_statement;
    private int selected_position;
    private int STORAGE_PERMISSION_CODE = 12;
    private ImageView mDot1, mDot2, mDot3;

    private static final int CAMERA_REQUEST = 111;
    private static final int GAlLERY_REQUEST = 222;
    String imagePath;
    String selectedImageUri = "";
    Bitmap bitmap;
    Button mUpdate;
    private ArrayList<String> imageList;

    ArrayList<String> getData;
    private UpdateKycPagerAdapter adapter;

    String first_image ;
    String second_image;
    String third_image;

    ArrayList<String> getDetailList;
    File photoFile = null;
    private Boolean isInternetAvailable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_client_update_fragment, container, false);
        requestStoragePermission();
        images = new ArrayList<>();
        images.add("");
        images.add("");
        images.add("");

        imageList = new ArrayList<>();
        imageList.add("");
        imageList.add("");
        imageList.add("");

        getDetailList =  new ArrayList<>();

        init(v);
        //getKycDetail();
        return v;
    }


  /*  private void getKycDetail() {
        if(getActivity()!=null) {
            ((BaseActivity)getActivity()).showProgress();
        }

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<GetKycDetail> call= service.getKycImages(URLS.COMPANY_ID,URLS.API_KEY);
        call.enqueue(new Callback<GetKycDetail>() {
            @Override
            public void onResponse(Call<GetKycDetail> call, ResponseData<GetKycDetail> response) {
                Log.e("RESponse","ResponseData"+response.body());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                if (response.body()!=null) {
                    List<GetKycDetail.DataBean> tempData = response.body().getData();
                    getDetailList.clear();
                    getDetailList.add(0, tempData.get(0).getUpload_first_proof());
                    getDetailList.add(1, tempData.get(0).getUpload_second_proof());
                    getDetailList.add(2, tempData.get(0).getUpload_third_proof());
                    adapter.notifyDataSetChanged();
                    setPagerAdapter();
                }
            }

            @Override
            public void onFailure(Call<GetKycDetail> call, Throwable t) {
                Log.e("RESponse","ResponseData"+t.toString());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }
        });
    }*/

    public void init(View v) {
        mViewPager = v.findViewById(R.id.pager);
        upload_govt_id = v.findViewById(R.id.upload_govt_id);
        upload_pan_card = v.findViewById(R.id.upload_pan_card);
        upload_bank_statement = v.findViewById(R.id.upload_bank_statement);
        mUpdate = v.findViewById(R.id.update_kyc);

        mDot1 = v.findViewById(R.id.iv_image1);
        mDot2 = v.findViewById(R.id.iv_image2);
        mDot3 = v.findViewById(R.id.iv_image3);

        upload_govt_id.setOnClickListener(this);
        upload_pan_card.setOnClickListener(this);
        upload_bank_statement.setOnClickListener(this);
        mUpdate.setOnClickListener(this);

        setPagerAdapter();
        viewPagerDot();
    }

    private void setPagerAdapter(){
        adapter = new UpdateKycPagerAdapter(getActivity(),images,getDetailList);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(selected_position);
        //mViewPager.setVerticalScrollbarPosition(getDetailList.size()-1);
    }

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Gallery",
                "Cancel"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    cameraIntent();
                } else if (items[item].equals("Choose from Gallery")) {
                    galleryIntent();
                }
                else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public void cameraIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
        }
        // Create the File where the photo should go

        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
            // Error occurred while creating the File

        }
        // Continue only if the File was successfully created
        if (photoFile != null) {
            Uri photoURI = FileProvider.getUriForFile(getActivity(),
                    "com.lbmsolutions.android.fileprovider",
                    photoFile);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            startActivityForResult(takePictureIntent, CAMERA_REQUEST);
        }
    }

    public void galleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,GAlLERY_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap bitmap = null;
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bitmap = BitmapFactory.decodeFile(photoFile.getAbsolutePath(), bmOptions);

            bitmap = Bitmap.createScaledBitmap(bitmap, 800, 800, true);
            Log.e("URI", "FILE" + " " + photoFile + "  " + bitmap);
            if (selected_position == 0) {
                setBtnBackground(selected_position);
                images.set(0, BitMapToString(bitmap));
                imageList.set(0, photoFile.getAbsolutePath());
            }
            else if (selected_position == 1) {
                setBtnBackground(selected_position);
                images.set(1, BitMapToString(bitmap));
                imageList.set(1, photoFile.getAbsolutePath());
            }
            else if (selected_position == 2) {
                Log.e("Selected","Positio"+" "+selected_position);
                setBtnBackground(selected_position);
                images.set(2, BitMapToString(bitmap));
                imageList.set(2, photoFile.getAbsolutePath());
            }
            setPagerAdapter();
            viewPagerDot();
        }
        else if (requestCode == GAlLERY_REQUEST && resultCode == RESULT_OK && null != data) {
            if (data != null) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = cursor.getString(columnIndex);

                File file2 = null;
                if (imagePath != null) {
                    file2 = new File(imagePath);
                    selectedImageUri = Uri.fromFile(file2).toString(); }

                cursor.close();
                bitmap = BitmapFactory.decodeFile(imagePath);

                if(selected_position ==0){
                    setBtnBackground(selected_position);
                    images.set(0,BitMapToString(bitmap));
                    imageList.set(0,imagePath);
                }
                else if(selected_position ==1){
                    setBtnBackground(selected_position);
                    images.set(1,BitMapToString(bitmap));
                    imageList.set(1,imagePath);
                }

                else if(selected_position ==2){
                    setBtnBackground(selected_position);
                    images.set(2,BitMapToString(bitmap));
                    imageList.set(2,imagePath);
                }

                setPagerAdapter();
              /*  adapter = new MyViewPagerAdapter(getActivity(),images,getDetailList);
                mViewPager.setAdapter(adapter);
                mViewPager.setCurrentItem(selected_position);*/
                viewPagerDot();
            }
        }
    }



    private void performCrop(String picUri) {
        try {
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            cropIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            File f = new File(picUri);
            Uri contentUri;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                contentUri = FileProvider.getUriForFile(getContext(),
                        BuildConfig.APPLICATION_ID + ".provider", f);
            } else {
                contentUri = Uri.fromFile(f);
            }
            cropIntent.setDataAndType(contentUri, "image/*");
            cropIntent.putExtra("crop", "true");
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            cropIntent.putExtra("outputX", 280);
            cropIntent.putExtra("outputY", 280);
            cropIntent.putExtra("return-data", true);
            startActivityForResult(cropIntent, 22);
        } catch (ActivityNotFoundException anfe) {
            String errorMessage = "your device doesn't support the crop action!";
            Toast toast = Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */

                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        imagePath = image.getAbsolutePath();
        return image;
    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.upload_govt_id:
                selected_position = 0;
                selectImage();
                break;

            case R.id.upload_pan_card:
                selected_position = 1;
                selectImage();
                break;

            case R.id.upload_bank_statement:
                selected_position = 2;
                selectImage();
                break;

            case R.id.update_kyc:
                updateClientKYC();
               /* if(ConnectionDetection.isInternetAvailable(getActivity())){
                    updateClientKYC();
                }
                else{
                    DisplaySnackBar.showSnackBar(getActivity(),Constant.NETWORK_ERROR);
                }*/
                break;
        }
    }

    private void updateClientKYC() {
        MultipartBody.Part body = null,body1=null,body2=null;
        if(getActivity()!=null) {
            ((BaseActivity) getActivity()).showProgress();
        }
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);

        if(!(String.valueOf(selected_position)==null)) {

            for (int i = 0; i < imageList.size(); i++) {
                first_image = imageList.get(0);
                second_image = imageList.get(1);
                third_image = imageList.get(2);
            }

            if(!TextUtils.isEmpty(first_image)){
                File file = new File(first_image);
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                body = MultipartBody.Part.createFormData("upload_first_proof", file.getName(), requestFile);
            }
            else if(!TextUtils.isEmpty(second_image)){
                File file1 = new File(second_image);
                RequestBody requestFile1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                body1 = MultipartBody.Part.createFormData("upload_second_proof", file1.getName(), requestFile1);
            }

            else if(!TextUtils.isEmpty(third_image)){
                File file2 = new File(third_image);
                RequestBody requestFile2 = RequestBody.create(MediaType.parse("multipart/form-data"), file2);
                body2 = MultipartBody.Part.createFormData("upload_third_proof", file2.getName(), requestFile2);
            }

        }
        // create RequestBody instance from file
   /*     RequestBody api_key = RequestBody.create(MediaType.parse("text/plain"),URLS.API_KEY);
        RequestBody client_id =  RequestBody.create(MediaType.parse("text/plain"),URLS.COMPANY_ID);
        Call<GenericResponse> call= service.updateClientKyc(api_key,client_id,body,body1,body2);
        call.enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Call<GenericResponse> call, ResponseData<GenericResponse> response) {
                Log.e(" ResponseData","ResponseData"+response.body().getMessage());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
            }

            @Override
            public void onFailure(Call<GenericResponse> call, Throwable t) {
                Log.e("Failure","Failure"+call.toString());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }
        });
*/
    }


    private void setBtnBackground(int selected_position) {
        if(selected_position==0){
            upload_govt_id.setBackgroundResource(R.drawable.rectangular_shape_green_multicolor);
            upload_govt_id.setTextColor(getResources().getColor(R.color.btn_text));
        }
        else if (selected_position==1){
            upload_pan_card.setBackgroundResource(R.drawable.rectangular_shape_green_multicolor);
            upload_pan_card.setTextColor(getResources().getColor(R.color.btn_text));
        }
        else if (selected_position==2){
            upload_bank_statement.setBackgroundResource(R.drawable.rectangular_shape_green_multicolor);
            upload_bank_statement.setTextColor(getResources().getColor(R.color.btn_text));
        }
    }


    private void requestStoragePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA},STORAGE_PERMISSION_CODE);
    }

    private boolean isPermissionAllowed() {
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        int result2 = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA);

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }

    private void viewPagerDot(){
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    mDot1.setImageResource(R.drawable.circle_dot);
                    mDot2.setImageResource(R.drawable.default_dot);
                    mDot3.setImageResource(R.drawable.default_dot);
                }if(position == 1) {
                    mDot1.setImageResource(R.drawable.default_dot);
                    mDot2.setImageResource(R.drawable.circle_dot);
                    mDot3.setImageResource(R.drawable.default_dot);
                }if(position == 2) {
                    mDot1.setImageResource(R.drawable.default_dot);
                    mDot2.setImageResource(R.drawable.default_dot);
                    mDot3.setImageResource(R.drawable.circle_dot);
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
