package com.app.nilgiri.Fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.ProfileData;
import com.app.nilgiri.Models.ResponseData;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

@RuntimePermissions
public class FragmentProfile extends Fragment implements View.OnClickListener {
    private TextView mProfileName,mAddress,mEmail,mPhone,mCity,mState;
    private EditText mEditAddress,mEditEmail,mEditphone,mEditCity,mEditState;
    private RelativeLayout mRelativeEditProfile;
    private ImageView mProfileImage;
    private RelativeLayout relativeLayout;
    private Button submit;
    private static final int CAMERA_REQUEST = 1888;
    private static int RESULT_LOAD_IMAGE = 1;
    String imagePath;
    String selectedImageUri = "";
    Bitmap bitmap;
    CoordinatorLayout coordinatorLayout;
    private boolean isEdited;
    View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    boolean swipeRefresh;
    private String companyId=null;
    String apiKey = "null";
    private SharedPreferences pref;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_profile, container, false);
        initId(view);
        swipeRefresh=false;
        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        companyId=pref.getString("company_id",null);

        if(ConnectionDetection.isInternetAvailable(getActivity())) {
            getUserProfile(companyId);
        }
        else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
        return view;
    }

    private void initId(View v){
        isEdited=false;
        relativeLayout = v.findViewById(R.id.rl_RelativeLayout);
        mProfileName = v.findViewById(R.id.tv_profileName);
        mAddress = v.findViewById(R.id.tv_editAddress);
        mEmail = v.findViewById(R.id.tv_editEmail);
        mPhone = v.findViewById(R.id.tv_editPhone);
        mCity = v.findViewById(R.id.tv_editCity);
        mState = v.findViewById(R.id.tv_editState);
        coordinatorLayout = v.findViewById(R.id.snack_layout);
        submit=v.findViewById(R.id.btn_submit);

        mEditAddress = v.findViewById(R.id.edit_address);
        mEditEmail = v.findViewById(R.id.edit_email);
        mEditphone = v.findViewById(R.id.edit_phone);
        mEditCity = v.findViewById(R.id.edit_city);
        mEditState = v.findViewById(R.id.edit_state);

        mRelativeEditProfile = v.findViewById(R.id.rl_layoutEditProfile);
        mProfileImage = v.findViewById(R.id.iv_imageProfile);

        mRelativeEditProfile.setOnClickListener(this);
        mAddress.setOnClickListener(this);
        mEmail.setOnClickListener(this);
        mPhone.setOnClickListener(this);
        mCity.setOnClickListener(this);
        mState.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    private void getUserProfile(String company_id) {
        if (getActivity()!= null) {
            ((BaseActivity) getActivity()).showProgress();
        }
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<ProfileData> call=service.getProfile(company_id,Urls.API_KEY);
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                Log.e("ResponseData","ResponseData"+response.body());
                if(response.body().getStatus()==1){
                    setData(response.body());
                }
                else{
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage().toString());
                }
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                DisplaySnackBar.showSnackBar(getActivity(),t.toString());
            }
        });
    }

    String useraddress,useremail ,phone_no,city,state;
    private void setData(ProfileData body) {
        String usename = body.getData().getUsername();
        useraddress = body.getData().getAddress();
        useremail  = body.getData().getEmail();
        phone_no = body.getData().getPhone();
        city = body.getData().getCity();
        state = body.getData().getState();

        mProfileName.setText(usename);
        mEditAddress.setText(useraddress);
        mEditAddress.setTextColor(getResources().getColor(R.color.light_dark_grey));
        mEditEmail.setText(useremail);
        mEditEmail.setTextColor(getResources().getColor(R.color.light_dark_grey));
        mEditphone.setText(phone_no);
        mEditphone.setTextColor(getResources().getColor(R.color.light_dark_grey));
        mEditCity.setText(city);
        mEditCity.setTextColor(getResources().getColor(R.color.light_dark_grey));
        mEditState.setText(state);
        mEditState.setTextColor(getResources().getColor(R.color.light_dark_grey));
        Picasso.with(getActivity()).load(Urls.PROFILE_IMAGE_URL + body.getUsers().getAvatar())
               .into(mProfileImage);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_layoutEditProfile:
                isEdited=true;
                FragmentProfilePermissionsDispatcher.selectImageWithPermissionCheck(this);
                break;

            case R.id.tv_editAddress:
                mEditAddress.setEnabled(true);
                mEditAddress.requestFocus();
                isEdited=true;
              //  mEditAddress.setFocusable(true);
                break;

            case R.id.tv_editEmail:
                mEditEmail.setEnabled(true);
                mEditEmail.requestFocus();
                isEdited=true;
                break;

            case R.id.tv_editPhone:
                mEditphone.setEnabled(true);
                mEditphone.requestFocus();
                isEdited=true;
                break;

            case R.id.tv_editCity:
                mEditCity.setEnabled(true);
                mEditCity.requestFocus();
                isEdited=true;
                break;

            case R.id.tv_editState:
                mEditState.setEnabled(true);
                mEditState.requestFocus();
                isEdited=true;
                break;

            case R.id.btn_submit:
                if(isEdited){
                    useraddress =  mEditAddress.getText().toString();
                    useremail =  mEditEmail.getText().toString();
                    phone_no = mEditphone.getText().toString();
                    city = mEditCity.getText().toString();
                    state = mEditState.getText().toString();
                    if(ConnectionDetection.isInternetAvailable(getActivity())) {
                        updateUserProfile(useraddress, useremail, phone_no, city, state);
                    }
                    else{
                        DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
                    }
                }
                else{
                    DisplaySnackBar.showSnackBar(getActivity(),"There is Nothing to Update");
                }
                break;
        }
    }

    private void updateUserProfile(String add, String mail, String phone_no,String mcity,  String mstate) {
        try{
        if (getActivity()!= null) {
            ((BaseActivity) getActivity()).showProgress();
        }
        Log.e("ImAgePath","ImagePath"+"  "+imagePath);
        File file= new File(imagePath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("avatar", file.getName(), requestFile);
        RequestBody api_key = RequestBody.create(MediaType.parse("text/plain"),Urls.API_KEY);
        RequestBody client_id =  RequestBody.create(MediaType.parse("text/plain"),companyId);
        RequestBody address = RequestBody.create(MediaType.parse("text/plain"),add);
        RequestBody email =  RequestBody.create(MediaType.parse("text/plain"),mail);
        RequestBody phone =  RequestBody.create(MediaType.parse("text/plain"),phone_no);
        RequestBody city =  RequestBody.create(MediaType.parse("text/plain"),mcity);
        RequestBody state =  RequestBody.create(MediaType.parse("text/plain"),mstate);
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<ResponseData> call=service.updateUserProfile(client_id,api_key,address,email,phone,city,state,body);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.e("UPdate_Response","UPDATE"+response.body().getMessage().toString());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                getUserProfile(companyId);
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }
        });
        }catch (Exception e){
            e.getStackTrace();
        }
    }


    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Gallery",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    cameraIntent();
                } else if (items[item].equals("Choose from Gallery")) {
                    galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    public void galleryIntent() {
        Intent pictureActionIntent = null;
        pictureActionIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pictureActionIntent, RESULT_LOAD_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        FragmentProfilePermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        bitmap = null;
        imagePath = null;
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            File file = new File((Environment.getExternalStorageDirectory().toString()));
            for (File temp : file.listFiles()) {
                if (temp.getName().equals(getString(R.string.temp_jpg))) {
                    file = temp;
                    break;
                }
            }
            if (!file.exists()) {
                Toast.makeText(getActivity(), R.string.error_capturing_img, Toast.LENGTH_LONG).show();
                return;

            }
            try {
                imagePath = file.getAbsolutePath();

                if (imagePath != null) {
                    File file1 = new File(imagePath);
                    selectedImageUri = Uri.fromFile(file1).toString();
                }
                bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                bitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, true);
                int rotate = 0;
                try {
                    ExifInterface exif = new ExifInterface(file.getAbsolutePath());
                    int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

                    switch (orientation) {
                        case ExifInterface.ORIENTATION_ROTATE_270:
                            rotate = 270;
                            break;
                        case ExifInterface.ORIENTATION_ROTATE_180:
                            rotate = 180;
                            break;
                        case ExifInterface.ORIENTATION_ROTATE_90:
                            rotate = 90;
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Matrix matrix = new Matrix();
                matrix.postRotate(rotate);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                mProfileImage.setVisibility(View.VISIBLE);
                mProfileImage.setImageBitmap(bitmap);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //mDialog.dismiss();
        } else if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            if (data != null) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = cursor.getString(columnIndex);

                if (imagePath != null) {
                    File file2 = new File(imagePath);
                    selectedImageUri = Uri.fromFile(file2).toString();
                }
                cursor.close();
                mProfileImage.setImageBitmap(BitmapFactory.decodeFile(imagePath));
            }
        }
    }

}
