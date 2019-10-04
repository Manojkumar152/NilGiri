package com.app.nilgiri.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.nilgiri.Common.BaseViewHolder;
import com.app.nilgiri.Fragments.TeamData;
import com.app.nilgiri.Models.MyTeamLeftModel;
import com.app.nilgiri.R;

import java.util.ArrayList;
import java.util.List;


public class MyTeamLeftAdapter extends RecyclerView.Adapter<MyTeamLeftAdapter.ViewHolder> {
    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;
    private boolean isLoaderVisible = false;
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
        /*switch (i) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_my_teams, viewGroup, false));
            case VIEW_TYPE_LOADING:
        return new FooterHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_loading, viewGroup, false));
        default:
        return null;
    }*/
    }

    @Override
    public void onBindViewHolder(@NonNull MyTeamLeftAdapter.ViewHolder viewHolder, int i) {
       MyTeamLeftModel.DataBean.LeftTeamBean getData = data.get(i);

        viewHolder.txtName.setText(getData.getName());
        viewHolder.txtSales.setText(getData.getSales_active());
        viewHolder.txtCity.setText(getData.getCity_text());
        viewHolder.txtAdmin.setText(getData.getUsername());
        viewHolder.txtFinace.setText(getData.getEmail());
        String saleActive = getData.getSales_active();

        try {
            if(saleActive.equals("1")){
                viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check);
            }
            else {
                viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check_cross);
            }
        }catch (Exception e){
            e.getStackTrace();
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
        return data == null?0 : data.size();
    }

    public class FooterHolder extends BaseViewHolder {

        ProgressBar mProgressBar;


        FooterHolder(View itemView) {
            super(itemView);
            mProgressBar = itemView.findViewById(R.id.progress_bar);
        }

        @Override
        protected void clear() {

        }

    }

    public  void add(MyTeamLeftModel.DataBean.LeftTeamBean getdata){
        data.add(getdata);
        notifyItemInserted(data.size()-1);
    }
    public  void addAll(List<MyTeamLeftModel.DataBean.LeftTeamBean> getdata){
        for(MyTeamLeftModel.DataBean.LeftTeamBean m: getdata){
            add(m);
        }
    }
    //Add Empty item
    public  void addBottomitem(){
        add(new MyTeamLeftModel.DataBean.LeftTeamBean());
    }

    public  void removedLastEmptyItem(){
        int position = data.size()-1;
        MyTeamLeftModel.DataBean.LeftTeamBean item = getItem(position);

        if(item!=null){
            data.remove(position);
            notifyItemRemoved(position);
        }
    }

    private MyTeamLeftModel.DataBean.LeftTeamBean getItem(int position) {
        return data.get(position);
    }
}
