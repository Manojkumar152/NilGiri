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
import android.widget.SearchView;
import android.widget.TextView;

import com.app.nilgiri.Adapter.MyTeamAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.MyTeamModel;
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


public class FragmentMyTeam extends Fragment {
    private RecyclerView recyclerView;
    private MyTeamAdapter adapter;
    private ImageView mImageProfile;
    private TextView mName, mUserName, mEmail, mCity, mSales, mRank, mAction;
    private View v;
    public static final int PAGE_START = 1;
    private int currentPage = PAGE_START;
    private boolean isLastPage = false;
    private int totalPage = 10;
    private boolean isLoading = false;
    int itemCount = 0;
    private LinearLayoutManager mlayoutManager;
    List<MyTeamModel.DataBean> tempData;
    ArrayList<MyTeamModel.DataBean> listData  = new ArrayList<>();
    private SharedPreferences pref;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_direct_team, container, false);

        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        String companyId=pref.getString("company_id",null);

        iniId(v);
        adapter();
        if(ConnectionDetection.isInternetAvailable(getActivity())){
            getMyTeamData(companyId);
        }else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
        return v;
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


        SearchView searchView=(SearchView)v.findViewById(R.id.search);
        search(searchView);

    }

    private void adapter(){
        mlayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void getMyTeamData(String company_id) {
        if (getActivity()!= null) {
            ((BaseActivity)getActivity()).showProgress();
        }

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<MyTeamModel> call=service.getMyTeam(company_id,Urls.API_KEY);
        call.enqueue(new Callback<MyTeamModel>() {
            @Override
            public void onResponse(Call<MyTeamModel> call, Response<MyTeamModel> response) {

                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }

                Log.e("Response","Response"+response.body().getData());
                if(response.body().getStatus()==1){
                    setData(response.body());
                }
                else{
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<MyTeamModel> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
            }
        });
    }

    private void setData(MyTeamModel body) {
        Log.e("Data","DataMyTEam"+body.getData());
        tempData = body.getData();
        listData.clear();
        listData.addAll(tempData);
        adapter= new MyTeamAdapter(getActivity(),listData);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }



    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText=newText.toLowerCase();
              //  ArrayList<UserInfo> newList=new ArrayList<>();
                adapter.setFilter(listData);
                return true;
            }
        });
    }

    public void setFilter(List<MyTeamModel.DataBean> data){
        data=new ArrayList<>();
        data.addAll(listData);
        adapter.notifyDataSetChanged();
    }
}
