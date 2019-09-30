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

import com.app.nilgiri.R;

import java.util.ArrayList;

public class UpdateKycPagerAdapter extends PagerAdapter {
    Context context;
    private ArrayList<String> images;
    private ArrayList<String> getDetailList;

    public UpdateKycPagerAdapter(Context context, ArrayList<String> images, ArrayList<String> getDetailList) {
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
            pagerImage.setImageBitmap(decodedByte);
            //pagerImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else if (getDetailList != null) {
            for (int i = 0; i < getDetailList.size(); i++) {
                //  Glide.with(getActivity()).load(InterfaceApi.IMAGE_URL + getDetailList.get(position)).into(pagerImage);
                //   Picasso.with(context).load(InterfaceApi.IMAGE_URL + getDetailList.get(position))
                //           .transform(new RoundedCornersTransformation(20,0)).into(pagerImage);
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
}
