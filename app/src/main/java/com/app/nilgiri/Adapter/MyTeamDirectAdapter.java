package com.app.nilgiri.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.app.nilgiri.Models.MyTeamDirectModel;
import com.app.nilgiri.R;

import java.util.ArrayList;

public class MyTeamDirectAdapter extends RecyclerView.Adapter<MyTeamDirectAdapter.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    View v;
    Context context;
    Runnable runnable;
    private int position;
    ArrayList<MyTeamDirectModel.DataBean> listData;

    // OnClickListener onClickListener;

    public MyTeamDirectAdapter(Context context, ArrayList<MyTeamDirectModel.DataBean> listData){
        this.context = context;
        this.listData = listData;
        //  this.onClickListener = onClickListener;

    }

    @NonNull
    @Override
    public MyTeamDirectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*if(i == VIEW_TYPE_ITEM){
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_my_teams,viewGroup,false);
        }
        else {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_loading, parent, false);
        }*/
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_my_teams,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTeamDirectAdapter.ViewHolder viewHolder, int i) {
        MyTeamDirectModel.DataBean myTeamDirectModelObj = listData.get(i);
        // viewHolder.ivProfile.setImageDrawable(myTeamModelObj.);
        viewHolder.txtName.setText(myTeamDirectModelObj.getName());
        //   viewHolder.txtAdmin.setText(myTeamModelObj.());
        //  viewHolder.txtFinace.setText(myTeamModelObj.());
        viewHolder.txtSales.setText(myTeamDirectModelObj.getSales_active());
        //   viewHolder.txtRank.setText(myTeamModelObj.());
        viewHolder.txtCity.setText(myTeamDirectModelObj.getCity_text());
        String saleActive = myTeamDirectModelObj.getSales_active();

        if(saleActive.equals("1")){
            viewHolder.ivProfileCheck.setVisibility(View.VISIBLE);
            viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check);
        }
        else {
                viewHolder.ivProfileCheck.setVisibility(View.VISIBLE);
                viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check_cross);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

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


    @Override
    public int getItemCount() {
        return listData.size();
    }
}
