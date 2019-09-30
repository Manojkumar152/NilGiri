package com.app.nilgiri.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.nilgiri.Adapter.AdminAdapter;
import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.AdminTdsCharge;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminCharge extends Fragment {
    private RecyclerView rc_main;
    private List<AdminTdsCharge.DataBean> data;
    private LinearLayoutManager linearManager;
    private String company_id;
    AdminAdapter adapter;
    SharedPreferences pref;
    ProgressDialog dialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_admin_charge,container,false);

        initView(view);
        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        company_id = pref.getString("company_id",null);

        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Please Wait..");
        if(ConnectionDetection.isInternetAvailable(getActivity())){
            getAdminTdsCharge();
        }else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
        return view;
    }


    private void getAdminTdsCharge() {
        dialog.show();
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<AdminTdsCharge> call=service.getAdminTdsCharge(company_id,Urls.API_KEY);
        call.enqueue(new Callback<AdminTdsCharge>() {
            @Override
            public void onResponse(Call<AdminTdsCharge> call, Response<AdminTdsCharge> response) {
                dialog.dismiss();
                try {
                    Log.e("Response","ADMINResponse"+response.body());
                    if(response.body().getStatus()==1) {
                        data = response.body().getData();
                        adapter = new AdminAdapter(getActivity(), data);
                        rc_main.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                    }
                }catch (Exception e){
                    e.getStackTrace();
                }

            }

            @Override
            public void onFailure(Call<AdminTdsCharge> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                dialog.dismiss();
            }
        });
    }

    private void initView(View view) {
        rc_main=view.findViewById(R.id.rc_main);
        TextView title = view.findViewById(R.id.title);
        title.setText("Admin Charge");
        data= new ArrayList<>();

        linearManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_main.setLayoutManager(linearManager);
        adapter= new AdminAdapter(getActivity(),data);
        rc_main.setAdapter(adapter);
        rc_main.setHasFixedSize(true);
    }
}
