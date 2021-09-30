package com.example.eguru_madproject;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaddsVH extends RecyclerView.ViewHolder
{
    public TextView txt_subject,txt_medium,txt_grade,txt_fee,txt_option;

    public TaddsVH(@NonNull View itemView)
    {
        super(itemView);
        txt_subject = itemView.findViewById(R.id.txt_subject);
        txt_medium = itemView.findViewById(R.id.txt_medium);
        txt_grade = itemView.findViewById(R.id.txt_grade);
        txt_fee = itemView.findViewById(R.id.txt_fee);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
