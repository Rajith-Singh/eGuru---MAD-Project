package com.example.eguru_madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class institute_ads_manage_yja extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ManageAdsAdapter adapter; //RVAdapter adapter;
    DAOinstituteAds dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_ads_manage_yja);
        swipeRefreshLayout = findViewById(R.id.swip);
        //rv = recycle View
        recyclerView = findViewById(R.id.institute_ads_manage_yja);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //RVAdapter = RecycleView Adapter
        adapter = new ManageAdsAdapter(this);
        recyclerView.setAdapter(adapter);
        dao = new DAOinstituteAds();
        loadData();

    }

    private void loadData() {
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<instituteAds> insAdss = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    instituteAds insAds = data.getValue(instituteAds.class);
                    insAdss.add(insAds);
                }

                adapter.setItems(insAdss);
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}