package com.app.nilgiri.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.nilgiri.ApiCalls.ApiInterface;
import com.app.nilgiri.ApiCalls.RetrofitClient;
import com.app.nilgiri.ApiCalls.Urls;
import com.app.nilgiri.Models.TreeData;
import com.app.nilgiri.Models.TreeViewData;
import com.app.nilgiri.R;
import com.app.nilgiri.Utils.BaseActivity;
import com.app.nilgiri.Utils.ConnectionDetection;
import com.app.nilgiri.Utils.DisplaySnackBar;

import net.cachapa.expandablelayout.ExpandableLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyTreeViewFragment extends Fragment implements View.OnClickListener  {
    private ImageView root_user,first_left_user_image,first_right_user_image,second_left_user_image,
                      second_left_user_image1,second_right_user_image,second_right_user_image1;
    private TextView root_user_name,first_left_user,first_right_user,second_left_user,second_left_user1,second_right_user,second_right_user1;
    private TextView root_user_id,first_left_user_id,first_right_user_id,second_left_user_id,second_left_user1_id,second_right_user_id,second_right_user1_id;
    private LinearLayout root,first_left,first_right,second_left,second_left_second_level,second_right,second_right_second_level;
    private TreeViewData data;
    private TextView name, sponser_name, left, right, leftActive, rightActive;
    private ExpandableLayout profile_layout;
    BaseActivity baseActivity;
    SharedPreferences pref;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tree_view,container,false);
        pref = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        String companyId=pref.getString("company_id",null);
        initView(view);
        if(ConnectionDetection.isInternetAvailable(getActivity())) {
            getTreeViewData(companyId);
        }
        else{
            DisplaySnackBar.showSnackBar(getActivity(),getString(R.string.internet_error));
        }
        return view;
    }


    private void initView(View view) {
        root=view.findViewById(R.id.root);
        first_left=view.findViewById(R.id.first_left);
        first_right=view.findViewById(R.id.first_right);
        second_left=view.findViewById(R.id.second_left);
        second_left_second_level=view.findViewById(R.id.second_left_second_level);
        second_right=view.findViewById(R.id.second_right);
        second_right_second_level=view.findViewById(R.id.second_right_second_level);

        profile_layout=view.findViewById(R.id.expandable);
        name=view.findViewById(R.id.username);
        sponser_name=view.findViewById(R.id.sponser_name);
        left=view.findViewById(R.id.member_left);
        right=view.findViewById(R.id.member_right);
        leftActive=view.findViewById(R.id.active_left);
        rightActive=view.findViewById(R.id.active_right);

        root.setOnClickListener(this);
        first_left.setOnClickListener(this);
        first_right.setOnClickListener(this);
        second_left.setOnClickListener(this);
        second_left_second_level.setOnClickListener(this);
        second_right.setOnClickListener(this);
        second_right_second_level.setOnClickListener(this);

        root_user=view.findViewById(R.id.root_user);
        first_left_user_image=view.findViewById(R.id.first_left_user_image);
        first_right_user_image=view.findViewById(R.id.first_right_user_image);
        second_left_user_image=view.findViewById(R.id.second_left_user_image);
        second_left_user_image1=view.findViewById(R.id.second_left_user_image1);
        second_right_user_image=view.findViewById(R.id.second_right_user_image);
        second_right_user_image1=view.findViewById(R.id.second_right_user_image1);

        root_user_name=view.findViewById(R.id.root_user_name);
        first_left_user=view.findViewById(R.id.first_left_user);
        first_right_user=view.findViewById(R.id.first_right_user);
        second_left_user=view.findViewById(R.id.second_left_user);
        second_left_user1=view.findViewById(R.id.second_left_user1);
        second_right_user=view.findViewById(R.id.second_right_user);
        second_right_user1=view.findViewById(R.id.second_right_user1);

        root_user_id=view.findViewById(R.id.root_user_id);
        first_left_user_id=view.findViewById(R.id.first_left_user_id);
        first_right_user_id=view.findViewById(R.id.first_right_user_id);
        second_left_user_id=view.findViewById(R.id.second_left_user_id);
        second_left_user1_id=view.findViewById(R.id.second_left_user1_id);
        second_right_user_id=view.findViewById(R.id.second_right_user_id);
        second_right_user1_id=view.findViewById(R.id.second_right_user1_id);

    }


    private void getTreeViewData(String company_id) {
        Log.e("treeview","Treeview"+ company_id);

        if(getActivity()!=null) {
            ((BaseActivity) getActivity()).showProgress();
        }
        ApiInterface service= RetrofitClient.getClient().create(ApiInterface.class);
        Call<TreeData> call= service.getTreeViewData(company_id,Urls.API_KEY);
        call.enqueue(new Callback<TreeData>() {
            @Override
            public void onResponse(Call<TreeData> call, Response<TreeData> response) {
                Log.e("ResponseData", "ResponseData" );
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
                data = new TreeViewData();
                if (response.body().getStatus() == 1) {
                    data.setRoot_name(response.body().getData().getClient().getName());
                    data.setRoot_id(response.body().getData().getClient().getId());

                    data.setSales_active(response.body().getData().getClient().getSales_active());
                    data.setRoot_username(response.body().getData().getClient().getUsername());
                    data.setDirect_sponser_name(response.body().getData().getClient().getDirect_sponser_name());
                    data.setMember_Left(String.valueOf(response.body().getData().getMember_sale().getMember().getLeft()));
                    data.setMember_right(String.valueOf(response.body().getData().getMember_sale().getMember().getRight()));
                    data.setLeft_active(String.valueOf(response.body().getData().getMember_sale().getActive_member().getLeft()));
                    data.setRight_active(String.valueOf(response.body().getData().getMember_sale().getActive_member().getRight()));

                    try {
                        if (response.body().getData().getClient_tree().getLevel1().size() >= 2) {
                            data.setFirst_left_id(response.body().getData().getClient_tree().getLevel1().get(0).getId());
                            data.setFirst_left_name(response.body().getData().getClient_tree().getLevel1().get(0).getUsername());

                            Log.e("IF", "IF" + response.body().getData().getClient_tree().getLevel1().get(0).getSales_active());
                            if (response.body().getData().getClient_tree().getLevel1().get(0).getSales_active().equals("1")) {
                                data.setFirst_left_active_user("Active");
                            } else {
                                data.setFirst_left_active_user("Non Active");
                            }

                            data.setFirst_right_id(response.body().getData().getClient_tree().getLevel1().get(1).getId());
                            data.setFirst_right_name(response.body().getData().getClient_tree().getLevel1().get(1).getUsername());
                            if (response.body().getData().getClient_tree().getLevel1().get(1).getSales_active().equals("1")) {
                                data.setFirst_right_active_user("Active");
                            } else {
                                data.setFirst_right_active_user("Non Active");
                            }
                        } else if (response.body().getData().getClient_tree().getLevel1().size() == 1) {
                            Log.e("Else_If", "Else_If");
                            if (response.body().getData().getClient_tree().getLevel1().get(0).getPosition().equals("1")) {
                                data.setFirst_left_id(response.body().getData().getClient_tree().getLevel1().get(0).getId());
                                data.setFirst_left_name(response.body().getData().getClient_tree().getLevel1().get(0).getUsername());
                                if (response.body().getData().getClient_tree().getLevel1().get(0).getSales_active().equals("1")) {
                                    data.setFirst_left_active_user("Active");
                                    data.setFirst_right_active_user("No User");
                                } else {
                                    data.setFirst_left_active_user("Non Active");
                                    data.setFirst_right_active_user("No User");
                                }
                            } else if (response.body().getData().getClient_tree().getLevel1().get(0).getPosition().equals("2")) {
                                data.setFirst_right_id(response.body().getData().getClient_tree().getLevel1().get(0).getId());
                                data.setFirst_right_name(response.body().getData().getClient_tree().getLevel1().get(0).getUsername());
                                if (response.body().getData().getClient_tree().getLevel1().get(0).getSales_active().equals("1")) {
                                    data.setFirst_right_active_user("Active");
                                    data.setFirst_left_active_user("No User");
                                } else {
                                    data.setFirst_right_active_user("Non Active");
                                    data.setFirst_left_active_user("No User");
                                }
                            }
                        }
                    }
                    catch (NullPointerException ex){
                        data.setFirst_left_active_user("No User");
                        data.setFirst_right_active_user("No User");
                    }
                    try {
                        if (response.body().getData().getClient_tree().getLevel2().getLeft().size() >= 2) {
                            Log.e("Level2_first_If", "Level2_first_If");
                            data.setSecond_level_left_id(response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getId());
                            data.setSecond_level_left(response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getUsername());
                            if (response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getSales_active().equals("1")) {
                                data.setSecond_left_active_user("Active");
                            } else {
                                data.setSecond_left_active_user("Non Active");
                            }
                            data.setSecond_level_left2_id(response.body().getData().getClient_tree().getLevel2().getLeft().get(1).getId());
                            data.setSecond_level_left2(response.body().getData().getClient_tree().getLevel2().getLeft().get(1).getUsername());
                            if (response.body().getData().getClient_tree().getLevel2().getLeft().get(1).getSales_active().equals("1")) {
                                data.setSecond_left_active_user2("Active");
                            } else {
                                data.setSecond_left_active_user2("Non Active");
                            }
                        } else if (response.body().getData().getClient_tree().getLevel2().getLeft().size() == 1) {
                            if (response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getPosition().equals(1)) {
                                data.setSecond_level_left_id(response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getId());
                                data.setSecond_level_left(response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getUsername());
                                if (response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getSales_active().equals("1")) {
                                    data.setSecond_left_active_user("Active");
                                    data.setSecond_left_active_user2("No User");
                                } else {
                                    data.setSecond_left_active_user("Non Active");
                                    data.setSecond_left_active_user2("No User");
                                }

                            } else {
                                data.setSecond_level_left2_id(response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getId());
                                data.setSecond_level_left2(response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getUsername());
                                if (response.body().getData().getClient_tree().getLevel2().getLeft().get(0).getSales_active().equals("1")) {
                                    data.setSecond_left_active_user2("Active");
                                    data.setSecond_left_active_user("No User");
                                } else {
                                    data.setSecond_left_active_user2("Non Active");
                                    data.setSecond_left_active_user("No User");
                                }
                            }
                        }
                    }
                    catch (NullPointerException ex) {
                        data.setSecond_left_active_user("No User");
                        data.setSecond_left_active_user2("No User");
                    }
                    try {
                        if (response.body().getData().getClient_tree().getLevel2().getRight().size() >= 2) {
                            data.setSecond_level_right_id(response.body().getData().getClient_tree().getLevel2().getRight().get(0).getId());
                            data.setSecond_level_right(response.body().getData().getClient_tree().getLevel2().getRight().get(0).getUsername());
                            if (response.body().getData().getClient_tree().getLevel2().getRight().get(0).getSales_active().equals("1")) {
                                data.setSecond_right_active_user("Active");
                            } else {
                                data.setSecond_right_active_user("Non Active");
                            }

                            data.setSecond_level_right2_id(response.body().getData().getClient_tree().getLevel2().getRight().get(1).getId());
                            data.setSecond_level_right2(response.body().getData().getClient_tree().getLevel2().getRight().get(1).getUsername());
                            if (response.body().getData().getClient_tree().getLevel2().getRight().get(1).getSales_active().equals("1")) {
                                data.setSecond_right_active_user2("Active");
                            } else {
                                data.setSecond_right_active_user2("Non Active");
                            }
                        } else if (response.body().getData().getClient_tree().getLevel2().getRight().size() == 1) {
                            if (response.body().getData().getClient_tree().getLevel2().getRight().get(0).getPosition().equals(1)) {
                                data.setSecond_level_right_id(response.body().getData().getClient_tree().getLevel2().getRight().get(0).getId());
                                data.setSecond_level_right(response.body().getData().getClient_tree().getLevel2().getRight().get(0).getUsername());

                                if (response.body().getData().getClient_tree().getLevel2().getRight().get(0).getSales_active().equals("1")) {
                                    data.setSecond_right_active_user("Active");
                                    data.setSecond_right_active_user2("No User");
                                } else {
                                    data.setSecond_right_active_user("Non Active");
                                    data.setSecond_right_active_user2("No User");
                                }

                            } else {
                                data.setSecond_level_right2_id(response.body().getData().getClient_tree().getLevel2().getRight().get(0).getId());
                                data.setSecond_level_right2(response.body().getData().getClient_tree().getLevel2().getRight().get(0).getUsername());

                                if (response.body().getData().getClient_tree().getLevel2().getRight().get(0).getSales_active().equals("1")) {
                                    data.setSecond_right_active_user2("Active");
                                    data.setSecond_right_active_user("No User");
                                } else {
                                    data.setSecond_right_active_user2("Non Active");
                                    data.setSecond_right_active_user("No User");
                                }
                            }
                        }
                    }
                    catch (NullPointerException ex) {
                        data.setSecond_right_active_user2("No User");
                        data.setSecond_right_active_user("No User");
                    }
                    setTreeViewData(data);
                }
            }

            @Override
            public void onFailure(Call<TreeData> call, Throwable t) {
                Log.e("Failure","Failure"+t.toString()+" "+call.toString());
                if (getActivity()!= null) {
                    ((BaseActivity)getActivity()).hideProgress();
                }
            }
        });
    }

    private void setTreeViewData(TreeViewData data) {
        Log.e("Set_Data","Set_data"+"  "+data.getFirst_left_active_user()+"  "+data.getFirst_right_active_user()+"  "+data.getSecond_right_active_user()+"  "+data.getSecond_right_active_user2());
        root_user_id.setText(data.getRoot_id());
        try {
            root_user_id.setText(data.getRoot_id());
            if (data.getSales_active().equals("1")) {
                root_user_name.setText(data.getRoot_username());
                root_user_name.setTextColor(getResources().getColor(R.color.colorPrimary));
                root_user.setBackgroundResource(R.drawable.active_user_img);
            } else {
                root_user_name.setText(data.getRoot_username());
                root_user_name.setTextColor(getResources().getColor(R.color.red_color));
                root_user.setBackgroundResource(R.drawable.non_active_user_img);
            }
        }catch (NullPointerException ex){
            /*first_left_user.setText("No User");
            first_left_user.setTextColor(getResources().getColor(R.color.light_grey));
            first_left_user_image.setBackgroundResource(R.drawable.no_user_img);*/
        }
        try {
            if (data.getFirst_left_active_user().equals("Active")) {
                first_left_user_id.setText(data.getFirst_left_id());
                first_left_user.setText(data.getFirst_left_name());
                first_left_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                first_left_user_image.setBackgroundResource(R.drawable.active_user_img);
            } else if (data.getFirst_left_active_user().equals("Non Active")) {
                first_left_user_id.setText(data.getFirst_left_id());
                first_left_user.setText(data.getFirst_left_name());
                first_left_user.setTextColor(getResources().getColor(R.color.red_color));
                first_left_user_image.setBackgroundResource(R.drawable.non_active_user_img);
            } else {
                first_left_user.setText("No User");
                first_left_user.setTextColor(getResources().getColor(R.color.light_grey));
                first_left_user_image.setBackgroundResource(R.drawable.no_user_img);
            }
        }
        catch (NullPointerException ex){
            first_left_user.setText("No User");
            first_left_user.setTextColor(getResources().getColor(R.color.light_grey));
            first_left_user_image.setBackgroundResource(R.drawable.no_user_img);
        }
        try {
            if (data.getFirst_right_active_user().equals("Active")) {
                first_right_user_id.setText(data.getFirst_right_id());
                first_right_user.setText(data.getFirst_right_name());
                first_right_user_id.setText(data.getFirst_right_id());
                first_right_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                first_right_user_image.setBackgroundResource(R.drawable.active_user_img);
            } else if (data.getFirst_right_active_user().equals("Non Active")) {
                first_right_user_id.setText(data.getFirst_right_id());
                first_right_user.setText(data.getFirst_right_name());
                first_right_user.setTextColor(getResources().getColor(R.color.red_color));
                first_right_user_image.setBackgroundResource(R.drawable.non_active_user_img);
            } else {
                first_right_user.setText("No User");
                first_right_user.setTextColor(getResources().getColor(R.color.light_grey));
                first_right_user_image.setBackgroundResource(R.drawable.no_user_img);
            }
        }catch (NullPointerException ex){
            first_right_user.setText("No User");
            first_right_user.setTextColor(getResources().getColor(R.color.light_grey));
            first_right_user_image.setBackgroundResource(R.drawable.no_user_img);
        }
        try {
            if (data.getSecond_left_active_user().equals("Active")) {
                second_left_user_id.setText(data.getSecond_level_left_id());
                second_left_user.setText(data.getSecond_level_left());
                second_left_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_left_user_image.setBackgroundResource(R.drawable.active_user_img);
            } else if (data.getSecond_left_active_user().equals("Non Active")) {
                second_left_user_id.setText(data.getSecond_level_left_id());
                second_left_user.setText(data.getSecond_level_left());
                second_left_user.setTextColor(getResources().getColor(R.color.red_color));
                second_left_user_image.setBackgroundResource(R.drawable.non_active_user_img);
            } else if (data.getSecond_left_active_user().equals("No User")) {
                //second_left_user_id.setText(data.getSecond_level_left_id());
                second_left_user.setText("No User");
                second_left_user.setTextColor(getResources().getColor(R.color.light_grey));
                second_left_user_image.setBackgroundResource(R.drawable.no_user_img);
            }
            if (data.getSecond_left_active_user2().equals("Active")) {
                second_left_user1_id.setText(data.getSecond_level_left2_id());
                second_left_user1.setText(data.getSecond_level_left2());
                second_left_user1.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_left_user_image1.setBackgroundResource(R.drawable.active_user_img);
            } else if (data.getSecond_left_active_user2().equals("Non Active")) {
                second_left_user1_id.setText(data.getSecond_level_left2_id());
                second_left_user1.setText(data.getSecond_level_left2());
                second_left_user1.setTextColor(getResources().getColor(R.color.red_color));
                second_left_user_image1.setBackgroundResource(R.drawable.non_active_user_img);
            } else if (data.getSecond_left_active_user2().equals("No User")) {
                //second_left_user1_id.setText(data.getSecond_level_left2_id());
                second_left_user1.setText("No User");
                second_left_user1.setTextColor(getResources().getColor(R.color.light_grey));
                second_left_user_image1.setBackgroundResource(R.drawable.no_user_img);
            }
        }catch (NullPointerException ex){

        }
        try{
            if (data.getSecond_right_active_user().equals("Active")) {
                second_right_user_id.setText(data.getSecond_level_right_id());
                second_right_user.setText(data.getSecond_level_right());
                second_right_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_right_user_image.setBackgroundResource(R.drawable.active_user_img);
            } else if (data.getSecond_right_active_user().equals("Non Active")) {
                second_right_user_id.setText(data.getSecond_level_right_id());
                second_right_user.setText(data.getSecond_level_right());
                second_right_user.setTextColor(getResources().getColor(R.color.red_color));
                second_right_user_image.setBackgroundResource(R.drawable.non_active_user_img);
            } else if (data.getSecond_right_active_user().equals("No User")) {
                //second_right_user_id.setText(data.getSecond_level_right_id());
                second_right_user.setText("No User");
                second_right_user.setTextColor(getResources().getColor(R.color.light_grey));
                second_right_user_image.setBackgroundResource(R.drawable.no_user_img);
            }
            if (data.getSecond_right_active_user2().equals("Active")) {
                second_right_user1_id.setText(data.getSecond_level_right2_id());
                second_right_user1.setText(data.getSecond_level_right2());
                second_right_user1.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_right_user_image1.setBackgroundResource(R.drawable.active_user_img);
            }
            else if (data.getSecond_right_active_user2().equals("Non Active")) {
                second_right_user1_id.setText(data.getSecond_level_right2_id());
                second_right_user1.setText(data.getSecond_level_right2());
                second_right_user1.setTextColor(getResources().getColor(R.color.red_color));
                second_right_user_image1.setBackgroundResource(R.drawable.non_active_user_img);
            }
            else if (data.getSecond_right_active_user2().equals("No User")) {
                second_right_user1_id.setText(data.getSecond_level_right2_id());
                second_right_user1.setText("No User");
                second_right_user1.setTextColor(getResources().getColor(R.color.light_grey));
                second_right_user_image1.setBackgroundResource(R.drawable.no_user_img);
            }
        }catch (NullPointerException ex){

        }

       /* try {
            if (data.getSecond_left_active_user().equals("Active") && data.getSecond_left_active_user2().equals("Active")) {
                second_left_user_id.setText(data.getSecond_level_left_id());
                second_left_user.setText(data.getSecond_level_left());
                second_left_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_left_user_image.setBackgroundResource(R.drawable.active_user_img);

                second_left_user1_id.setText(data.getSecond_level_left2_id());
                second_left_user1.setText(data.getSecond_level_left2());
                second_left_user1.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_left_user_image1.setBackgroundResource(R.drawable.active_user_img);
            }

            else if ( data.getSecond_left_active_user().equals("Non Active")&& data.getSecond_left_active_user2().equals("Active")) {
                second_left_user.setText(data.getSecond_level_left());
                second_left_user.setTextColor(getResources().getColor(R.color.red_color));
                second_left_user_image.setBackgroundResource(R.drawable.non_active_user_img);

                second_left_user1.setText(data.getSecond_level_left2());
                second_left_user1.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_left_user_image1.setBackgroundResource(R.drawable.active_user_img);
            }

            else if (data.getSecond_left_active_user().equals("Non User")) {
                second_left_user.setText(data.getSecond_level_left());
                second_left_user.setTextColor(getResources().getColor(R.color.light_grey));
                second_left_user_image.setBackgroundResource(R.drawable.no_user_img);
            }


            else if (data.getSecond_left_active_user().equals("Active") && data.getSecond_left_active_user2().equals("Non Active")) {
                second_left_user.setText(data.getSecond_level_left());
                second_left_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_left_user_image.setBackgroundResource(R.drawable.active_user_img);

                second_left_user1.setText(data.getSecond_level_left2());
                second_left_user1.setTextColor(getResources().getColor(R.color.red_color));
                second_left_user_image1.setBackgroundResource(R.drawable.non_active_user_img);
            }
            else if(data.getSecond_left_active_user().equals("Non Active") && data.getSecond_left_active_user2().equals("Non Active")){
                second_left_user.setText(data.getSecond_level_left());
                second_left_user.setTextColor(getResources().getColor(R.color.red_color));
                second_left_user_image.setBackgroundResource(R.drawable.non_active_user_img);

                second_left_user1.setText(data.getSecond_level_left2());
                second_left_user1.setTextColor(getResources().getColor(R.color.red_color));
                second_left_user_image1.setBackgroundResource(R.drawable.non_active_user_img);
            }
           else {
                second_left_user.setText("No User");
                second_left_user.setTextColor(getResources().getColor(R.color.light_grey));
                second_left_user_image.setBackgroundResource(R.drawable.no_user_img);
                second_left_user1.setText("No User");
                second_left_user1.setTextColor(getResources().getColor(R.color.light_grey));
                second_left_user_image1.setBackgroundResource(R.drawable.no_user_img);
            }
        }catch (NullPointerException ex){
            second_left_user.setText("No User");
            second_left_user.setTextColor(getResources().getColor(R.color.light_grey));
            second_left_user_image.setBackgroundResource(R.drawable.no_user_img);
            second_left_user1.setText("No User");
            second_left_user1.setTextColor(getResources().getColor(R.color.light_grey));
            second_left_user_image1.setBackgroundResource(R.drawable.no_user_img);
        }
        try {
            if (data.getSecond_right_active_user().equals("Active") && data.getSecond_right_active_user2().equals("Active")) {
                Log.e("IF_IF","IF_IF");
                second_right_user_id.setText(data.getSecond_level_right_id());
                second_right_user.setText(data.getSecond_level_right());
                second_right_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_right_user_image.setBackgroundResource(R.drawable.active_user_img);

                second_right_user1_id.setText(data.getSecond_level_right2_id());
                second_right_user1.setText(data.getSecond_level_right2());
                second_right_user1.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_right_user_image1.setBackgroundResource(R.drawable.active_user_img);
            }
            else if(data.getSecond_right_active_user().equals("Active") && data.getSecond_right_active_user2().equals("Non Active")) {
                second_right_user.setText(data.getSecond_level_right());
                second_right_user.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_right_user_image.setBackgroundResource(R.drawable.active_user_img);

                second_right_user1.setText(data.getSecond_level_right2());
                second_right_user1.setTextColor(getResources().getColor(R.color.red_color));
                second_right_user_image1.setBackgroundResource(R.drawable.non_active_user_img);
            }
            else if ((data.getSecond_right_active_user().equals("Non Active"))&&(data.getSecond_right_active_user2().equals("Active"))) {
                second_right_user.setText(data.getSecond_level_right());
                second_right_user.setTextColor(getResources().getColor(R.color.red_color));
                second_right_user_image.setBackgroundResource(R.drawable.non_active_user_img);

                second_right_user1.setText(data.getSecond_level_right2());
                second_right_user1.setTextColor(getResources().getColor(R.color.colorPrimary));
                second_right_user_image1.setBackgroundResource(R.drawable.active_user_img);
            }
            else if ((data.getSecond_right_active_user().equals("Non Active"))&&(data.getSecond_right_active_user2().equals("Non Active"))) {
                second_right_user.setText(data.getSecond_level_right());
                second_right_user.setTextColor(getResources().getColor(R.color.red_color));
                second_right_user_image.setBackgroundResource(R.drawable.non_active_user_img);

                second_right_user1.setText(data.getSecond_level_right2());
                second_right_user1.setTextColor(getResources().getColor(R.color.red_color));
                second_right_user_image1.setBackgroundResource(R.drawable.non_active_user_img);
            }

            else {
                second_right_user.setText("No User");
                second_right_user.setTextColor(getResources().getColor(R.color.light_grey));
                second_right_user_image.setBackgroundResource(R.drawable.no_user_img);
                second_right_user1.setText("No User");
                second_right_user1.setTextColor(getResources().getColor(R.color.light_grey));
                second_right_user_image1.setBackgroundResource(R.drawable.no_user_img);
            }
        }catch (NullPointerException ex){
            second_right_user.setText("No User");
            second_right_user.setTextColor(getResources().getColor(R.color.light_grey));
            second_right_user_image.setBackgroundResource(R.drawable.no_user_img);
            second_right_user1.setText("No User");
            second_right_user1.setTextColor(getResources().getColor(R.color.light_grey));
            second_right_user_image1.setBackgroundResource(R.drawable.no_user_img);
        }
*/
        name.setText(data.getRoot_username());
        sponser_name.setText(data.getDirect_sponser_name());
        left.setText(data.getMember_Left());
        right.setText(data.getMember_right());
        leftActive.setText(data.getLeft_active());
        rightActive.setText(data.getRight_active());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.root:
                profile_layout.setVisibility(View.VISIBLE);
                profile_layout.toggle();
                break;

            case R.id.first_left:
                if(first_left_user.getText().equals("No User")){
                    DisplaySnackBar.showSnackBar(getActivity(),"Add New user");
                }
                else {
                    getTreeViewData(first_left_user_id.getText().toString());
                }
                break;
            case R.id.first_right:
                if(first_right_user.getText().equals("No User")){
                    DisplaySnackBar.showSnackBar(getActivity(),"Add New user");
                }
                else {
                    getTreeViewData(first_right_user_id.getText().toString());
                }
                break;
            case R.id.second_left:
                if(second_left_user.getText().equals("No User")){
                    DisplaySnackBar.showSnackBar(getActivity(),"Add New user");
                }
                else {
                    getTreeViewData(second_left_user_id.getText().toString());
                }
                break;
            case R.id.second_left_second_level:
                if(second_left_user1.getText().equals("No User")){
                    DisplaySnackBar.showSnackBar(getActivity(),"Add New user");
                }
                else {
                    getTreeViewData(second_left_user1_id.getText().toString());
                }
                break;
            case R.id.second_right:
                if(second_right_user.getText().equals("No User")){
                    DisplaySnackBar.showSnackBar(getActivity(),"Add New user");
                }
                else {
                    getTreeViewData(second_right_user_id.getText().toString());
                }
                break;
            case R.id.second_right_second_level:
                if(second_right_user1.getText().equals("No User")){
                    DisplaySnackBar.showSnackBar(getActivity(),"Add New user");
                }
                else {
                    getTreeViewData(second_right_user1_id.getText().toString());
                }
                break;
        }

    }
}
