package com.example.eguru_madproject;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;
import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Tadds> list = new ArrayList<>();
    public RVAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Tadds> add)
    {
        list.addAll(add);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new TaddsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        TaddsVH vh = (TaddsVH) holder;
        Tadds add = list.get(position);
        vh.txt_subject.setText(add.getSubject());
        vh.txt_medium.setText(add.getMedium());
        vh.txt_grade.setText(add.getGrade());
        vh.txt_fee.setText(add.getFee());
        vh.txt_option.setOnClickListener(v->
        {
            PopupMenu popupMenu = new PopupMenu(context, vh.txt_option);
            popupMenu.inflate(R.menu.options_menu);
            popupMenu.setOnMenuItemClickListener(item->
            {
                switch (item.getItemId())
                {
                    case R.id.menu_edit:
                        Intent intent = new Intent(context,addjob.class);
                        intent.putExtra("EDIT", add);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_remove:
                        DAOTadds dao = new DAOTadds();
                        dao.remove(add.getKey()).addOnSuccessListener(suc->
                        {
                            Toast.makeText(context,"Record is removed", Toast.LENGTH_LONG).show();
                            notifyItemRemoved(position);
                        }).addOnFailureListener(er->
                        {
                            Toast.makeText(context,""+er.getMessage(), Toast.LENGTH_LONG).show();
                        });
                        break;
                }
                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
