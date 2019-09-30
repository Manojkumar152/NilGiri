package com.app.nilgiri.Adapter;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nilgiri.Models.MyTeamModel;
import com.app.nilgiri.R;

import java.util.ArrayList;


public class MyTeamAdapter extends RecyclerView.Adapter<MyTeamAdapter.ViewHolder>{
    private ArrayList<MyTeamModel.DataBean> getData;
    private Context context;
    View v;

    public MyTeamAdapter(Context context, ArrayList<MyTeamModel.DataBean> getData) {
        this.context = context;
        this.getData = getData;
        Log.e("size","Size"+" "+getData.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_my_teams,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        MyTeamModel.DataBean myTeamModelObj = getData.get(position);
        if(myTeamModelObj!=null){
           //   Picasso.with(context).load(ApiInterface.IMAGE_URL + getData.get(position)).transform(new CropSquareTransformation()).placeholder(R.drawable.ic_launcher_background).into(viewHolder.ivProfile);
       // viewHolder.ivProfile.setImageDrawable(myTeamModelObj.);
        viewHolder.txtName.setText(myTeamModelObj.getName());
     //   viewHolder.txtAdmin.setText(myTeamModelObj.());
      //  viewHolder.txtFinace.setText(myTeamModelObj.());
        viewHolder.txtSales.setText(myTeamModelObj.getSales_active());
     //   viewHolder.txtRank.setText(myTeamModelObj.());
        viewHolder.txtCity.setText(myTeamModelObj.getCity_text());

        String saleActive = myTeamModelObj.getSales_active();
        if(saleActive.equals("1")){
            viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check);
        }
        else{
            viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check_cross);
        }

    }
    }

    @Override
    public int getItemCount() {
        return getData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivProfile,ivProfileCheck;
        TextView txtName,txtAdmin,txtFinace,txtSales,txtRank,txtCity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProfile = itemView.findViewById(R.id.iv_imageProfile);
            ivProfileCheck = itemView.findViewById(R.id.iv_imgcheck);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAdmin = itemView.findViewById(R.id.txt_admin);
            txtFinace = itemView.findViewById(R.id.txt_finace);
            txtSales = itemView.findViewById(R.id.txt_sales);
            txtRank = itemView.findViewById(R.id.txt_rank);
            txtCity = itemView.findViewById(R.id.txt_city);

        }
    }



}
