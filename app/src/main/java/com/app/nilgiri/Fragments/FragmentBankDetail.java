package com.app.nilgiri.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.BankDetailData;
import com.app.nilgiri.Models.IfscDetails;
import com.app.nilgiri.Models.ResponseData;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBankDetail extends Fragment implements View.OnTouchListener,View.OnClickListener {
    private TextView mBranch, mState, mCity, mAddress, mBank;
    private EditText med_account_no, med_account_holder, med_ifsc_code;
    private View v;
    private Button buttonupdate,verify;
    private boolean isEdited;
    private String account_number = "", account_holder_name = "", account_ifsc_code = "";
    private SharedPreferences pref;
    private String companyId;
    private CardView mlinear_layout_bank;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_bank_detail, container, false);
        iniId(v);

        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        companyId = pref.getString("company_id", null);

        if (ConnectionDetection.isInternetAvailable(getActivity())) {
            getBankDetailData(companyId);
        } else {
            DisplaySnackBar.showSnackBar(getActivity(), getString(R.string.internet_error));
        }
        return v;
    }

    private void iniId(View v) {
        isEdited=false;
        med_account_no = v.findViewById(R.id.ed_account_no);
        med_account_holder = v.findViewById(R.id.ed_account_holder);
        med_ifsc_code = v.findViewById(R.id.ed_ifsc_code);
        buttonupdate = v.findViewById(R.id.btn_update);
        mlinear_layout_bank = v.findViewById(R.id.card_view_branch);
        verify=v.findViewById(R.id.verify);

        mBranch = v.findViewById(R.id.text_branch);
        mState = v.findViewById(R.id.text_state);
        mCity = v.findViewById(R.id.text_city);
        mAddress = v.findViewById(R.id.text_address);
        mBank = v.findViewById(R.id.text_bank);

        med_account_no.setOnTouchListener(this);
        med_account_holder.setOnTouchListener(this);
        med_ifsc_code.setOnTouchListener(this);
        verify.setOnClickListener(this);
        buttonupdate.setOnClickListener(this);

       /* med_ifsc_code.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Log.e("AFTER","AFTER");
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
               String ifsc=s.toString();
               Log.e("Size","Size"+ ifsc.length()+"  "+isEdited);
               if((ifsc.length()==11)) {
                   Log.e("IF","IF");
                   if (isEdited) {
                       getIfscDetails(ifsc);
                   }
               }
               else if(ifsc.length()<11){
                   if(isEdited){
                       DisplaySnackBar.showSnackBar(getActivity(), "Ifsc code is incorrect");
                       if (mlinear_layout_bank.getVisibility() == View.VISIBLE) {
                           mlinear_layout_bank.setVisibility(View.INVISIBLE);
                       }
                   }
               }
            }
        });*/

    }

    private void updateBankDetails(String name, String account_number, String account_ifsc_code) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showProgress();
        }

        ApiInterface service = RetrofitClient.getClient().create(ApiInterface.class);
        Call<ResponseData> call = service.updateBankDetails(companyId, Urls.API_KEY,name,account_number,account_ifsc_code);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.e("UPdate_Response", "UPDATE" + response.body().toString());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                getBankDetailData(companyId);
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.e("DashBoard", "Failure" + t.toString());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                DisplaySnackBar.showSnackBar(getActivity(), t.getMessage());
            }
        });
    }

    private void getBankDetailData(String companyId) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showProgress();
        }
        ApiInterface service = RetrofitClient.getClient().create(ApiInterface.class);
        Call<BankDetailData> call = service.getBankDetail(companyId, Urls.API_KEY);
        call.enqueue(new Callback<BankDetailData>() {
            @Override
            public void onResponse(Call<BankDetailData> call, Response<BankDetailData> response) {
                Log.e("UPdate_Response", "UPDATE" + response.body().toString());
                if (response.body().getStatus() == 1) {
                    setgetDetailData(response.body());
                } else {
                    DisplaySnackBar.showSnackBar(getActivity(), response.body().getMessage());
                }
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }

            @Override
            public void onFailure(Call<BankDetailData> call, Throwable t) {
                Log.e("DashBoard", "Failure" + t.toString());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                DisplaySnackBar.showSnackBar(getActivity(), t.getMessage());
            }
        });
    }

    private void setgetDetailData(BankDetailData body) {
        List<BankDetailData.DataBean> tempData = body.getData();
        Log.e("BANK","BAnk"+"  "+tempData.size()+"  "+tempData.get(0).getAccount_holder_name());
        for (int i = 0; i <1; i++) {
            med_account_no.setText(tempData.get(0).getAccount_number());
            med_account_holder.setText(tempData.get(0).getAccount_holder_name());
            med_ifsc_code.setText(tempData.get(0).getIfsc_code());
        }
    }

    private void getIfscDetails(String ifsc) {
        Log.e("GET_IFSC","GET_IFSC");
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showProgress();
        }

        ApiInterface service = RetrofitClient.getApiClient().create(ApiInterface.class);
        Call<IfscDetails> call = service.getIfscDetails(ifsc);
        call.enqueue(new Callback<IfscDetails>() {
            @Override
            public void onResponse(Call<IfscDetails> call, Response<IfscDetails> response) {
                Log.e("UPdate_Response", "UPDATE" + response.body());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                if(response.body()!=null) {
                    setData(response.body());
                }
                else{
                    DisplaySnackBar.showSnackBar(getActivity(), "IFSC code is Incorrect");
                    verify.setTextColor(getResources().getColor(R.color.red_color));
                    verify.setText("Not Verified");
                }
            }

            @Override
            public void onFailure(Call<IfscDetails> call, Throwable t) {
                Log.e("DashBoard", "Failure" + t.toString());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
                DisplaySnackBar.showSnackBar(getActivity(), t.getMessage());
            }
        });
    }

    private void setData(IfscDetails body) {
        verify.setTextColor(getResources().getColor(R.color.green));
        verify.setText("Verified");
        mlinear_layout_bank.setVisibility(View.VISIBLE);
        mBranch.setText(body.getBRANCH());
        mState.setText(body.getSTATE());
        mCity.setText(body.getCITY());
        mAddress.setText(body.getADDRESS());
        mBank.setText(body.getBANK());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.ed_account_no:
                isEdited = true;
                Log.e("Update", "UPDATE_ACC" + isEdited);
                break;
            case R.id.ed_account_holder:
                isEdited = true;
                Log.e("Update", "UPDATE_HOLDER" + isEdited);
                break;
            case R.id.ed_ifsc_code:
                isEdited = true;
                verify.setTextColor(getResources().getColor(R.color.light_dark_grey));
                verify.setText("Verify");
                mlinear_layout_bank.setVisibility(View.INVISIBLE);
                Log.e("Update", "UPDATE_IFSC" + isEdited);
                break;
        }
            Log.e("Update", "UPDATE" + isEdited + " " + med_account_no.getText().toString() + "  " + med_account_holder.getText().toString() + " " + verify.getText().toString());
            return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verify:
                Log.e("Length", "Length" + med_ifsc_code.getText().length());
                if (med_ifsc_code.getText().length() == 11) {
                    getIfscDetails(med_ifsc_code.getText().toString());
                } else {
                    DisplaySnackBar.showSnackBar(getActivity(), "IFSC code is Incorrect");
                }
                break;
            case R.id.btn_update:
                if (isEdited) {
                    if(med_account_no.getText().toString().equals("") || med_account_holder.getText().toString().equals("") || med_ifsc_code.getText().toString()
                            .equals("")) {
                        DisplaySnackBar.showSnackBar(getActivity(), "Blank not Allowed");
                    }
                    else if(verify.getText().toString().equals("Not Verified")) {
                        DisplaySnackBar.showSnackBar(getActivity(), "IFSC code is Incorrect");
                    }
                    else if(verify.getText().toString().equals("Verify")) {
                        DisplaySnackBar.showSnackBar(getActivity(), "You need to Verify IFSC code First");
                    }
                    else{
                        account_number = med_account_no.getText().toString();
                        account_holder_name = med_account_holder.getText().toString();
                        account_ifsc_code = med_ifsc_code.getText().toString();
                        updateBankDetails(account_holder_name, account_number, account_ifsc_code);
                    }
                }
                else{
                    DisplaySnackBar.showSnackBar(getActivity(),"Nothing to Update");
                }
                break;
        }
    }
}




