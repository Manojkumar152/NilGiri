package com.app.nilgiri.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.nilgiri.Models.AdminTdsCharge;
import com.app.nilgiri.R;

import java.util.List;


public class TdsAdapter extends RecyclerView.Adapter<TdsAdapter.ViewHolder> {
    private List<AdminTdsCharge.DataBean> list;
    private Activity activity;

    public TdsAdapter(Activity activity, List<AdminTdsCharge.DataBean> data) {
        list = data;
        this.activity = activity;
        Log.e("adapter","Adapter"+list.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.admin_tds_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.amount.setText(list.get(i).getAmount());
        viewHolder.tdsCharge.setText(list.get(i).getTds_charge());
        viewHolder.paid.setText(list.get(i).getPaid_amount());
        viewHolder.date.setText(list.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView amount, tdsCharge,tdsChargeText, paid, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.amount);
            tdsCharge = itemView.findViewById(R.id.admin_charge);
            tdsChargeText=itemView.findViewById(R.id.txt_admin_charge);
            tdsChargeText.setText("TDS Charge");
            paid = itemView.findViewById(R.id.paid_amount);
            date = itemView.findViewById(R.id.date);
        }
    }
}
