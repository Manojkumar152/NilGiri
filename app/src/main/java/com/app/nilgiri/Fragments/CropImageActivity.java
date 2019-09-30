package com.app.nilgiri.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.nilgiri.R;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CropImageActivity extends AppCompatActivity implements CropImageView.OnSetImageUriCompleteListener, CropImageView.OnGetCroppedImageCompleteListener, View.OnClickListener {

    private static final int DEFAULT_ASPECT_RATIO_VALUES = 100;

    public static final String CROPPED_IMAGE_PATH = "cropped_image_path";
    public static final String EXTRA_IMAGE_URI = "cropped_image_path";

    public static final String FIXED_ASPECT_RATIO = "extra_fixed_aspect_ratio";
    public static final String EXTRA_ASPECT_RATIO_X = "extra_aspect_ratio_x";
    public static final String EXTRA_ASPECT_RATIO_Y = "extra_aspect_ratio_y";

    private static final String ASPECT_RATIO_X = "ASPECT_RATIO_X";

    private static final String ASPECT_RATIO_Y = "ASPECT_RATIO_Y";

    private CropImageView mCropImageView;

    private int mAspectRatioX = DEFAULT_ASPECT_RATIO_VALUES;

    private int mAspectRatioY = DEFAULT_ASPECT_RATIO_VALUES;

    private boolean isFixedAspectRatio = false;

    Bitmap croppedImage;
    String pathimage = "";
    String filename ="";
    ImageView iv_cancel,iv_crop;
    //endregion

    // Saves the state upon rotating the screen/restarting the activity
    @Override
    protected void onSaveInstanceState(@SuppressWarnings("NullableProblems") Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(ASPECT_RATIO_X, mAspectRatioX);
        bundle.putInt(ASPECT_RATIO_Y, mAspectRatioY);
    }

    // Restores the state upon rotating the screen/restarting the activity
    @Override
    protected void onRestoreInstanceState(@SuppressWarnings("NullableProblems") Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        mAspectRatioX = bundle.getInt(ASPECT_RATIO_X);
        mAspectRatioY = bundle.getInt(ASPECT_RATIO_Y);
    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_image);


        if(!getIntent().hasExtra(EXTRA_IMAGE_URI)) {
            cropFailed();
            return;
        }

        iv_cancel = findViewById(R.id.cancel);
        iv_crop = findViewById(R.id.crop);
        iv_cancel.setOnClickListener(this);
        iv_crop.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            pathimage = bundle.getString(EXTRA_IMAGE_URI);
// it contains your image path...I'm using a temp string...
            filename=pathimage.substring(pathimage.lastIndexOf("/")+1);
        }

        isFixedAspectRatio = getIntent().getBooleanExtra(FIXED_ASPECT_RATIO , false);
        mAspectRatioX = getIntent().getIntExtra(EXTRA_ASPECT_RATIO_X, DEFAULT_ASPECT_RATIO_VALUES);
        mAspectRatioY = getIntent().getIntExtra(EXTRA_ASPECT_RATIO_Y, DEFAULT_ASPECT_RATIO_VALUES);

        Uri imageUri = Uri.parse(getIntent().getStringExtra(EXTRA_IMAGE_URI));
        // Initialize components of the app
        mCropImageView = (CropImageView) findViewById(R.id.CropImageView);
        // If you want to fix the aspect ratio, set it to 'true'
        mCropImageView.setFixedAspectRatio(isFixedAspectRatio);

        if (savedInstanceState == null) {
            mCropImageView.setImageUriAsync(imageUri);
        }
    }

    private void cropFailed() {
        Toast.makeText(mCropImageView.getContext(), "Image crop failed", Toast.LENGTH_LONG).show();
        setResult(RESULT_CANCELED);
       onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_crop_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        findViewById(R.id.action_crop);
        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_crop) {
            mCropImageView.getCroppedImageAsync(mCropImageView.getCropShape(), 0, 0);
            return true;
        }
        else  if (id == R.id.action_cancel) {
            cropFailed();
            return false;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCropImageView.setOnSetImageUriCompleteListener(this);
        mCropImageView.setOnGetCroppedImageCompleteListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCropImageView.setOnSetImageUriCompleteListener(null);
        mCropImageView.setOnGetCroppedImageCompleteListener(null);
    }

    @Override
    public void onSetImageUriComplete(CropImageView view, Uri uri, Exception error) {
        if (error == null) {
            //Toast.makeText(mCropImageView.getContext(), "Image load successful", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(mCropImageView.getContext(), "Image load failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
            Toast.makeText(mCropImageView.getContext(), "Unable to load image", Toast.LENGTH_LONG).show();
        }
    }
    String path ="";
    @Override
    public void onGetCroppedImageComplete(CropImageView view, Bitmap bitmap, Exception error) {
        if (error == null) {
            croppedImage = bitmap;
            try {
                saveToInternalStorage(this, bitmap);
                Intent resultIntent = new Intent();
                resultIntent.putExtra(CROPPED_IMAGE_PATH, path);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            } catch (IOException e) {
                e.printStackTrace();
                cropFailed();
            }
        } else {
            cropFailed();
        }
    }

    private File saveToInternalStorage(Context context, Bitmap bitmapImage) throws IOException {
        ContextWrapper cw = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/imageDir

        String pathString = String.valueOf(bitmapImage.getGenerationId());
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp ;
        File directory = cw.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
      //  String imageFileName = imageFileName;
        // Create imageDir
        ///   File mypath=new File(String.valueOf(directory));
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,
                    ".jpg",

                    directory

            );


        } catch (IOException e) {
            e.printStackTrace();
        }
        path = image.getAbsolutePath();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            // Use the compress method on the BitMap object to write image to the OutputStream
            //Bitmap scaledBitmap = getCompressedBitmap(bitmapImage);
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 70, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
        return image;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                cropFailed();
                break;
            case R.id.crop:
                mCropImageView.getCroppedImageAsync(mCropImageView.getCropShape(), 0, 0);
                break;
        }
    }
}
