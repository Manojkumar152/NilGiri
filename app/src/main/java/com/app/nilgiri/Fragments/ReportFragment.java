package com.app.nilgiri.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.nilgiri.R;

public class ReportFragment extends Fragment implements View.OnClickListener {
    Button adminBtn,tdsBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        adminBtn=view.findViewById(R.id.admin_charge);
        tdsBtn=view.findViewById(R.id.tds_charge);
        adminBtn.setOnClickListener(this);
        tdsBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.admin_charge:
                Intent intent= new Intent(getActivity(),AdminCharge.class);
                startActivity(intent);
                break;
            case R.id.tds_charge:
                Intent intent1= new Intent(getActivity(),TDSCharge.class);
                startActivity(intent1);
                break;
        }
    }
}
