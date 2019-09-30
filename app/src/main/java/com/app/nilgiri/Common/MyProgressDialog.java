package com.app.nilgiri.Common;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.app.nilgiri.R;


public class MyProgressDialog {

    private static Dialog mProgress;

    public static void show(Context mContext) {

        try {
            if (mProgress == null) {
                mProgress = new Dialog(mContext, R.style.MyDialog);
                if (mProgress.getWindow() != null)
                    mProgress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }

            mProgress.setContentView(R.layout.dialog_progress);
            mProgress.setCancelable(false);
            mProgress.show();
        } catch (Exception e) {
            e.printStackTrace();
            mProgress = null;
        }
    }

    public static void hide() {
        try {
            if (mProgress != null) {
                mProgress.hide();
                mProgress.dismiss();
                mProgress = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            mProgress = null;
        }
    }
}
