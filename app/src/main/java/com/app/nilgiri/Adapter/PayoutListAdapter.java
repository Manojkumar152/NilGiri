package com.app.nilgiri.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.nilgiri.Fragments.PayoutListScreen;
import com.app.nilgiri.Models.PayoutDetails;
import com.app.nilgiri.R;

import java.util.List;

public class PayoutListAdapter extends RecyclerView.Adapter<PayoutListAdapter.ViewHolder> {
    private Activity activity;
    private List<PayoutDetails.DataBean.PayoutDetailBean> data;

    public PayoutListAdapter(FragmentActivity activity, List<PayoutDetails.DataBean.PayoutDetailBean> data) {
        this.activity=activity;
        this.data=data;
    }

    @NonNull
    @Override
    public PayoutListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.layout_recent_transaction,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PayoutListAdapter.ViewHolder viewHolder, int i) {
        PayoutDetails.DataBean.PayoutDetailBean obj = data.get(i);
        final int position=i;

        viewHolder.tv_amount.setText(obj.getAmount());
        viewHolder.tv_paid_amount.setText(obj.getPaid_amount());
        viewHolder.tv_date.setText(obj.getDate());

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Payout_ID","PAYOUT_ID"+data.get(position).getId());
                Intent intent= new Intent(activity,PayoutListScreen.class);
                intent.putExtra("payout_id",data.get(position).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_amount,tv_paid_amount,tv_date ;
        LinearLayout  layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.layout);
            tv_amount= itemView.findViewById(R.id.amount);
            tv_paid_amount = itemView.findViewById(R.id.paid_amount);
            tv_date = itemView.findViewById(R.id.date);
        }
    }
}
