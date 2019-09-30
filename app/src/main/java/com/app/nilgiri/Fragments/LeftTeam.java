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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.nilgiri.Adapter.LeftAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.MyTeamLeftModel;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class LeftTeam extends Fragment {
    private  View view;
    private SharedPreferences pref;
    private RecyclerView recyclerView;
    private LeftAdapter adapter;
    private ImageView mImageProfile;
    private TextView mName,mUserName,mEmail,mCity,mSales,mAction;
    ProgressBar progressBar;
    List<MyTeamLeftModel.DataBean> tempData;
    ArrayList<MyTeamLeftModel.DataBean> listData;
    private LinearLayoutManager mLayoutManager;
    private int currentPage=0;
    String companyId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_direct_team,container,false);
        pref = getActivity().getSharedPreferences("LOGIN",Context.MODE_PRIVATE);
        companyId=pref.getString("company_id",null);

        iniId(view);
        initAdapter();
       // initAdapter();
           if(ConnectionDetection.isInternetAvailable(getActivity())){
            getMyTeamLeftData(companyId);
        }else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
       return view;
    }



    private void iniId(View v) {
        recyclerView = v.findViewById(R.id.recyclerwview);
        mImageProfile = v.findViewById(R.id.iv_imageProfile);
        mName = v.findViewById(R.id.tv_name);
        mUserName = v.findViewById(R.id.txt_username);
        mEmail = v.findViewById(R.id.tv_email);
        mCity = v.findViewById(R.id.txt_city);
        mSales = v.findViewById(R.id.sale_active);

        mName.setText(pref.getString("name",null));
        mUserName.setText(pref.getString("username",null));
        mEmail.setText(pref.getString("email",null));
        mCity.setText(pref.getString("city",null));
        mSales.setText(pref.getString("status",null));
        Picasso.with(getActivity()).load(Urls.PROFILE_IMAGE_URL + pref.getString("image",null))
                .into(mImageProfile);

        if(pref.getString("status",null).equals("1")){
            mSales.setText("Active");
            mSales.setBackgroundResource(R.drawable.rectangular_shape_green);
        }
        else{
            mSales.setText("In Active");
            mSales.setBackgroundResource(R.drawable.inactive_user_bg);
        }
        mAction = v.findViewById(R.id.txt_action);
        progressBar = v.findViewById(R.id.progressBar);
    }
    private void initAdapter() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        // mRecyclerView.setHasFixedSize(true);
        listData  = new ArrayList<>();
        adapter = new LeftAdapter(getActivity(),recyclerView,listData);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        currentPage=0;
        adapter.setMoreDataAvailable(true);
        // add load more listener
        adapter.setLoadMoreListener(new LeftAdapter.OnLoadMoreListener() {

            @Override
            public void onLoadMore() {
                Log.e(TAG, "onLoadMore");
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getContext(), "runnable here", Toast.LENGTH_LONG).show();
                        Log.e(TAG, "outside if current Page " + currentPage);
                        Log.e(TAG, "outside if  total pages" );
                        currentPage = currentPage + 1;
                        if (currentPage <= 5) {
                            loadMore(currentPage,companyId);// a method which requests remote data
                        }
                    }
                });
            }
        });
    }

    private void loadMore(int currentPage, String company_id) {
        if (getActivity()!= null) {
            ((BaseActivity)getActivity()).showProgress();
        }

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        listData.add(new MyTeamLeftModel.DataBean("load"));
        adapter.notifyItemInserted(listData.size()-1);
        Call<MyTeamLeftModel> call=service.getLeftTeam(company_id,Urls.API_KEY);
        call.enqueue(new Callback<MyTeamLeftModel>() {
            @Override
            public void onResponse(Call<MyTeamLeftModel> call, Response<MyTeamLeftModel> response) {
                Log.e("Response","Response"+response.body().getData());
                if(response.body().getStatus()==1){
                }else{
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                }
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
            }

            @Override
            public void onFailure(Call<MyTeamLeftModel> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
            }
        });
    }

    private void getMyTeamLeftData(String company_id) {
        if (getActivity()!= null) {
            ((BaseActivity)getActivity()).showProgress();
        }

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<MyTeamLeftModel> call=service.getLeftTeam(company_id,Urls.API_KEY);
        call.enqueue(new Callback<MyTeamLeftModel>() {
            @Override
            public void onResponse(Call<MyTeamLeftModel> call, Response<MyTeamLeftModel> response) {
                Log.e("Response","Response"+response.body().getData());
                if(response.body().getStatus()==1){
                    //setData(response.body());
                }else{
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                }
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
            }

            @Override
            public void onFailure(Call<MyTeamLeftModel> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
            }
        });
    }
}
