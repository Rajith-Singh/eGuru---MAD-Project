package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddJobInstitute extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job_institute);
       EditText addInstituteNameH = findViewById(R.id.addInstituteNameH);
       EditText addSubjectH = findViewById(R.id.addSubjectH);
       EditText addGradeH = findViewById(R.id.addGradeH);
       EditText addAreaH = findViewById(R.id.addAreaH);
       EditText addContactH = findViewById(R.id.addContactH);
       Button buttonAddJobHH = findViewById(R.id.buttonAddJobH);
       Button buttonOpenHH = findViewById(R.id.buttonOpenH);
       DAOInstitudeJob dao= new DAOInstitudeJob();
       buttonAddJobHH.setOnClickListener(v->
                {
                    InstituteJob job = new InstituteJob(addInstituteNameH.getText().toString(),addSubjectH.getText().toString(),
                            addGradeH.getText().toString(),addAreaH.getText().toString(),addContactH.getText().toString());
                    dao.add(job).addOnSuccessListener(suc->
                    {
                        Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener(er->
                    {
                        Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();

                    });
                    



                });
        buttonOpenHH.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddJobInstitute.this, ShowActivityH.class));
            }
        });





    }
}