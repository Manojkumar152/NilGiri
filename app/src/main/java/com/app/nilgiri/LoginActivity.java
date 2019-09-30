package com.app.nilgiri;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.Login;
import com.app.nilgiri.Utils.DisplaySnackBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Boolean isClicked;
    private EditText mEditname, mEditPass;
    private ImageView mImage_eye;
    private Button mButton_login;
    private LinearLayout signup;
    SharedPreferences pref;
    private SharedPreferences.Editor editor;
    String company_id = "";
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initId();
        pref = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    private void initId() {
        mEditname = findViewById(R.id.ed_email);
        mEditPass = findViewById(R.id.ed_password);
        mImage_eye = findViewById(R.id.iv_eye);
        mButton_login = findViewById(R.id.btn_login);
        signup  = findViewById(R.id.linear_signout);

        mImage_eye.setBackgroundResource(R.drawable.ic_eye);
        mImage_eye.setOnClickListener(this);
        mButton_login.setOnClickListener(this);
        signup.setOnClickListener(this);
        isClicked= false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_eye:
                if (isClicked) {
                    mImage_eye.setBackgroundResource(R.drawable.ic_eye);
                    mEditPass.setTransformationMethod(new PasswordTransformationMethod());
                    isClicked=false;
                }
                else {
                    mImage_eye.setBackgroundResource(R.drawable.ic_green_eye);
                    mEditPass.setTransformationMethod(null);
                    isClicked=true;
                }
                break;
            case R.id.btn_login:
                String email = mEditname.getText().toString().trim();
                String password = mEditPass.getText().toString().trim();
                if (email.equals("") || password.equals("")) {
                    DisplaySnackBar.showSnackBar(this, "Blank not Allowed");
                }
                else {
                    getUserLogin(email,password);
                }
                break;
            case R.id.linear_signout:
               /* Intent i = new Intent(getApplication(),SignUpActivity.class);
                startActivity(i);*/
                break;
        }
    }

    private void getUserLogin(String email, String password) {
      //  editor.putString("IS_LOGIN","1");
      //  editor.putString("company_id","4");
      //  editor.commit();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait..");
        dialog.show();

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<Login> call=service.loginUser(email,password,Urls.API_KEY);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Log.e("REsponse","Response"+response.body());

                if(response.isSuccessful()){
                    company_id = response.body().getData().getCompany_id();
                    editor.putString("IS_LOGIN","1");
                    editor.putString("company_id",company_id);
                    editor.commit();

                    DisplaySnackBar.showSnackBar(LoginActivity.this,response.body().getMessage());
                    Intent intent= new Intent(LoginActivity.this,HomeScreenNew.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }
                else{
                    DisplaySnackBar.showSnackBar(LoginActivity.this,response.body().getMessage());
                }
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                DisplaySnackBar.showSnackBar(LoginActivity.this,"Error: " + t.getMessage());
                dialog.dismiss();
            }
        });
    }
}
