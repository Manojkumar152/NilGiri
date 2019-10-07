package com.app.nilgiri.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.Notification;
import com.app.nilgiri.Models.ProfileData;
import com.app.nilgiri.Models.WalletBalance;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;
import com.app.nilgiri.Utils.SessionManager;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardFragment extends Fragment implements View.OnClickListener{
    private TextView m_all_team_left,m_all_team_right,m_all_team_direct;
    private TextView m_non_active_member_left,m_non_active_member_right,m_non_active_member_direct;
    private TextView m_active_member_left,m_active_member_right,m_active_member_direct;
    private TextView m_direct_member_left,m_direct_member_right,m_direct_member_direct;
    private TextView m_sales_left,m_sales_right,m_sales_direct;
    private TextView m_payout_balance,m_topup_balance,m_shopping_balance;
    private TextView m_tv_name,m_tv_username,m_tv_email,m_tv_city,sale_active,latest_update_text,
                     sponser_name,direct_sponser,created_at,activated_at;
    private RelativeLayout m_relative_layout_active,mdivTreeview,mdivProfile,mdivBank;
    private SessionManager session;
    View view;
    SharedPreferences pref;
    private SharedPreferences.Editor editor;
    String companyId;
    private CircleImageView userImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.layout_gridview_dashboard,container,false);
        initId(view);
        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        editor = pref.edit();

        companyId=pref.getString("company_id",null);
        if(ConnectionDetection.isInternetAvailable(getContext())) {
            getDashboardData(companyId);
            getNotification(companyId);
        }
        else{
            DisplaySnackBar.showSnackBar(getActivity(),"Internert Connection Error");
        }
        Log.e("CompanyId","CompanyID"+"  "+companyId);
        return view;
    }

    private void initId(View v){
        m_tv_name = v.findViewById(R.id.tv_name);
        m_tv_username = v.findViewById(R.id.txt_username);
        m_tv_email = v.findViewById(R.id.tv_email);
        m_tv_city = v.findViewById(R.id.txt_city);
        sale_active = v.findViewById(R.id.sale_active);
        sponser_name=v.findViewById(R.id.sponser_username);
        direct_sponser=v.findViewById(R.id.direct_sponser);
        created_at=v.findViewById(R.id.joining);
        activated_at=v.findViewById(R.id.active_date);
        latest_update_text=v.findViewById(R.id.latest_update);
        userImage=v.findViewById(R.id.iv_imgProfile);
        latest_update_text.setSelected(true);

        mdivTreeview=v.findViewById(R.id.divtreeview);
        mdivTreeview.setOnClickListener(this);

        mdivProfile=v.findViewById(R.id.divprofile);
        mdivProfile.setOnClickListener(this);

        mdivBank= v.findViewById(R.id.divbank_details);
        mdivBank.setOnClickListener(this);

        m_all_team_left = v.findViewById(R.id.tv_all_team_left);
        m_all_team_right = v.findViewById(R.id.tv_all_team_right);
        m_all_team_direct = v.findViewById(R.id.tv_all_team_direct);

        m_non_active_member_left = v.findViewById(R.id.tv_non_direct_left);
        m_non_active_member_right = v.findViewById(R.id.tv_non_active_right);
        m_non_active_member_direct = v.findViewById(R.id.tv_non_active_direct);

        m_active_member_left = v.findViewById(R.id.tv_active_left);
        m_active_member_right = v.findViewById(R.id.tv_active_right);
        m_active_member_direct = v.findViewById(R.id.tv_active_direct);

        m_direct_member_left = v.findViewById(R.id.tv_direct_left);
        m_direct_member_right = v.findViewById(R.id.tv_direct_right);
        m_direct_member_direct = v.findViewById(R.id.tv__direct_direct);

        m_sales_left = v.findViewById(R.id.tv_sales_left);
        m_sales_right = v.findViewById(R.id.tv_sales_right);
        m_sales_direct = v.findViewById(R.id.tv_sales_direct);

        m_payout_balance = v.findViewById(R.id.payout_balance);
        m_topup_balance = v.findViewById(R.id.topup_balance);
        m_shopping_balance = v.findViewById(R.id.shopping_balance);

    }

    private void getDashboardData(final String company_id) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showProgress();
        }

        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<ProfileData> call=service.getProfile(company_id,Urls.API_KEY);
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                Log.e("ResponseData","ResponseData");

                if(response.body().getStatus()==1){
                    Log.e("ResponseData","ResponseData  "+response.body());
                    setData(response.body());
                    getPayoutBalance(companyId);
                }
                else {
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage().toString());
                }
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
                if(getActivity()!=null) {
                    ((BaseActivity) getActivity()).hideProgress();
                }
            }
        });
    }

    private void getPayoutBalance(String company_id) {
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<WalletBalance> call=service.getPayoutBalance(company_id,Urls.API_KEY);
        call.enqueue(new Callback<WalletBalance>() {
            @Override
            public void onResponse(Call<WalletBalance> call, Response<WalletBalance> response) {
                Log.e("ResponseData","ResponseData");
                if(response.body()!=null) {
                    Log.e("ResponseData","ResponseData"+response.body());
                    m_payout_balance.setText(response.body().getData().getBalance_total());
                   // getShoppingWallet(companyId,response.body().getData().getBalance_total());
                }
                else {
                    DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage().toString());
                }
            }

            @Override
            public void onFailure(Call<WalletBalance> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
            }
        });
    }

    private void getShoppingWallet(final String company_id, final String payoutBal) {
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<WalletBalance> call=service.getShoppingBalance(company_id,Urls.API_KEY);
        call.enqueue(new Callback<WalletBalance>() {
            @Override
            public void onResponse(Call<WalletBalance> call, Response<WalletBalance> response) {
                Log.e("ShoppingWallet","ResponseData");
                try {
                    if (response.body().getStatus() == 1) {
                        Log.e("Shopping Balance","Shopping Balance"+response.body());
                        m_shopping_balance.setText(response.body().getData().getBalance_total());
                        getTopUpWallet(companyId,payoutBal,response.body().getData().getBalance_total());
                    } else {
                        DisplaySnackBar.showSnackBar(getActivity(), response.body().getMessage().toString());
                    }
                }catch (NullPointerException ex){

                }
            }

            @Override
            public void onFailure(Call<WalletBalance> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
            }
        });
    }


    private void getTopUpWallet(String company_id, final String payoutBalance, final String shoppingBalance) {
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<WalletBalance> call=service.getTopupBalance(company_id,Urls.API_KEY);
        call.enqueue(new Callback<WalletBalance>() {
            @Override
            public void onResponse(Call<WalletBalance> call, Response<WalletBalance> response) {
                Log.e("TopUpData","ResponseData");
                m_topup_balance.setText(response.body().getData().getBalance_total());
                if(payoutBalance.length()==0){
                    m_payout_balance.setText("0.00");
                }
                if(shoppingBalance.length()==0){
                    m_shopping_balance.setText("0.000");
                }
                if(response.body().getData().getBalance_total().length()==0){
                    m_topup_balance.setText(response.body().getData().getBalance_total());
                }
            }

            @Override
            public void onFailure(Call<WalletBalance> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
            }
        });
    }

    private void getNotification(String company_id) {
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<Notification> call=service.getNotification(Urls.API_KEY);
        call.enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {
                try{

                    Log.e("ResponseData","ResponseData");
                    if(response.body().getStatus()==1){
                        Log.e("ResponseData","ResponseData"+response.body());
                        // for(int i=0;i<response.body().getData().size();i++){
                        StringBuilder builder = new StringBuilder();
                        for (String value : response.body().getData()) {
                            builder.append(" "+value);
                        }
                        String text = builder.toString();
                        ///}
                        latest_update_text.setText(text);
                    }
                    else{
                        DisplaySnackBar.showSnackBar(getActivity(),response.body().getMessage());
                    }
                }catch (Exception e){
                    e.getStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                Log.e("DashBoard","Failure"+t.toString());
            }
        });
    }


    private void setData(ProfileData body) {
        m_tv_name.setText(body.getData().getName());
        m_tv_username.setText(body.getData().getUsername());
        m_tv_email.setText(body.getData().getEmail());
        m_tv_city.setText(body.getData().getCity());
        sponser_name.setText(body.getData().getSponser_username());
        direct_sponser.setText(body.getData().getDirect_sponser_username());
        created_at.setText(body.getData().getCreated_at());
        activated_at.setText(body.getData().getSales_active_date());
        Picasso.with(getActivity()).load(Urls.PROFILE_IMAGE_URL + body.getUsers().getAvatar())
                .into(userImage);
        if(body.getData().getSales_active().equals("1")){
            sale_active.setText("Active");
            sale_active.setBackgroundResource(R.drawable.rectangular_shape_green);
        }
        else{
            sale_active.setText("In Active");
            sale_active.setBackgroundResource(R.drawable.inactive_user_bg);
        }
        /*****Save data to SharedPref*********/
        editor.putString("name",body.getData().getName());
        editor.putString("username",body.getData().getUsername());
        editor.putString("email",body.getData().getEmail());
        editor.putString("city",body.getData().getCity());
        editor.putString("status",body.getData().getSales_active());
        editor.putString("image",body.getUsers().getAvatar());
        editor.commit();

        m_all_team_left.setText(String.valueOf(body.getData().getMember_sale().getMember().getLeft()));
        m_all_team_right.setText(String.valueOf(body.getData().getMember_sale().getMember().getRight()));
        m_all_team_direct.setText(String.valueOf(body.getData().getMember_sale().getMember().getDirect()));

        m_non_active_member_left.setText(String.valueOf(body.getData().getMember_sale().getNon_active_member().getLeft()));
        m_non_active_member_right.setText(String.valueOf(body.getData().getMember_sale().getNon_active_member().getRight()));
        m_non_active_member_direct.setText(String.valueOf(body.getData().getMember_sale().getNon_active_member().getDirect()));

        m_active_member_left.setText(String.valueOf(body.getData().getMember_sale().getActive_member().getLeft()));
        m_active_member_right.setText(String.valueOf(body.getData().getMember_sale().getActive_member().getRight()));
        m_active_member_direct.setText(String.valueOf(body.getData().getMember_sale().getActive_member().getDirect()));

        m_direct_member_left.setText(String.valueOf(body.getData().getMember_sale().getDirect_member().getLeft()));
        m_direct_member_right.setText(String.valueOf(body.getData().getMember_sale().getDirect_member().getRight()));
        m_direct_member_direct.setText(String.valueOf(body.getData().getMember_sale().getDirect_member().getDirect()));

        m_sales_left.setText(String.valueOf(body.getData().getMember_sale().getSale().getLeft()));
        m_sales_right.setText(String.valueOf(body.getData().getMember_sale().getSale().getRight()));
        m_sales_direct.setText(String.valueOf(body.getData().getMember_sale().getSale().getDirect()));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.divtreeview:
                setFragment(new MyTreeViewFragment());
                break;
            case R.id.divprofile:
                setFragment(new FragmentProfile());
                break;
            case R.id.divbank_details:
                setFragment(new FragmentBankDetail());
                break;
        }

    }
    public void setFragment(Fragment fragment) {
        Log.e("SetFragment","SetFragmenyt");
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

}
