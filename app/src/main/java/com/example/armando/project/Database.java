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
    private Student student=new Student();
    public void Initialize(){
        //FirebaseApp.initializeApp();

    }
    public DatabaseReference startReference(String path){
        DatabaseReference ref=database.getReference(path);

        //Check if path exists
        return ref;
    }
    public Student getStudent(String id){
        Student sd=new Student();
        DatabaseReference ref=startReference("Student/").child(id);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student=dataSnapshot.getValue(Student.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //sd.setFirstName(ref.get);
        return sd;
    }
}
