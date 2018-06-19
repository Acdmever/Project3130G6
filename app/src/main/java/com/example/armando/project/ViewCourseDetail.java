package com.example.armando.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewCourseDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course_detail);
    }

    public boolean showCourseDetail(String[] courseDetails) {
        //When course name is clicked, details of course are fetched from the DB
        //Details are then displayed on the UI
        return true;
    }
}
