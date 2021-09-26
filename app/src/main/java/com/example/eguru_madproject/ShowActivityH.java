package com.example.eguru_madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowActivityH extends AppCompatActivity {

    private RecyclerView recyclerViewH;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("InstituteJob");
    private jobAdapter adapter;
    private ArrayList<modelH>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_h);

        recyclerViewH = findViewById(R.id.recycleViewH);
        recyclerViewH.setHasFixedSize(true);
        recyclerViewH.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new jobAdapter(this , list);

        recyclerViewH.setAdapter(adapter);
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    modelH model = dataSnapshot.getValue(modelH.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}