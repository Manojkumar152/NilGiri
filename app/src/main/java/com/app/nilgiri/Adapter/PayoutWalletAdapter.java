package com.app.nilgiri.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.nilgiri.Models.PayoutWallet;
import com.app.nilgiri.R;

import java.util.List;
public class PayoutWalletAdapter extends RecyclerView.Adapter<PayoutWalletAdapter.MyHolder> {
    private Activity activity;
    private List<PayoutWallet.DataBean.PayoutDetailBean> list;

    public PayoutWalletAdapter(Activity context, List<PayoutWallet.DataBean.PayoutDetailBean> data) {
        this.activity = context;
        this.list = data;
    }

    @NonNull
    @Override
    public PayoutWalletAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_list_items, viewGroup, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.credit.setText(list.get(i).getCredit());
        myHolder.debit.setText(list.get(i).getDebit());
        myHolder.balance.setText(list.get(i).getBalance());
        myHolder.date.setText(list.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        Log.e("Size", "Size" + list.size());
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public TextView credit, debit, balance, date;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            credit = itemView.findViewById(R.id.credit);
            debit = itemView.findViewById(R.id.debit);
            balance = itemView.findViewById(R.id.balance);
            date = itemView.findViewById(R.id.date);
        }
    }
}
