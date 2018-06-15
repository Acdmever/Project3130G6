package com.example.armando.project;

import android.os.Handler;
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
        final Database db=new Database();
        final Student s=new Student();
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                db.getStudent("0",s);
                TextView text=findViewById(R.id.textView);

                text.setText(s.getFirstName()+" "+s.getLastName());
                handler.postDelayed(this,500);
            }
        });
        //update();
    }
    public void update(){
        final Database db=new Database();
        final Student s=new Student();
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                db.getStudent("0",s);
                TextView text=findViewById(R.id.textView);

                text.setText(s.getFirstName()+" "+s.getLastName());
            }
        });

    }
}
