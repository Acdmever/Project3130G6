package com.example.armando.project;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Student {
    private FirebaseDatabase db;
    private DatabaseReference ref;

    private String firstName = new String();
    private String lastName = new String();
    private int id;

    public void Student(int id) {
        //this.db = FirebaseDatabase.getInstance();
        // or find the student with the given id
    }

    public void Student() {
        //this.db = FirebaseDatabase.getInstance();
        //this.ref = db.getReference("Test");

        System.out.println("Made a student");
        //create a new student in the database
    }

    String setFirstName(String fn) {
        this.db = FirebaseDatabase.getInstance();
        this.ref = db.getReference("Test");

        //set the first name in the database
        ref.setValue(fn);
        System.out.println(ref.toString());
        return ref.toString();
    }

    String getFirstName() {
        return "";
    }

    String writeMessage() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        return myRef.toString();
    }
}
