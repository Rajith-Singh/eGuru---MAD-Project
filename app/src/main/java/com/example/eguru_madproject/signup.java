package com.example.eguru_madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity implements View.OnClickListener {

    private TextView registerBtn;
    private EditText userName, userEmail, userPassword, userMobile;

    private FirebaseAuth mAuth;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        registerBtn = (Button)findViewById(R.id.signup_btn);
        registerBtn.setOnClickListener(this);

        userName = (EditText) findViewById(R.id.singup_name);
        userEmail = (EditText) findViewById(R.id.signup_email);
        userPassword = (EditText) findViewById(R.id.signup_password);
        userMobile = (EditText) findViewById(R.id.signup_mobile_num);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup_btn:
                registerBtn();
                break;
        }
    }

    private void registerBtn() {
        String email = userEmail.getText().toString().trim();
        String name =  userName.getText().toString().trim();
        String password =  userPassword.getText().toString().trim();
        String mobile =  userMobile.getText().toString().trim();

        if(name.isEmpty()){
            userName.setError("Name is Required");
            userName.requestFocus();
            return;
        }

        if(email.isEmpty()){
            userEmail.setError("Email is Required");
            userEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            userEmail.setError("Please provide valid email address");
            userEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            userPassword.setError("Password is Required");
            userPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            userPassword.setError("Minimum password length should be 6 characters");
            userPassword.requestFocus();
            return;
        }

        if(mobile.isEmpty()){
            userMobile.setError("Mobile Number is Required");
            userMobile.requestFocus();
            return;
        }

        if(!(mobile.length() == 10)){
            userMobile.setError("Please input valid mobile number");
            userMobile.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(name, email, password, mobile);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(signup.this, "User has been registered", Toast.LENGTH_LONG).show();
                                    } else{
                                        Toast.makeText(signup.this, "Failed to register, Try again!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(signup.this, "Failed to register, Try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}























