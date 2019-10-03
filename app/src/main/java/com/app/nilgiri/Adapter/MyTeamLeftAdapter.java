package com.app.nilgiri.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nilgiri.Fragments.TeamData;
import com.app.nilgiri.Models.MyTeamLeftModel;
import com.app.nilgiri.R;

import java.util.ArrayList;


public class MyTeamLeftAdapter extends RecyclerView.Adapter<MyTeamLeftAdapter.ViewHolder> {
    View v;
    Context context;
    ArrayList<MyTeamLeftModel.DataBean.LeftTeamBean> data;


    public MyTeamLeftAdapter(Context context, ArrayList<MyTeamLeftModel.DataBean.LeftTeamBean> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyTeamLeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_my_teams,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTeamLeftAdapter.ViewHolder viewHolder, int i) {

        viewHolder.txtName.setText(data.get(i).getName());

        viewHolder.txtSales.setText(data.get(i).getSales_active());
        viewHolder.txtCity.setText(data.get(i).getCity_text());
        String saleActive = data.get(i).getSales_active();

        if(saleActive.equals("1")){
            viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check);
        }
        else {
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
        return data.size();
    }
}
