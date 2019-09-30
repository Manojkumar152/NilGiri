package com.app.nilgiri.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.app.nilgiri.Models.OrderHistory;
import com.app.nilgiri.R;

import java.util.List;

public class MyHistoryAdapter extends RecyclerView.Adapter<MyHistoryAdapter.ViewHolder> {
    String address,localAdd;
    Context context;
    List<OrderHistory.DataBean.OrderhistoryBean> listData;
    View v;

    public MyHistoryAdapter(FragmentActivity activity, String address, String localAdd, List<OrderHistory.DataBean.OrderhistoryBean> orderhistory) {
        this.address=address;
        this.localAdd=localAdd;
        this.context=activity;
        this.listData=orderhistory;
    }


    @NonNull
    @Override
    public MyHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_order_history,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHistoryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.mFullAddress.setText(address);
        viewHolder.mShortAddress.setText(localAdd);
        viewHolder.mDate.setText(listData.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mFullAddress,mShortAddress,mDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mFullAddress = itemView.findViewById(R.id.full_address);
            mShortAddress = itemView.findViewById(R.id.short_address);
            mDate = itemView.findViewById(R.id.date);
        }
    }
}
