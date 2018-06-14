package com.example.armando.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Needed to connect to database
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Database db=new Database();
        Student s=db.getStudent("0");
        TextView text=findViewById(R.id.textView);
        text.setText(s.getUsername()+" "+s.getLastName());*/
        update();
    }
    public void update(){
        Database db=new Database();
        Student s=db.getStudent("0");
        TextView text=findViewById(R.id.textView);

        text.setText(s.getFirstName()+" "+s.getLastName());
    }
}
