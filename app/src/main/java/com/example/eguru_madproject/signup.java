package com.example.eguru_madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    private TextInputEditText nameEdit, emailEdit, pawEdit, mobileEdit;
    private Button registerBtn;
    private TextView loginform;
    private FirebaseAuth mAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameEdit = findViewById(R.id.singup_name);
        emailEdit = findViewById(R.id.signup_email);
        pawEdit = findViewById(R.id.signup_password);
        mobileEdit = findViewById(R.id.signup_mobile_num);
        loginform = findViewById(R.id.signup_mobile_num);
        registerBtn = findViewById(R.id.signup_btn);



    }
}