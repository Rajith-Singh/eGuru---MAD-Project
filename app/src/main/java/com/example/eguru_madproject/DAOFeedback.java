package com.example.eguru_madproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOFeedback {
    private DatabaseReference databaseReference;

    public DAOFeedback() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(FeedbaackModel.class.getSimpleName());

    }

    public Task<Void> add(FeedbaackModel fe) {

        return databaseReference.push().setValue(fe);
    }

    public Task<Void> update(String key, HashMap<String, Object> hashMap)
    {
        return databaseReference.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key)
    {
        return databaseReference.child(key).removeValue() ;
    }

    public Query get()
    {
        return databaseReference.orderByKey();

    }


}
