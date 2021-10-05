package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class institute_ads_view_yja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_ads_view_yja);

        Button inssads = findViewById(R.id.inssAds);
        inssads.setOnClickListener(v->
        {
            Intent intent = new Intent(institute_ads_view_yja.this, institute_Ads_Insertion_yja.class);
            startActivity(intent);
        });


    }
}