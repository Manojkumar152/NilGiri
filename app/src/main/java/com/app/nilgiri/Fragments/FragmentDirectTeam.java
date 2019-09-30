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

import com.app.nilgiri.Adapter.MyTeamDirectAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.MyTeamDirectModel;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.DisplaySnackBar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDirectTeam extends Fragment {
    private View v;
    private RecyclerView recyclerView;
    private MyTeamDirectAdapter adapter;
    private ImageView mImageProfile;
    private TextView mName,mUserName,mEmail,mCity,mSales,mRank,mAction;

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;
    // The minimum amount of items to have below your current scroll position
    // before loading more.
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount ;
    private boolean loading = false;
    ProgressBar progressBar;
    public static int itemsCount = 10;
    int pastVisiblesItems = 0;
    int visibleItemCount = 0;
    private  int mLoadedItems = 0;
    private BaseActivity baseActivity;
    List<MyTeamDirectModel.DataBean> tempData;
    ArrayList<MyTeamDirectModel.DataBean> listData  = new ArrayList<>();
    SharedPreferences pref;
    private String companyId = "";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_direct_team,container,false);
        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        companyId=pref.getString("company_id",null);

        iniId(v);
        initAdapter();

        getMyTeamDirectData(companyId);
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

    LinearLayoutManager mlayoutManager;
    private  void initAdapter(){
        adapter = new MyTeamDirectAdapter(getContext(),listData);
        mlayoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
               /* if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    loading = false;
                }*/
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) //check for scroll down
                {
                    visibleItemCount = mlayoutManager.getChildCount();
                    totalItemCount = mlayoutManager.getItemCount();
                    pastVisiblesItems = mlayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems<= totalItemCount) {
                            loading =false;
                            Log.v("Pagination>>>>", "Last Item Wow !");
                            //Do pagination.. i.e. fetch new data
                           // getlistData();
                        }
                    }else{
                        if(loading==false) {
                            if(visibleItemCount + pastVisiblesItems <=totalItemCount);
                             //   getlistData();
                        }
                    }
                }
            }
        });
    }

    private void getMyTeamDirectData(String companyId) {
        if (getActivity()!= null) {
            ((BaseActivity)getActivity()).showProgress();
        }

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<MyTeamDirectModel> call=service.getDirectTeam(companyId,Urls.API_KEY);
        call.enqueue(new Callback<MyTeamDirectModel>() {
            @Override
            public void onResponse(Call<MyTeamDirectModel> call, Response<MyTeamDirectModel> response) {
                Log.e("Response","Response"+response.body().getData());
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
                if(response.body().getStatus()==1) {
                    setData(response.body());
                }else{
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage().toString());
                }
            }

            @Override
            public void onFailure(Call<MyTeamDirectModel> call, Throwable t) {
                Log.e("DashBoard", "Failure" + t.toString());
                if (getActivity() != null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }
        });
    }

    private void setData(MyTeamDirectModel body) {
        Log.e("Data","DataMyTEam"+body.getData());
        tempData = body.getData();
        listData.clear();
        listData.addAll(tempData);
        adapter.notifyDataSetChanged();

    }
}
