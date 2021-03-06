package com.example.eguru_madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class r_profile extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    private Button logout, myads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rprofile);

        logout = (Button) findViewById(R.id.btn_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(r_profile.this,t_login.class));
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingTextView = (TextView) findViewById(R.id.txt_welcome);
        final TextView emailTextView = (TextView) findViewById(R.id.profile_email);
        final TextView mobileTextView = (TextView) findViewById(R.id.profile_mobile);
        final TextView nameTextView = (TextView) findViewById(R.id.profile_name_txt);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null){
                    String name = userProfile.name;
                    String email = userProfile.email;
                    String mobile = userProfile.mobile;

                    greetingTextView.setText("Welcome,"+ name + "!");
                    emailTextView.setText(email);
                    mobileTextView.setText(mobile);
                    nameTextView.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(r_profile.this, "Something wrong happened", Toast.LENGTH_LONG).show();
            }
        });

        myads = (Button) findViewById(R.id.btn_go_ads);

        myads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddJobActivity();
            }
        });
    }


    private void openAddJobActivity() {
        Intent intent = new Intent(r_profile.this,addjob.class);
        startActivity(intent);
    }
}

