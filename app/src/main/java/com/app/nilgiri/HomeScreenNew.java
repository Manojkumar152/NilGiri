package com.app.nilgiri;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.app.nilgiri.Fragments.AdminCharge;
import com.app.nilgiri.Fragments.DashBoardFragment;
import com.app.nilgiri.Fragments.FragmentBankDetail;
import com.app.nilgiri.Fragments.FragmentDirectTeam;
import com.app.nilgiri.Fragments.FragmentLeftTeam;
import com.app.nilgiri.Fragments.FragmentMyTeam;
import com.app.nilgiri.Fragments.FragmentOrderHistory;
import com.app.nilgiri.Fragments.FragmentPayout;
import com.app.nilgiri.Fragments.FragmentProfile;
import com.app.nilgiri.Fragments.FragmentRightTeam;
import com.app.nilgiri.Fragments.FragmentUpdateKYC;
import com.app.nilgiri.Fragments.MyTreeViewFragment;
import com.app.nilgiri.Fragments.PayoutWalletFragment;
import com.app.nilgiri.Fragments.ShoppingWalletFragment;
import com.app.nilgiri.Fragments.TDSCharge;
import com.app.nilgiri.Fragments.TopupWalletFragment;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.DisplaySnackBar;
import com.app.nilgiri.Utils.SessionManager;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class HomeScreenNew extends BaseActivity implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
    private ImageView img_user;
    private ImageButton btnBack, btnMenu, tMsg, tWorkout;
    private PopupWindow mPopupWindow;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private ActionBarDrawerToggle toggle;
    ImageView imgdashboard;
    RecyclerView recyclerView;
    private ConstraintLayout container;
    private SwipeRefreshLayout refreshLayout;
    private TextView textTitle, header_text;
    private TextView tv_name, tv_addr;
    private Toolbar toolbar;
    private ExpandableLayout expandableLayout, expandableLayout2,report_layout;
    SessionManager session;
    private DrawerLayout drawer;
    private String Title = "Dashboard";
    private String TAG = "HomeActivity";
    FragmentManager fragmentManager;
    Fragment fragment;
    ProgressDialog progressDialog;
    ImageView logout;
    //LinearLayout item_team;
    private TextView item_dashboard,item_add_client,item_update_kyc,item_tree_view,item_payout,item_report,item_history,item_profile,item_wallet,item_payoutwallet,
                     item_topupwallet,item_shoppingwallet,item_team,item_myteam,item_rightteam,item_leftteam,item_directteam,item_bank_details,admin_charge,tds_charge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //checkConnection();
        session = new SessionManager(getApplicationContext());
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        logout=findViewById(R.id.logout);

        setView();
        setViewContainer();
        fragmentManager = getSupportFragmentManager();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

