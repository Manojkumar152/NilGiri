package com.app.nilgiri.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nilgiri.Adapter.PayoutListAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.PayoutDetails;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPayout extends Fragment {
    private RecyclerView mrecyclerView;
    private PayoutListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;;
    private ViewPager viewPager;
    private ImageView mDot1,mDot2,mDot3;
    TabLayout mTabLayout;
    int i = 0;
    View v;
    SharedPreferences pref;
    TextView username;
    String name;
    List<PayoutDetails.DataBean.PayoutDetailBean> data;
    public static final int PAGE_START = 1;
    private int currentPage = PAGE_START;
    private boolean isLastPage = false;
    private int totalPage = 10;
    private boolean isLoading = false;
    int itemCount = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_payouts,container,false);

        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        String companyId=pref.getString("company_id",null);
        initId(v);
        if(ConnectionDetection.isInternetAvailable(getActivity())) {
            getPayoutDetails(companyId);
        }else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
        return v;
    }

    private void getPayoutDetails(String companyId) {
        if(getActivity()!=null) {
            ((BaseActivity) getActivity()).showProgress();
        }

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<PayoutDetails> call=service.getPayoutDetails(companyId,Urls.API_KEY);
        call.enqueue(new Callback<PayoutDetails>() {
            @Override
            public void onResponse(Call<PayoutDetails> call, Response<PayoutDetails> response) {
                Log.e("Payout_Response", "Response" + response.body().getData() + "  " + response.body().getMessage());

                if(response.body().getStatus()==1) {
                    name = response.body().getData().getUsername();

                    username.setText(name);
                    List<PayoutDetails.DataBean.PayoutDetailBean> data=response.body().getData().getPayout_detail();
                    Log.e("before","Before"+data.get(1).getDate());
                    //Collections.sort(data);
                   // Log.e("AFTEr","AFter"+data.get(1).getDate());
                    setData(data);
                } else {
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                }
                if (getActivity() != null){
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }

            @Override
            public void onFailure(Call<PayoutDetails> call, Throwable t) {
                Log.e("DashBoard", "Failure" + t.toString());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }
        });
    }

    private void setData(List<PayoutDetails.DataBean.PayoutDetailBean> data) {
        this.data = data;

        adapter = new PayoutListAdapter(getActivity(), this.data);
        mrecyclerView.setAdapter(adapter);
    }

    private void initId(View v){
        username=v.findViewById(R.id.username);
        mrecyclerView = v.findViewById(R.id.recyclerview);

        data=new ArrayList<>();

        adapter = new PayoutListAdapter(getActivity(), data);
        linearLayoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mrecyclerView.setLayoutManager(linearLayoutManager);
        mrecyclerView.setAdapter(adapter);


    }

}
