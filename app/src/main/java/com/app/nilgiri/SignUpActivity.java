package com.app.nilgiri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.nilgiri.Utils.DisplaySnackBar;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText m_ed_user_name,m_ed_password,m_ed_confirm_password,m_ed_number;
    private ImageView m_iv_eye_pass,m_iv_eye;
    private LinearLayout mlinear_login;
    private Button m_btn_sign_up;
    private Boolean isClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initId();
    }
    private void initId(){
        m_ed_user_name = findViewById(R.id.ed_user_name);
        m_ed_password = findViewById(R.id.ed_password);
        m_ed_confirm_password = findViewById(R.id.ed_confirm_password);
        m_ed_number = findViewById(R.id.ed_number);
        m_iv_eye_pass  = findViewById(R.id.iv_eye_pass);
        m_iv_eye  = findViewById(R.id.iv_eye);
        m_btn_sign_up = findViewById(R.id.btn_sign_up);

        mlinear_login = findViewById(R.id.linear_login);

        m_iv_eye_pass.setBackgroundResource(R.drawable.ic_eye);
        m_iv_eye.setBackgroundResource(R.drawable.ic_eye);
        mlinear_login.setOnClickListener(this);
        m_iv_eye_pass.setOnClickListener(this);
        m_iv_eye.setOnClickListener(this);
        m_btn_sign_up.setOnClickListener(this);
        isClicked= false;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_login:
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_eye_pass:
                if (isClicked) {
                    m_iv_eye_pass.setBackgroundResource(R.drawable.ic_eye);
                    m_ed_password.setTransformationMethod(new PasswordTransformationMethod());
                    isClicked = false;
                } else {
                    m_iv_eye_pass.setBackgroundResource(R.drawable.ic_green_eye);
                    m_ed_password.setTransformationMethod(null);
                    isClicked = true;
                }
                break;

            case R.id.iv_eye:
                if (isClicked) {
                    m_iv_eye.setBackgroundResource(R.drawable.ic_eye);
                    m_ed_confirm_password.setTransformationMethod(new PasswordTransformationMethod());
                    isClicked = false;
                } else {
                     m_iv_eye.setBackgroundResource(R.drawable.ic_green_eye);
                    m_ed_confirm_password.setTransformationMethod(null);
                    isClicked = true;
                }
                break;

            case R.id.btn_sign_up:
                Intent i = new Intent(getApplication(), HomeScreenNew.class);
                startActivity(i);
                String username = m_ed_user_name.getText().toString().trim();
                String password = m_ed_password.getText().toString().trim();
                String confirm_password = m_ed_confirm_password.getText().toString().trim();
                String phone_number = m_ed_number.getText().toString().trim();


                if (username.equals("") || password.equals("") || confirm_password.equals("") || phone_number.equals("")) {
                    DisplaySnackBar.showSnackBar(this, "Blank not Allowed");
                }
                else if(!password.equals(confirm_password)){
                    DisplaySnackBar.showSnackBar(this, "Password Not matching");
                }
                else {
                    //getUserLogin(email,password);
                    Intent j = new Intent(getApplication(), HomeScreenNew.class);
                    startActivity(j);
                }
                break;
        }
    }
}
