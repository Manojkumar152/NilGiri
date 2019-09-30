package com.app.nilgiri.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.app.nilgiri.LoginActivity;

import java.util.HashMap;

public class SessionManager {
    private String TAG = "Session";
    private SharedPreferences pref;
    private Editor editor;
    private Context _context;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Session";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_ID = "id";
    public static final String KEY_USER_ID = "id";
    public static final String KEY_COMPANY_ID = "company_id";
    public static final String KEY_IMAGE = "image";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLoginSession(String id, String company_id) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USER_ID, id);
        editor.putString(KEY_COMPANY_ID, company_id);
        editor.commit();
    }

    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_USER_ID, pref.getString(KEY_USER_ID, null));
        user.put(KEY_COMPANY_ID, pref.getString(KEY_COMPANY_ID, null));
        /*user.put(KEY_IMAGE, pref.getString(KEY_IMAGE, null));
        user.put(KEY_ID, pref.getString(KEY_ID, null));*/
        return user;
    }
    public String getUserId(){
        return pref.getString(KEY_USER_ID,"");
    }

    public String getCompanyId(){
        return pref.getString(KEY_COMPANY_ID,"");
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
        //Toasty.success(_context, "You have successfully logged out").show();
        DisplaySnackBar.showSnackBar((Activity) _context,"You have successfully logged out");
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}
