package com.app.nilgiri.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.nilgiri.Adapter.WalletTopUpAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.WalletBalance;
import com.app.nilgiri.Models.WalletdataTopUpModel;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopupWalletFragment extends Fragment {
    private RecyclerView rcMain;
    private TextView title, balance, credit, debit;
    private SharedPreferences pref;
    String companyId;
    private WalletTopUpAdapter adapter;
    private List<WalletdataTopUpModel.DataBean> data;
    private LinearLayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_walllet, container, false);

        initView(view);

        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        companyId = pref.getString("company_id", null);

        if (ConnectionDetection.isInternetAvailable(getContext())) {
            getTopupBalance(companyId);
            getTopupWalletData(companyId);
        } else {
            DisplaySnackBar.showSnackBar(getActivity(), getString(R.string.internet_error));
        }
        return view;
    }

    private void getTopupBalance(String company_id) {
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<WalletBalance> call=service.getTopupBalance(company_id,Urls.API_KEY);
        call.enqueue(new Callback<WalletBalance>() {
            @Override
            public void onResponse(Call<WalletBalance> call, Response<WalletBalance> response) {
                Log.e("ResponseData","ResponseData"+response.body());
                if(response.body()!=null){
                    if(response.body().getData().getBalance_total().length()==0){
                        Log.e("IF","IF");
                        balance.setText("0.00");
                    }
                    else{
                        balance.setText(response.body().getData().getBalance_total());
                    }
                    if(response.body().getData().getCredit_total().length()==0){
                        credit.setText("0.00");
                    }else{
                        credit.setText(response.body().getData().getCredit_total());
                    }
                    if(response.body().getData().getDebit_total().length()==0){
                        debit.setText("0.00");
                    }else {
                        debit.setText(response.body().getData().getDebit_total());
                    }
                }
                else {
                    DisplaySnackBar.showSnackBar(getActivity(),"Error");
                }
            }

            @Override
            public void onFailure(Call<WalletBalance> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
            }
        });
    }
    private void getTopupWalletData(String companyId) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showProgress();
        }

        ApiInterface service = RetrofitClient.getClient().create(ApiInterface.class);
        Call<WalletdataTopUpModel> call = service.getTopUpWallet(companyId, Urls.API_KEY);
        call.enqueue(new Callback<WalletdataTopUpModel>() {
            @Override
            public void onResponse(Call<WalletdataTopUpModel> call, Response<WalletdataTopUpModel> response) {
                Log.e("Response", "Response" + response.body().getData());
                if (response.body().getStatus() == 1) {
                    List<WalletdataTopUpModel.DataBean> tempData = response.body().getData();
                    setData(tempData);
                } else {
                    DisplaySnackBar.showSnackBar(getActivity(), response.body().getMessage());
                }
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }

            @Override
            public void onFailure(Call<WalletdataTopUpModel> call, Throwable t) {
                Log.e("DashBoard", "Failure" + t.toString());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }
        });
    }

    private void setData(List<WalletdataTopUpModel.DataBean> body) {
        data=body;
        Log.e("SetData","SetData"+data.size());
        if(data.size()==0){
            DisplaySnackBar.showSnackBar(getActivity(),"TopUp Wallet is Empty");
        }else{
            adapter = new WalletTopUpAdapter(getActivity(),data);
            rcMain.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }


    private void initView(View view) {
        title = view.findViewById(R.id.title);
        balance = view.findViewById(R.id.tv_currency);
        credit = view.findViewById(R.id.credit);
        debit = view.findViewById(R.id.debit);
        rcMain = view.findViewById(R.id.rc_main);

        title.setText("Topup Wallet");
        data= new ArrayList<>();
        layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rcMain.setLayoutManager(layoutManager);

    }

}
