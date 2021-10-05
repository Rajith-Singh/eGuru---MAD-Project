package com.example.eguru_madproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManageAdsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<instituteAds> list = new ArrayList<>();
    public ManageAdsAdapter(Context ctx)
    {
        this.context = ctx;
    }

    public void setItems(ArrayList<instituteAds> insAds)
    {
        list.addAll(insAds);

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_ads,parent,false);
        return new instituteAdsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        instituteAdsVH vh = (instituteAdsVH) holder;
        instituteAds insAds = list.get(position);
        vh.et_name.setText(insAds.getEt_name());
        vh.et_classdetails.setText(insAds.getEt_classdetails());
        vh.et_email.setText(insAds.getEt_email());
        vh.et_number.setText(insAds.getEt_number());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
