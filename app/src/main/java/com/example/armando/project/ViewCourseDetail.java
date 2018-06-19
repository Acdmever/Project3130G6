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

        showCourseDetail(getIntent().getStringArrayExtra("course"));
    }

    private void showCourseDetail(String[] courseDetails) {
        txtDepartment.setText(courseDetails[0]);
        txtInstructor.setText(courseDetails[1]);
        txtName.setText(courseDetails[2]);
        txtNumber.setText(courseDetails[3]);
        txtSemester.setText(courseDetails[4]);
        txtYear.setText(courseDetails[5]);
        txtDescription.setText(courseDetails[6]);
    }
}
