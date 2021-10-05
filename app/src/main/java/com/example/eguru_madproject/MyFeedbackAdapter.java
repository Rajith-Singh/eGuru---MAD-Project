package com.example.eguru_madproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyFeedbackAdapter extends RecyclerView.Adapter <MyFeedbackAdapter.MyViewHolder> {

    ArrayList<FeedbaackModel> mList;
    Context context;

    public MyFeedbackAdapter(Context context, ArrayList<FeedbaackModel> mList){
        this.mList=mList;
        this.context=context;
    }

    public void updateFeedback(int position){
        FeedbaackModel item= mList.get(position);
        Bundle bundle=new Bundle();
        bundle.putString("Name",item.getStudentName());
        bundle.putString("Email",item.getStudentEmail());
        bundle.putString("Feedback",item.getStudentFeedback());
        Intent intent = new Intent(context, addfeedback.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
        }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FeedbaackModel model= mList.get(position);
        holder.Name.setText(model.getStudentName());
        holder.Email.setText(model.getStudentEmail());
        holder.Feedback.setText(model.getStudentFeedback());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView Name,Email,Feedback;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            Name=itemView.findViewById(R.id.text_nameDu);
            Email =itemView.findViewById(R.id.text_mailDu);
            Feedback=itemView.findViewById(R.id.text_feedDu);

        }
    }
}
