package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class addjob extends AppCompatActivity {

    private EditText subjectTxt,mediumTxt,gradeTxt,feeTxt;
    private Button addData;


//    private FirebaseDatabase db = FirebaseDatabase.getInstance();
//    private DatabaseReference root = db.getReference().child("TeacherAdds");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);

        subjectTxt = findViewById(R.id.t_job_subject);
        mediumTxt = findViewById(R.id.t_job_medium);
        gradeTxt = findViewById(R.id.t_job_grade);
        feeTxt = findViewById(R.id.t_job_fee);
        addData = findViewById(R.id.btn_add_job);
        DAOTadds dao = new DAOTadds();
        addData.setOnClickListener(v->
        {
            Tadds add = new Tadds(subjectTxt.getText().toString(),
                                    mediumTxt.getText().toString(),
                                    gradeTxt.getText().toString(),
                                    feeTxt.getText().toString());
            dao.add(add).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"Record is inserted", Toast.LENGTH_LONG).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_LONG).show();
            });
        });



    }
}