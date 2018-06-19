package com.example.armando.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewCourseDetail extends AppCompatActivity {

    public static TextView txtDepartment;
    public static TextView txtInstructor;
    public static TextView txtName;
    public static TextView txtNumber;
    public static TextView txtSemester;
    public static TextView txtYear;
    public static TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course_detail);

        txtDepartment = findViewById(R.id.Department);
        txtInstructor = findViewById(R.id.Instructor);
        txtName = findViewById(R.id.Name);
        txtNumber = findViewById(R.id.Number);
        txtSemester = findViewById(R.id.Semester);
        txtYear = findViewById(R.id.Year);
        txtDescription = findViewById(R.id.Description);

    }

    public boolean showCourseDetail(String[] courseDetails) {
        //When course name is clicked, details of course are fetched from the DB
        //Details are then displayed on the UI
        return true;
    }
}
