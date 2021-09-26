package com.example.eguru_madproject;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class instituteAdsVH extends RecyclerView.ViewHolder
{

    public TextView et_name,et_classdetails,et_email,et_number;
    public instituteAdsVH(@NonNull View itemView) {
        super(itemView);
        et_name = itemView.findViewById(R.id.et_name_insertads_yja);
        et_classdetails = itemView.findViewById(R.id.et_classdetails_insertads_yja);
        et_email = itemView.findViewById(R.id.et_email_insertads_yja);
        et_number = itemView.findViewById(R.id.et_number_insertads_yja);
    }
}
