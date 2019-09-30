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

import com.app.nilgiri.Adapter.MyHistoryAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.OrderHistory;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOrderHistory extends Fragment {
    private MyHistoryAdapter adpter;
    private RecyclerView recyclerView;
    private View v;
    private BaseActivity baseActivity;
    private LinearLayoutManager mlayoutManager;
    SharedPreferences pref;
    private List<OrderHistory.DataBean.OrderhistoryBean> data;
    String address,localAdd;
    TextView total_amount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_order_histrory, container, false);

        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        String companyId=pref.getString("company_id",null);
        initId(v);

        if(ConnectionDetection.isInternetAvailable(getActivity())){
            getOrderHistoryData(companyId);
        }else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
        initAdapter();
        return v;
    }

    private void getOrderHistoryData(String company_id) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showProgress();
        }
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<OrderHistory> call=service.getOrderHistory(company_id,Urls.API_KEY);
        call.enqueue(new Callback<OrderHistory>() {
            @Override
            public void onResponse(Call<OrderHistory> call, Response<OrderHistory> response) {
                Log.e("Order_Response", "Response" + response.body().getData() + "  " + response.body().getMessage());
                try {
                    if(response.body().getStatus()==1) {
                        setOrderHistoryData(response.body());
                    }else{
                        DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                    }

                    if (getActivity() != null) {
                        ((BaseActivity) getActivity()).hideProgress();
                    }

                }catch (Exception e){
                   e.getStackTrace();
                }
            }

            @Override
            public void onFailure(Call<OrderHistory> call, Throwable t) {
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                    Log.e("DashBoard", "Failure" + t.toString());
                }
            }
        });
    }

    private void setOrderHistoryData(OrderHistory body) {
        total_amount.setText(body.getData().getOrderhistory().get(0).getTotal());
        data=body.getData().getOrderhistory();
        try {
            address = body.getData().getAddress().getAddress();
            localAdd= body.getData().getAddress().getCity_text()+" "+body.getData().getAddress().getState_text()+" "+body.getData().getAddress().getCountry();
        }
        catch (NullPointerException ex){

        }
        adpter = new MyHistoryAdapter(getActivity(),address,localAdd,data);
        recyclerView.setAdapter(adpter);
    }


    private void initId(View v) {
        recyclerView = v.findViewById(R.id.recycleview_history);
        total_amount=v.findViewById(R.id.total_amount);
    }

    private void initAdapter() {
        data= new ArrayList<>();
        adpter = new MyHistoryAdapter(getActivity(),address,localAdd,data);
        mlayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(adpter);
        recyclerView.setHasFixedSize(true);
    }
}
