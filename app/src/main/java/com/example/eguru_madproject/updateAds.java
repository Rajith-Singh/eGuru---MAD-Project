package com.example.eguru_madproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class updateAds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ads);
        final EditText et_name = findViewById(R.id.et_name_insertads_yja);
        final EditText et_classdetails = findViewById(R.id.et_classdetails_insertads_yja);
        final EditText et_email = findViewById(R.id.et_email_insertads_yja);
        final EditText et_number = findViewById(R.id.et_number_insertads_yja);
        Button btn_insertads = findViewById(R.id.btn_insertads_yja);
        Button btn_insertads2 = findViewById(R.id.btn_insertads_yja2);
        DAOinstituteAds dao = new DAOinstituteAds();


        btn_insertads.setOnClickListener(v ->
        {
            /*

            instituteAds insAds = new instituteAds(et_name.getText().toString(), et_classdetails.getText().toString(), et_email.getText().toString(), et_number.getText().toString());
            dao.add(insAds).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, "+er.getMessage()", Toast.LENGTH_SHORT).show();
            });
            */

            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("et_name",et_name.getText().toString());
            hashMap.put("et_classdetails",et_classdetails.getText().toString());
            hashMap.put("et_email",et_email.getText().toString());
            hashMap.put("et_number",et_number.getText().toString());




            dao.update("-MkT1w_CJUL9EKzpRv7a",hashMap).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, "+er.getMessage()", Toast.LENGTH_SHORT).show();
            });



        });

        btn_insertads2.setOnClickListener(v ->
        {
            dao.remove("-MkT1w_CJUL9EKzpRv7a")
                    .addOnSuccessListener(suc ->
                    {
                        Toast.makeText(this, "Record is removed", Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener(er ->
            {
                Toast.makeText(this, "+er.getMessage()", Toast.LENGTH_SHORT).show();
            });
        });



        Button btn_viewads = findViewById(R.id.inssAds);
        btn_viewads.setOnClickListener(v->
        {
            Intent intent = new Intent(updateAds.this, ShowActivity99.class);
            startActivity(intent);
        });



    }
}