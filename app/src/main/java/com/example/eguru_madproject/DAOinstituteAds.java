package com.example.eguru_madproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Objects;

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

    public Task<Void> update(String key, HashMap<String , Object> hashMap){
        return  databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> remove(String key){
        return  databaseReference.child(key).removeValue();
    }




}
