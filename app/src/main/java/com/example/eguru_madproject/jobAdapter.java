package com.example.eguru_madproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class jobAdapter extends RecyclerView.Adapter<jobAdapter.jobViewHolder> {



    ArrayList<modelH>mList;
    Context context;

    public jobAdapter(Context context , ArrayList<modelH>mList){
        this.mList = mList;
        this.context =context;
    }

    @NonNull
    @Override
    public jobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.job , parent , false);
        return new jobViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull jobViewHolder holder, int position) {

        modelH model = mList.get(position);
        holder.aname.setText(model.getAname());
        holder.asubject.setText(model.getAsubject());
        holder.agrade.setText(model.getAgrade());
        holder.aarea.setText(model.getAarea());
        holder.acontact.setText(model.getAcontact());

    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public static class jobViewHolder extends RecyclerView.ViewHolder {

        TextView aname, asubject, agrade, aarea, acontact;

        public jobViewHolder(@NonNull View itemView) {
            super(itemView);

            aname = itemView.findViewById(R.id.namehh_text);
            asubject = itemView.findViewById(R.id.subhh_text);
            agrade = itemView.findViewById(R.id.gradehh_text);
            aarea = itemView.findViewById(R.id.addAreaH);
            acontact = itemView.findViewById(R.id.contacthh_text);


        }
    }
}
