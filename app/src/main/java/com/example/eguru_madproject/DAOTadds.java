package com.example.eguru_madproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOTadds {
    private DatabaseReference databaseReference;
    public DAOTadds()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Tadds.class.getSimpleName());
    }
    public Task<Void> add(Tadds add){
        return databaseReference.push().setValue(add);
    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }
}
