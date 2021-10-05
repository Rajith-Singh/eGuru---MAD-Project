package com.example.eguru_madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class t_login extends AppCompatActivity implements View.OnClickListener{

    private TextView register,forgotPassword;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlogin);

        register = (TextView) findViewById(R.id.registerlink);
        register.setOnClickListener(this);

        signIn = (Button) findViewById(R.id.login_r);
        signIn.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.login_input_t);
        editTextPassword = (EditText) findViewById(R.id.input_pw_t);

        mAuth = FirebaseAuth.getInstance();

        forgotPassword = (TextView) findViewById(R.id.login_fogotten_pw);
        forgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerlink:
                startActivity(new Intent(this, signup.class));
                break;

            case R.id.login_r:
                userLogin();
                break;

            case R.id.login_fogotten_pw:
                startActivity(new Intent(this,forgotten_password.class));
                break;
        }
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()) {
            editTextEmail.setError("Email is Required");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email address");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is Required");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Minimum password length should be 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()){
                        startActivity(new Intent(t_login.this,r_profile.class));
                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(t_login.this, "Check your Email to verify your account", Toast.LENGTH_LONG).show();
                    }
                    //redirect to user profile

                } else {
                    Toast.makeText(t_login.this, "Failed to login", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
