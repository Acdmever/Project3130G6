package com.example.armando.project;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class logIn {

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference ref = db.getReference("Students");
    String foundUser, foundPass;
    Boolean validUser = true;

    public int validate(String inputUser, final String inputPass) {
        Query query = ref.orderByChild("username").equalTo(inputUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() > 0) {
                    Student student = new Student();
                    foundUser = student.getUsername();
                    foundPass = student.getPassword();
                    if (inputPass.equals(foundPass))
                        validUser = true;
                    else
                        validUser = false;
                } else {
                    validUser = false;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        if (validUser)
            return 1;
        else
            return 0;
    }
}
