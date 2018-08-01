package com.example.armando.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * The heart of the application.
 * Gives users the option the view courses, view schedule, or log out
 * @author Joel
 * @author Armando
 * @author Matt
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Brings the user to the LogIn activity
     * @param view
     */
    public void onClickGoToLogIn(View view) {
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
        finish();
    }

    /**
     * Brings the user to the CourseList activity
     * @param view
     */
    public void onClickShowCourses(View view) {
        Intent intent = new Intent(this, CourseListActivity.class);
        intent.putExtra("studentId", getIntent().getStringExtra("studentId"));

        intent.putExtra("degree", getIntent().getStringExtra("degree"));
        startActivity(intent);
    }
  
    /**
     * Brings the user to the Schedule activity
     * @param view
     */
    public void onClickViewSchedule(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        intent.putExtra("String", getIntent().getStringExtra("studentId"));
        startActivity(intent);
    }
}