package com.app.nilgiri.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
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
    MyTeamLeftModel.DataBean.ClientBean listDataClient;
    private CardView cardView;
    private static final int HEADER = 0;
    private static  final int Footer = 0;
    private static final int ITEM = 1;
    public final int TYPE_JOB = 0;
    public final int TYPE_LOAD = 1;

    String client_id,client_name,client_username,client_city,client_citytext,client_email,client_avtar_client,clientsales_active;


    public MyTeamLeftAdapter(Context context, String client_id, String client_name,String client_username, String client_city, String client_citytext, String client_email, String client_avtar_client, String clientsales_active, ArrayList<MyTeamLeftModel.DataBean.LeftTeamBean> data) {
        this.context = context;
        this.data = data;
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_username = client_username;
        this.client_city = client_city;
        this.client_citytext = client_citytext;
        this.client_email = client_email;
        this.client_avtar_client = client_avtar_client;
        this.clientsales_active = clientsales_active;

    }

    @NonNull
    @Override
    public MyTeamLeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = null;
        switch (i) {
            case 0:
                if(i==0 ) {
                    v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_client, viewGroup, false);
                    NormalViewHolder vh = new NormalViewHolder(v);
                    return vh;
                }


            default:
                if(i==0) {
                    v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_my_teams, viewGroup, false);
                    NormalViewHolder vh4 = new NormalViewHolder(v);
                    return vh4;
                }
                    v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_my_teams, viewGroup, false);
                    FooterViewHolder vh1 = new FooterViewHolder(v);
                    return vh1;

        }

    }

    @Override
    public void onBindViewHolder(@NonNull MyTeamLeftAdapter.ViewHolder viewHolder, int i) {

       /* if(data.get(i)!=null){

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
        }else {

        }*/

            if (viewHolder instanceof NormalViewHolder) {

                NormalViewHolder vh = (NormalViewHolder) viewHolder;
                vh.txtName.setText(client_name);
                vh.txtSales.setText(clientsales_active);
                vh.txtCity.setText(client_citytext);
                vh.txtAdmin.setText(client_username);
                vh.txtFinace.setText(client_email);
                String saleActive = clientsales_active;

                try {
                    if(saleActive.equals("1")){
                        vh.ivProfileCheck.setBackgroundResource(R.drawable.ic_check);
                    }
                    else {
                        vh.ivProfileCheck.setBackgroundResource(R.drawable.ic_check_cross);
                    }
                }catch (Exception e){
                    e.getStackTrace();
                }



            }

         MyTeamLeftModel.DataBean.LeftTeamBean getData = data.get(i);

             // vh.bindView(i);
             if (viewHolder instanceof FooterViewHolder) {
                FooterViewHolder vh = (FooterViewHolder) viewHolder;
                vh.txtName.setText(getData.getName());
                vh.txtSales.setText(getData.getSales_active());
                vh.txtCity.setText(String.valueOf(getData.getCity_text()));
                vh.txtAdmin.setText(getData.getUsername());
                vh.txtFinace.setText(getData.getEmail());
                String saleActive = getData.getSales_active();

                try {
                    if(saleActive.equals("1")){
                        vh.ivProfileCheck.setBackgroundResource(R.drawable.ic_check);
                    }
                    else {
                        vh.ivProfileCheck.setBackgroundResource(R.drawable.ic_check_cross);
                    }
                }catch (Exception e){
                    e.getStackTrace();
                }
            }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindView(int position) {
            // bindView() method to implement actions

        }
    }


    @Override
    public int getItemViewType(int position) {

        if(isPositionHeader(position))
            return HEADER;
        return ITEM;

    }
    private boolean isPositionHeader(int position)
    {
        return position == 0;
    }

    // Define a ViewHolder for Footer view
    public class FooterViewHolder extends ViewHolder {
        ImageView ivProfile, ivProfileCheck;
        TextView txtName, txtAdmin, txtFinace, txtSales, txtRank, txtCity;
        CardView cardView;
        public FooterViewHolder(View itemView) {

            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_imageProfile);
            ivProfileCheck = itemView.findViewById(R.id.iv_imgcheck);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAdmin = itemView.findViewById(R.id.txt_admin);
            txtFinace = itemView.findViewById(R.id.txt_finace);
            txtSales = itemView.findViewById(R.id.txt_sales);
            txtRank = itemView.findViewById(R.id.txt_rank);
            txtCity = itemView.findViewById(R.id.txt_city);
            cardView = itemView.findViewById(R.id.card_view_visible);
        }
    }

    // Now define the ViewHolder for Normal list item
    public class NormalViewHolder extends ViewHolder {
        ImageView ivProfile, ivProfileCheck;
        TextView txtName, txtAdmin, txtFinace, txtSales, txtRank, txtCity;
        CardView cardView;
        public NormalViewHolder(View itemView) {
            super(itemView);

            ivProfile = itemView.findViewById(R.id.iv_imageProfile);
            ivProfileCheck = itemView.findViewById(R.id.iv_imgcheck);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAdmin = itemView.findViewById(R.id.txt_admin);
            txtFinace = itemView.findViewById(R.id.txt_finace);
            txtSales = itemView.findViewById(R.id.txt_sales);
            txtRank = itemView.findViewById(R.id.txt_rank);
            txtCity = itemView.findViewById(R.id.txt_city);
            cardView = itemView.findViewById(R.id.card_view_visible);
        }
    }



    @Override
    public int getItemCount() {

      //  return data == null?0 : data.size();
        if (data == null) {
            return 0;
        }

        if (data.size() == 0) {
            //Return 1 here to show nothing
            return 1;
        }

        // Add extra view to show the footer view
        return data.size();
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
