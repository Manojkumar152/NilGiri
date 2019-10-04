package com.app.nilgiri.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nilgiri.Models.MyTeamLeftModel;
import com.app.nilgiri.R;

import java.util.ArrayList;
import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyHolder> {
    private Activity activity;
    private List<MyTeamLeftModel.DataBean> data;
    private  String TAG="LeftAdapter";
    public final int TYPE_JOB = 0;
    public final int TYPE_LOAD = 1;
    public OnLoadMoreListener loadMoreListener;
    boolean isLoading = false, isMoreDataAvailable = true;
    public  RecyclerView mRecyclerView;

    public LeftAdapter(FragmentActivity activity, RecyclerView recyclerView, ArrayList<MyTeamLeftModel.DataBean> listData) {
        this.activity=activity;
        this.data=listData;
        this.mRecyclerView=recyclerView;
    }

    @NonNull
    @Override
    public LeftAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.layout_my_teams,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.MyHolder viewHolder, int i) {
        MyTeamLeftModel.DataBean myTeamLeftModelObj = data.get(i);
        // viewHolder.ivProfile.setImageDrawable(myTeamModelObj.);
     //   viewHolder.txtName.setText(myTeamLeftModelObj.getName());
        //   viewHolder.txtAdmin.setText(myTeamModelObj.());
        //  viewHolder.txtFinace.setText(myTeamModelObj.());
    //    viewHolder.txtSales.setText(myTeamLeftModelObj.getSales_active());
        //   viewHolder.txtRank.setText(myTeamModelObj.());
  //      viewHolder.txtCity.setText(myTeamLeftModelObj.getCity_text());
  //      String saleActive = myTeamLeftModelObj.getSales_active();

        /*if (saleActive.equals("1")) {
            viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check);
        } else {
            viewHolder.ivProfileCheck.setBackgroundResource(R.drawable.ic_check_cross);
        }*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView ivProfile, ivProfileCheck;
        TextView txtName, txtAdmin, txtFinace, txtSales, txtRank, txtCity;

        public MyHolder(@NonNull View itemView) {
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

    static class LoadHolder extends RecyclerView.ViewHolder{
        public LoadHolder(View itemView) {
            super(itemView);
        }
    }

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }
    /* notifyDataSetChanged is final method so we can't override it
         call adapter.notifyDataChanged(); after update the list
         */
    public void notifyDataChanged(){
        notifyDataSetChanged();
        isLoading = false;
        //  Log.e(TAG,"notifyDataChanged ");
    }


    public interface OnLoadMoreListener{
        void onLoadMore();
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
        Log.e(TAG,"setLoadMoreListener ");
    }

   /* @Override
    public int getItemViewType(int position) {
        try {
            if (data.get(position).type.equals("job")) {
                return TYPE_JOB;
            } else {
                return TYPE_LOAD;
            }
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
        return TYPE_JOB;
    }*/
}
