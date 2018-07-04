package com.example.armando.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class ViewCourseDetail extends AppCompatActivity {

    public static TextView txtDepartment;
    public static TextView txtInstructor;
    public static TextView txtName;
    public static TextView txtNumber;
    public static TextView txtSemester;
    public static TextView txtYear;
    public static TextView txtDescription;
    public static TextView txtEnrolment;

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
        txtEnrolment = findViewById(R.id.Enrolment);

        HashMap<String, String> courseDetails = (HashMap<String, String>)getIntent().getSerializableExtra("course");
        txtDepartment.setText(courseDetails.get("department"));
        txtInstructor.setText(courseDetails.get("instructor"));
        txtName.setText(courseDetails.get("name"));
        txtNumber.setText(courseDetails.get("num"));
        txtSemester.setText(courseDetails.get("semester"));
        txtYear.setText(courseDetails.get("year"));
        txtDescription.setText(courseDetails.get("description"));
        txtEnrolment.setText((courseDetails.get("enrolment")+"/"+courseDetails.get("limit")));
    }
}
