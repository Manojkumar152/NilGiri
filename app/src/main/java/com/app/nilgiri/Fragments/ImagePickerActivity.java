package com.app.nilgiri.Fragments;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImagePickerActivity extends AppCompatActivity {

    private static final int REQUEST_PICK_IMAGE = 2365;
    private static final int REQUEST_CROP_IMAGE = 2342;

    String imagePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivityForResult(getPickImageChooserIntent(), REQUEST_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if(requestCode == REQUEST_PICK_IMAGE) {
                Intent intent = new Intent(this, CropImageActivity.class);
                Uri imageUri = getPickImageResultUri(data);
                intent.putExtra(CropImageActivity.EXTRA_IMAGE_URI, imageUri.toString());
                startActivityForResult(intent, REQUEST_CROP_IMAGE);
            }
            else if(requestCode == REQUEST_CROP_IMAGE) {
                System.out.println("Image crop success :"+data.getStringExtra(CropImageActivity.CROPPED_IMAGE_PATH));
                String imagePath = new File(data.getStringExtra(CropImageActivity.CROPPED_IMAGE_PATH)).getAbsolutePath();
                Intent result = new Intent();
                result.putExtra("image_path", imagePath);
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        }
        else {
            System.out.println("Image crop failed");
            setResult(Activity.RESULT_CANCELED);
            finish();
        }
    }


    /**
     * Create a chooser intent to select the source to get image from.<br/>
     * The source can be camera's (ACTION_IMAGE_CAPTURE) or gallery's (ACTION_GET_CONTENT).<br/>
     * All possible sources are added to the intent chooser.
     */
    public Intent getPickImageChooserIntent() {

        // Determine Uri of camera image to save.
        Uri outputFileUri = getCaptureImageOutputUri();

        List<Intent> allIntents = new ArrayList<>();
        PackageManager packageManager = getPackageManager();

        // collect all gallery intents
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
        for (ResolveInfo res : listGallery) {
            Intent intent = new Intent(galleryIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            allIntents.add(intent);
        }

        // the main intent is the last in the list, so pickup the useless one
        Intent mainIntent = allIntents.get(allIntents.size() - 1);
        for (Intent intent : allIntents) {
            if (intent.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                mainIntent = intent;
                break;
            }
        }
        allIntents.remove(mainIntent);

        // Create a chooser from the main intent
        Intent chooserIntent = Intent.createChooser(mainIntent, "Select source");

        // Add all other intents
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));

        return chooserIntent;
    }

    /**
     * Get URI to image received from capture by camera.
     */
    int count = 0;
    private Uri getCaptureImageOutputUri() {
        //  count++;
        Uri outputFileUri = null;
        File getImage = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath()));

        }
        return outputFileUri;

        /*Uri outputFileUri = null;
        File getImage = getExternalFilesDir("");
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "profile.png"));
        }
        return outputFileUri;*/
    }
 /*   private Uri getCaptureImageOutputUri(){
        Uri outputFileUri = null;
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,
                    ".jpg",

                    storageDir

            );


        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save a file: path for use with ACTION_VIEW intents
        outputFileUri = Uri.fromFile(new File(image.getAbsolutePath()));
       // outputFileUri = Uri.parse(image.getAbsolutePath());
        return outputFileUri;
    }*/

    /**
     * Get the URI of the selected image from {@link #getPickImageChooserIntent()}.<br/>
     * Will return the correct URI for camera and gallery image.
     *
     * @param data the returned data of the activity result
     */
    public Uri getPickImageResultUri(Intent data) {
        boolean isCamera = true;
        if (data != null) {
            String action = data.getAction();
            isCamera = action != null && action.equals(MediaStore.ACTION_IMAGE_CAPTURE);
        }
        return isCamera ? getCaptureImageOutputUri() : data.getData();
    }

}
