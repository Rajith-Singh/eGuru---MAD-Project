package com.example.eguru_madproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOInstitudeJob {

    private DatabaseReference databaseReference;

    public DAOInstitudeJob()
    {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(InstituteJob.class.getSimpleName());
    }
    public Task<Void>add(InstituteJob job)
    {
        return databaseReference.push().setValue(job);
    }
    
}
