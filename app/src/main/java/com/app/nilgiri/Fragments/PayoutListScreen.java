package com.app.nilgiri.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.app.nilgiri.Adapter.PayoutAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.Payouts;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayoutListScreen extends BaseActivity {
    private RecyclerView rcMain;
    private LinearLayoutManager linearManager;
    private List<Payouts.DataBean> list;
    private PayoutAdapter adapter;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payout_list_screen);
        initView();
       /* pref = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        String companyId=pref.getString("company_id",null);*/
        String payout= getIntent().getStringExtra("payout_id");
        Log.e("ID","ID"+payout+ "  "+getIntent().getStringExtra("payout_id"));
        if(ConnectionDetection.isInternetAvailable(this)){
            getPayouts(payout);
        }
        else{
            DisplaySnackBar.showSnackBar(this,getString(R.string.internet_error));
        }
    }

    private void getPayouts(String payout) {
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<Payouts> call=service.getPayoutList(payout,Urls.API_KEY);
        call.enqueue(new Callback<Payouts>() {
            @Override
            public void onResponse(Call<Payouts> call, Response<Payouts> response) {
                Log.e("Payout_Response","Response"+response.body().getData()+"  "+response.body().getMessage());
                if(response.body().getStatus()==1) {
                    list = response.body().getData();
                    adapter = new PayoutAdapter(PayoutListScreen.this, list);
                    rcMain.setAdapter(adapter);
                }else{
                    DisplaySnackBar.showSnackBar(PayoutListScreen.this,response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<Payouts> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                DisplaySnackBar.showSnackBar(PayoutListScreen.this,t.toString());
            }
        });
    }

    private void initView() {
        list= new ArrayList<>();
        rcMain= findViewById(R.id.rc_main);

        linearManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcMain.setLayoutManager(linearManager);
        adapter= new PayoutAdapter(this,list);
        rcMain.setAdapter(adapter);
    }
}
