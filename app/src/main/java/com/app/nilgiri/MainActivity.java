package com.app.nilgiri;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 3000;
    private static final String TAG = "Main";
    SharedPreferences pref;
    ProgressDialog progressDialog;
    SharedPreferences.Editor editor;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        editor = pref.edit();

        textview=findViewById(R.id.title);
        Spannable word = new SpannableString("NILGIRI");

        word.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.green_color)), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(word);
        Log.e("SharedPrefData","SharedPrefData"+" "+pref.getString("IS_LOGIN",null));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //SessionManager session = new SessionManager(getApplicationContext());
                try {
                    if (pref.getString("IS_LOGIN", null).equals("1")) {
                        Intent i = new Intent(getApplicationContext(), HomeScreenNew.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                    }
                    finish();
                } catch (NullPointerException ex) {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                }
            }
        }, SPLASH_TIME_OUT);

    }
/*
    public void doAccessRight() {
        final StringRequest jsonObjReq = new StringRequest(Request.Method.GET,
                Const.URL_ACCESSRIGHT,
                new ResponseData.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        Log.d("ASASA", " SASASA = " + response.toString());
                        try {
                            ArrayList<AccessrightItem> accessrightItems = parser.getAccessMembers(response);
                            Gson gson = new Gson();
                            String json = gson.toJson(accessrightItems);
                            editor.putString("AccessRight", json);
                            editor.commit();
                           *//* for(int i=0;i<accessrightItems.size();i++)
                            {
                                Log.d("ASASAS",""+accessrightItems.get(i).getMenu());
                            }*//*
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new ResponseData.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());


            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                return params;
            }
        };

        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }*/

}
