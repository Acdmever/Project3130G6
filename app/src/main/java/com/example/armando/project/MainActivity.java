package com.example.armando.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Needed to connect to database
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FireBaseDatabase can be made private and final
        FirebaseDatabase db=FirebaseDatabase.getInstance();
    }

    public void onClickShowCourses(View view) {
        Intent intent = new Intent(this, CourseListActivity.class);
        startActivity(intent);

    }
}