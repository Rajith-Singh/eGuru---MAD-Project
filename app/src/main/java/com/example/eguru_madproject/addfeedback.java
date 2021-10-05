package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class addfeedback extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfeedback);
        EditText enter_nameDul = findViewById(R.id.enter_nameDul);
        EditText enter_uremailDul= findViewById(R.id.enter_uremailDul);
        EditText  enter_feedback=findViewById(R.id.enter_feedback);
        Button btn = findViewById(R.id.btn_submitfeedback);
        Button btn2=findViewById(R.id.btn_openD);


        DAOFeedback dao=new DAOFeedback();
        btn.setOnClickListener(v->{
            FeedbaackModel fe = new FeedbaackModel(enter_nameDul.getText().toString(), enter_uremailDul.getText().toString(),enter_feedback.getText().toString() );
           dao.add(fe).addOnSuccessListener(suc->
            {
                Toast.makeText(this , "Recording is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(en->
            {
                Toast.makeText(this, "+er.getMessage()", Toast.LENGTH_SHORT).show();
            });
        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(addfeedback.this,showActivity.class));
            }
            });


    }


}