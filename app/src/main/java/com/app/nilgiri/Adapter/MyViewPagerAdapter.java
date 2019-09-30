package com.app.nilgiri.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


public class MyViewPagerAdapter extends PagerAdapter {
    Context context;
    private ArrayList<String> images;
    private ArrayList<String> getDetailList;

    public MyViewPagerAdapter(Context context, ArrayList<String> images, ArrayList<String> getDetailList) {
        this.context = context;
        this.images = images;
        this.getDetailList = getDetailList;
    }


    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {

        LayoutInflater inflater = LayoutInflater.from((context));
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.res_viewpager_update_kyc_activity, collection, false);
        ImageView pagerImage = layout.findViewById(R.id.viewpager_image);
        String getImage = images.get(position);

        if (!images.get(position).equals("")) {

            byte[] decodedString = Base64.decode(images.get(position), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
         //  String aa = images.get(0);
            pagerImage.setImageBitmap(decodedByte);
         //   pagerImage.setImageBitmap(getImageFromStorage(images.get(position)));
          //  pagerImage.setImageBitmap(getImageFromStorage(String.valueOf(images)));
            //pagerImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else if (getDetailList != null) {
            for (int i = 0; i < getDetailList.size(); i++) {
                //  Glide.with(getActivity()).load(InterfaceApi.IMAGE_URL + getDetailList.get(position)).into(pagerImage);
                Picasso.with(context).load(Urls.KYC_IMAGE_URL + getDetailList.get(position))
                        .transform(new RoundedCornersTransformation(20, 0)).into(pagerImage);
                //   Picasso.with(getActivity()).load(InterfaceApi.IMAGE_URL + getDetailList.get(position)).transform(new CropSquareTransformation()).into(pagerImage);
            }
        } else {
            try {
                pagerImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_photo));
                pagerImage.setScaleType(ImageView.ScaleType.CENTER);

            } catch (Exception e) {
                pagerImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_photo));
            }
        }
       // pagerImage.setImageBitmap(getImageFromStorage(images.get(position)));
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {

        return super.getItemPosition(object);

    }


    private Bitmap getImageFromStorage(String path) {

        try {

            File f = new File(path);
            // First decode with inJustDecodeBounds=true to check dimensions
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            // Calculate inSampleSize
            options.inSampleSize = calculateInSampleSize(options, 512, 512);
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(f), null, options);

            return bitmap;

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return null;
    }
    private int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}