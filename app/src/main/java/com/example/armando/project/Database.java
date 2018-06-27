package com.example.armando.project;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Database {
    private final FirebaseDatabase database=FirebaseDatabase.getInstance();
    private Student student=new Student();
    //public Task<Void>fetchTask;


    public DatabaseReference startReference(String path){
        DatabaseReference ref=database.getReference(path);

        //Check if path exists
        return ref;
    }
    public Student getStudent(String id){
        //fetchTask= FirebaseRemoteConfig.getInstance().fetch();
        DatabaseReference ref=startReference("Students").child("id").child("username");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.username=dataSnapshot.getValue(String.class).toString();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        }

        );
        return this.student;

    }
}
