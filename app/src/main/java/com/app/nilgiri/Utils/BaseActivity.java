package com.app.nilgiri.Utils;

import android.support.v7.app.AppCompatActivity;

import com.app.nilgiri.Common.MyProgressDialog;


public class BaseActivity extends AppCompatActivity {

    public void showProgress() {
        MyProgressDialog.show(this);
    }

    public void hideProgress() {
        MyProgressDialog.hide();
    }
}
