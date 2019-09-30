package com.app.nilgiri.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.nilgiri.Fragments.PayoutListScreen;
import com.app.nilgiri.Models.Payouts;
import com.app.nilgiri.R;

import java.util.List;

public class PayoutAdapter extends RecyclerView.Adapter<PayoutAdapter.MyHolder> {
    private List<Payouts.DataBean> data;
    private Activity activity;

    public PayoutAdapter(PayoutListScreen payoutListScreen, List<Payouts.DataBean> list) {
        this.activity=payoutListScreen;
        this.data=list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.payout_list_layout,viewGroup,false);
        return new PayoutAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder viewHolder, int i) {
        viewHolder.tv_amount.setText(data.get(i).getType());
        viewHolder.tv_paid_amount.setText(data.get(i).getAmount());
        viewHolder.tv_date.setText(data.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView tv_amount,tv_paid_amount,tv_date ;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_amount= itemView.findViewById(R.id.amount);
            tv_paid_amount = itemView.findViewById(R.id.paid_amount);
            tv_date = itemView.findViewById(R.id.date);
        }
    }
}
