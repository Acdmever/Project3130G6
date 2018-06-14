package com.example.armando.project;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Database {
    private final FirebaseDatabase database=FirebaseDatabase.getInstance();
    //private final Student student=new Student();
    private DatabaseReference ref=database.getReference("");


    public DatabaseReference startReference(String path){
        DatabaseReference ref=database.getReference(path);

        //Check if path exists
        return ref;
    }
    public Student getStudent(String id){
        final Student student=new Student();
        //ref=startReference("Student/0/username");
        DatabaseReference ref=database.getReference("Student").child(id).child("username");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object s=dataSnapshot.getValue();
                student.setUsername(s.toString());
                //student.setFirstName(s.getFirstName());
                //student.setLastName(s.getLastName());
                //student.setPassword(s.getPassword());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        }

        );
        return student;

    }
}
