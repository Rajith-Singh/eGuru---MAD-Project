package com.example.eguru_madproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAOinstituteAds
{
    private DatabaseReference databaseReference;
    public DAOinstituteAds() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(instituteAds.class.getSimpleName());
    }

    public Task<Void> add(instituteAds insAds)
    {
        return databaseReference.push().setValue(insAds);
    }


    public Query get()
    {
       return databaseReference.orderByKey();

    }


}
