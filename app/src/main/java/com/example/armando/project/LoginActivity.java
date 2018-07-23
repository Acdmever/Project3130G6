package com.example.armando.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
/**
 * * A login screen that offers login via username/password.
 * @author Joel Fong
 */
public class LoginActivity extends AppCompatActivity {

    private EditText inputUserView;
    private EditText inputPassView;
    private TextView statusMessage;
    private logIn logInAttempt;
    private String inputUser, inputPass, foundUser, foundPass;
    private int validUser = 0;

    private DatabaseReference ref;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=FirebaseDatabase.getInstance();
        ref = db.getReference("Students");

        //Setting up the login fields
        inputUserView = findViewById(R.id.username);
        inputPassView = findViewById(R.id.password);
        statusMessage = findViewById(R.id.statusMessage);
        logInAttempt = new logIn();

        //Set button
        final Button validateButton = findViewById(R.id.signInButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                inputUser = inputUserView.getText().toString();
                inputPass = inputPassView.getText().toString();

                //Find login info
                Query query = ref.orderByChild("username").equalTo(inputUser);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot datas: dataSnapshot.getChildren()){
                            foundUser = datas.child("username").getValue().toString();
                            foundPass = datas.child("password").getValue().toString();
                            if (inputPass.equals(foundPass)) {
                                validUser = 1;
                                break;
                            }
                            else
                                validUser = 0;
                        }
                        if (dataSnapshot == null)
                            validUser = 0;
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                if (validUser == 1 || logInAttempt.validate(inputUser, inputPass) == 1)
                    onClickGoToMainMenu();
                else
                    statusMessage.setText("Invalid username/password");

                inputUserView.setText("");
                inputPassView.setText("");
            }
        });
    }

    private void onClickGoToMainMenu() {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }
}

