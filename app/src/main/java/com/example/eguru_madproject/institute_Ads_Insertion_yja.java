package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class  institute_Ads_Insertion_yja extends AppCompatActivity{


    private TextView banner, insertAdsss;
    private  EditText et_name, et_classdetails, et_email, et_number;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_ads_insertion_yja);

        //banner =(TextView)  findViewById(R.id.tv_insertads_header);
        //banner.setOnClickListener(this);

        //insertAdsss = (Button) findViewById(R.id.btn_insertads_yja);
        //insertAdsss.setOnClickListener(this);

        //Assign Values
        final EditText et_name = findViewById(R.id.et_name_insertads_yja);
        final EditText et_classdetails = findViewById(R.id.et_classdetails_insertads_yja);
        final EditText et_email = findViewById(R.id.et_email_insertads_yja);
        final EditText et_number = findViewById(R.id.et_number_insertads_yja);






        ///////////////////
        //progressBar = (ProgressBar) findViewById(R.id.progressBar);


        Button btn_insertads = findViewById(R.id.btn_insertads_yja);
        DAOinstituteAds dao = new DAOinstituteAds();


        btn_insertads.setOnClickListener(v ->
        {

            //instituteAds insAds = new instituteAds(et_name.getText().toString(), et_classdetails.getText().toString(), et_email.getText().toString(), et_number.getText().toString());

            String name ;
            String classdetails;
            String email;
            String number;

            instituteAds insAds = new instituteAds(name = et_name.getText().toString(), classdetails = et_classdetails.getText().toString(), email = et_email.getText().toString(),number = et_number.getText().toString()  );

            if (name.isEmpty()){
                et_name.setError("Institute name is required!");
                et_name.requestFocus();
            }

            if (classdetails.isEmpty()){
                et_classdetails.setError("Class details is required!");
                et_classdetails.requestFocus();
            }

            if(classdetails.length() < 5){
                et_classdetails.setError("Min class details length should be 5 characters!");
            }

            if (email.isEmpty()){
                et_email.setError("Email is required!");
                et_email.requestFocus();
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                et_email.setError(("Please provide vaild email!"));
                et_email.requestFocus();
            }

            if (number.isEmpty()){
                et_number.setError("Number is required!");
                et_number.requestFocus();
            }





            dao.add(insAds).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, "+er.getMessage()", Toast.LENGTH_SHORT).show();
            });

        });




        Button btn_viewads = findViewById(R.id.inssAds);
        btn_viewads.setOnClickListener(v->
        {
            Intent intent = new Intent(institute_Ads_Insertion_yja.this, ShowActivity99.class);
            startActivity(intent);
        });


        Button btn_updateads = findViewById(R.id.jobbAds);
        btn_updateads.setOnClickListener(v->
        {
            Intent intent = new Intent(institute_Ads_Insertion_yja.this, updateAds.class);
            startActivity(intent);
        });







    }

}
