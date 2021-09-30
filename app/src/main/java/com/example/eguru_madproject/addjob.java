package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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
    private Button addData,showAll;


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
        showAll = findViewById(R.id.btn_show_all);
        showAll.setOnClickListener(v->
        {
            Intent intent = new Intent(addjob.this, t_addView.class);
            startActivity(intent);
        });
        DAOTadds dao = new DAOTadds();
        Tadds add_edit = (Tadds)getIntent().getSerializableExtra("EDIT");
        if(add_edit != null)
        {
            addData.setText("UPDATE");
            subjectTxt.setText(add_edit.getSubject());
            mediumTxt.setText(add_edit.getMedium());
            gradeTxt.setText(add_edit.getGrade());
            feeTxt.setText(add_edit.getFee());
            showAll.setVisibility(View.GONE);
        } else {
            addData.setText("SUBMIT");
            showAll.setVisibility(View.VISIBLE);
        }
        addData.setOnClickListener(v->
        {
            Tadds add = new Tadds(subjectTxt.getText().toString(),
                                    mediumTxt.getText().toString(),
                                    gradeTxt.getText().toString(),
                                    feeTxt.getText().toString());
            if(add_edit==null){
            dao.add(add).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"Record is inserted", Toast.LENGTH_LONG).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_LONG).show();
            });
            }
            else{
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("subject", subjectTxt.getText().toString());
                hashMap.put("medium", mediumTxt.getText().toString());
                hashMap.put("grade", gradeTxt.getText().toString());
                hashMap.put("fee", feeTxt.getText().toString());
                dao.update(add_edit.getKey(),hashMap).addOnSuccessListener(suc->
                {
                    Toast.makeText(this,"Record is updated", Toast.LENGTH_LONG).show();
                    finish();
                }).addOnFailureListener(er->
                {
                    Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_LONG).show();
                });
            }

        });




    }
}