package com.app.nilgiri.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.Toast;

import com.app.nilgiri.Adapter.MyTeamLeftAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Common.PaginationScrollListener;
import com.app.nilgiri.Models.MyTeamLeftModel;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;
import com.paginate.Paginate;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Challenge;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;
import static com.app.nilgiri.Fragments.FragmentPayout.PAGE_START;

public class FragmentLeftTeam extends Fragment  {
    private View v ;
    private RecyclerView recyclerView;
    private MyTeamLeftAdapter adapter;
    private ImageView mImageProfile;
    private TextView mName,mUserName,mEmail,mCity,mSales,mRank,mAction;


    ProgressBar progressBar;
    ArrayList<MyTeamLeftModel.DataBean.LeftTeamBean> listData  = new ArrayList<>();
    SharedPreferences pref;

    final int pageSize = 20;
   // int mCurrentPage = 1;
    public static  int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int page = 1;
    String companyId  ;
    private int currentPage = PAGE_START;
    private int totalPage = 10;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_direct_team,container,false);

        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        companyId =pref.getString("company_id",null);

        iniId(v);
        initAdapter();
      //  getData();
        if(ConnectionDetection.isInternetAvailable(getActivity())){
            getMyTeamLeftData(companyId);
        }else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
        return v;
    }

    private  void iniId(View v){
        recyclerView = v.findViewById(R.id.recyclerwview);
        mImageProfile = v.findViewById(R.id.iv_imageProfile);
        mName = v.findViewById(R.id.tv_name);
        mUserName = v.findViewById(R.id.txt_username);
        mEmail = v.findViewById(R.id.tv_email);
        mCity = v.findViewById(R.id.txt_city);
        mSales = v.findViewById(R.id.sale_active);
        progressBar = (ProgressBar) v.findViewById(R.id.progress_bar);

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

    }

    LinearLayoutManager mlayoutManager;
    private  void initAdapter(){
        adapter = new MyTeamLeftAdapter(getContext(),listData);
        mlayoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new PaginationScrollListener(mlayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage++;
              //  doApiCall();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadNextPage();
                    }
                }, 1000);
            }
            
            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

        });

    }
    private void getMyTeamLeftData(String company_id) {
        if (getActivity()!= null) {
            ((BaseActivity)getActivity()).showProgress();
        }
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);

        Call<MyTeamLeftModel> call=service.getLeftTeam(company_id,Urls.API_KEY,PAGE_START);
        call.enqueue(new Callback<MyTeamLeftModel>() {
            @Override
            public void onResponse(Call<MyTeamLeftModel> call, Response<MyTeamLeftModel> response) {
                Log.e("Response","Response"+response.body().getData());
                if(response.body().getStatus()==1){
                  //  setData(response.body().getData());
                   // listData.clear();
                    listData.addAll(response.body().getData().getLeftTeam());
                    recyclerView.setAdapter(adapter);
               //     adapter.notifyDataSetChanged();
                 //   adapter.addBottomitem();

                    if(currentPage<=totalPage){
                        adapter.addBottomitem();
                    }else {
                        isLastPage=true;
                    }
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

    private void setData(MyTeamLeftModel.DataBean data) {
        listData.clear();
        listData.addAll(data.getLeftTeam());
        adapter.notifyDataSetChanged();
    }


    private   void loadNextPage(){
        progressBar.setVisibility(View.VISIBLE);
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);

        Call<MyTeamLeftModel> call=service.getLeftTeam(companyId,Urls.API_KEY,currentPage);
        call.enqueue(new Callback<MyTeamLeftModel>() {
            @Override
            public void onResponse(Call<MyTeamLeftModel> call, Response<MyTeamLeftModel> response) {
                Log.e("Response","Response"+response.body().getData());
                if(response.body().getStatus()==1) {
                    //  setData(response.body().getData());
                    //     adapter.notifyDataSetChanged();

                    if (getActivity() != null) {
                        ((BaseActivity) getActivity()).hideProgress();
                    }
                    List<MyTeamLeftModel.DataBean.LeftTeamBean> tempdata = response.body().getData().getLeftTeam();
                    adapter.removedLastEmptyItem();
                    isLoading = false;
                    adapter.addAll(tempdata);

                    if (currentPage != totalPage) {
                        adapter.addBottomitem();
                    } else {
                        isLastPage = true;
                    }
                    progressBar.setVisibility(View.GONE);

                }else{
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
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
