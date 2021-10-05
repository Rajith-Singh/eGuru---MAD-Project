package com.example.eguru_madproject;


import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter99 extends RecyclerView.Adapter<MyAdapter99.MyViewHolder>
{

    ArrayList<Model99> mList;
    Context context;

    public MyAdapter99(Context context , ArrayList<Model99> mList){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item99, parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model99 model99 = mList.get(position);
        holder.et_name.setText(model99.getEt_name());
        holder.et_classetails.setText(model99.getEt_classdetails());
        holder.et_email.setText(model99.getEt_email());
        holder.et_number.setText(model99.getEt_number());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

         TextView et_name, et_classetails , et_email , et_number;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            et_name = itemView.findViewById(R.id.name_text);
            et_classetails = itemView.findViewById(R.id.classdetails_text);
            et_email = itemView.findViewById(R.id.email_text);
            et_number = itemView.findViewById(R.id.number_text);

        }
    }

}
