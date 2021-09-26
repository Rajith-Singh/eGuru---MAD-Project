package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class  institute_Ads_Insertion_yja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_ads_insertion_yja);
        final EditText et_name = findViewById(R.id.et_name_insertads_yja);
        final EditText et_classdetails = findViewById(R.id.et_classdetails_insertads_yja);
        final EditText et_email = findViewById(R.id.et_email_insertads_yja);
        final EditText et_number = findViewById(R.id.et_number_insertads_yja);
        Button btn_insertads = findViewById(R.id.btn_insertads_yja);
        DAOinstituteAds dao = new DAOinstituteAds();
        btn_insertads.setOnClickListener(v ->
        {
            instituteAds insAds = new instituteAds(et_name.getText().toString(), et_classdetails.getText().toString(), et_email.getText().toString(), et_number.getText().toString());
            dao.add(insAds).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, "+er.getMessage()", Toast.LENGTH_SHORT).show();
            });

        });


        Button btn_viewads = findViewById(R.id.btn_viewads_yja);
        btn_viewads.setOnClickListener(v->
        {
            Intent intent = new Intent(institute_Ads_Insertion_yja.this, ShowActivity99.class);
            startActivity(intent);
        });




    }
}