//        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        setupFragmentManager();
        fragment = new DashBoardFragment();
        if (fragment != null) {
            //mTitlenname.setText(R.string.profile);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });
    }

    private void logoutUser() {
        SharedPreferences preferences =getSharedPreferences("LOGIN",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        Intent i = new Intent(this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        //Toasty.success(_context, "You have successfully logged out").show();
        DisplaySnackBar.showSnackBar(this,"You have successfully logged out");
    }

    private void checkConnection() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        alertMassege(activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }

    private void alertMassege(boolean isConnected) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final AlertDialog alertDialog;
        if (!isConnected) {

            alertDialogBuilder.setMessage("No Internet Connection Available." +
                    "Do you want to try again?");
            alertDialogBuilder.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            HomeScreenNew.super.recreate();
                        }
                    });
            alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    HomeScreenNew.this.finish();
                }
            });
            alertDialogBuilder.setCancelable(false);
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }

    private void setView() {
        expandableLayout = findViewById(R.id.expandable_layout);
        expandableLayout.setOnExpansionUpdateListener(this);
        expandableLayout2 = findViewById(R.id.expandable_layout2);
        expandableLayout2.setOnExpansionUpdateListener(this);
        report_layout = findViewById(R.id.report_layout);
        report_layout.setOnExpansionUpdateListener(this);

        item_wallet=findViewById(R.id.item_wallet);
        item_wallet.setOnClickListener(this);
        item_team=findViewById(R.id.team);
        item_team.setOnClickListener(this);


        header_text = findViewById(R.id.header_text);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnMenu = findViewById(R.id.btn_menu);
        btnMenu.setOnClickListener(this);


        item_dashboard = findViewById(R.id.dashboard);
        item_dashboard.setOnClickListener(this);
        item_add_client = findViewById(R.id.add_client);
        item_add_client.setOnClickListener(this);

        item_update_kyc = findViewById(R.id.update_kyc);
        item_update_kyc.setOnClickListener(this);

        item_tree_view = findViewById(R.id.tree_view);
        item_tree_view.setOnClickListener(this);
        item_payout = findViewById(R.id.payouts);
        item_payout.setOnClickListener(this);
        item_report = findViewById(R.id.reports);
        item_report.setOnClickListener(this);
        admin_charge=findViewById(R.id.admin_charge);
        admin_charge.setOnClickListener(this);
        tds_charge=findViewById(R.id.tds_charge);
        tds_charge.setOnClickListener(this);
        item_history = findViewById(R.id.order_history);
        item_history.setOnClickListener(this);
        item_profile = findViewById(R.id.profile);
        item_profile.setOnClickListener(this);
        item_payoutwallet = findViewById(R.id.payout);
        item_payoutwallet.setOnClickListener(this);
        item_topupwallet = findViewById(R.id.topup);
        item_topupwallet.setOnClickListener(this);
        item_shoppingwallet = findViewById(R.id.shopping);
        item_shoppingwallet.setOnClickListener(this);
        item_myteam = findViewById(R.id.my_team);
        item_myteam.setOnClickListener(this);
        item_leftteam = findViewById(R.id.left_team);
        item_leftteam.setOnClickListener(this);
        item_rightteam = findViewById(R.id.right_team);
        item_rightteam.setOnClickListener(this);
        item_directteam = findViewById(R.id.direct_team);
        item_directteam.setOnClickListener(this);
        item_bank_details=findViewById(R.id.bank_detail);
        item_bank_details.setOnClickListener(this);
    }

    private void setViewContainer() {
        container = findViewById(R.id.container);
    }


    public void setFragment(Fragment fragment) {
        checkConnection();
        if (fragment != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null).commit();
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Log.e("HomeActivity", "Error in creating fragment");
        }
    }

    public void setActionBarTitle(String title) {
        textTitle.setText(title);
        // toolbar.setTitle(title);
    }

    public void closeBar(View view) {
        drawer.closeDrawers();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dashboard:
                setFragment(new DashBoardFragment());
                break;
            case R.id.profile:
                 setFragment(new FragmentProfile());
                 break;
            case R.id.update_kyc:
                setFragment(new FragmentUpdateKYC());
                break;
            case R.id.payouts:
                setFragment(new FragmentPayout());
                break;
            case R.id.tree_view:
                setFragment(new MyTreeViewFragment());
                break;
            case R.id.order_history:
                setFragment(new FragmentOrderHistory());
                break;
            case R.id.bank_detail:
                setFragment(new FragmentBankDetail());
                break;
            case R.id.item_wallet:
                expandableLayout.toggle();
                break;
            case R.id.payout:
                setFragment(new PayoutWalletFragment());
                break;
            case R.id.topup:
                setFragment(new TopupWalletFragment());
                break;
            case R.id.shopping:
                setFragment(new ShoppingWalletFragment());
                break;
            case R.id.reports:
                report_layout.toggle();
                break;
            case R.id.admin_charge:
                setFragment(new AdminCharge());
                break;
            case R.id.tds_charge:
                setFragment(new TDSCharge());
                break;
            case R.id.team:
                expandableLayout2.toggle();
                break;
            case R.id.my_team:
                setFragment(new FragmentMyTeam());
                break;
            case R.id.left_team:
                setFragment(new FragmentLeftTeam());
                break;
            case R.id.right_team:
                setFragment(new FragmentRightTeam());
                break;
            case R.id.direct_team:
                setFragment(new FragmentDirectTeam());
                break;
            case R.id.btn_back:
                super.onBackPressed();
                break;
            case R.id.btn_menu:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setupFragmentManager() {
   //     fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.w("Count", fragmentManager.getBackStackEntryCount() + "");
                if (fragmentManager.getBackStackEntryCount() == 0) {
                    if (btnBack.getVisibility() == View.VISIBLE)
                        btnBack.setVisibility(View.INVISIBLE);
                    textTitle.setText(Title);
                } else {
                    if (btnBack.getVisibility() == View.INVISIBLE)
                        btnBack.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void dashboard() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onExpansionUpdate(float expansionFraction) {

    }
}
