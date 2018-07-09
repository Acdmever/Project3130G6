package com.example.armando.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * ScheduleActivity.java
 * Fetches courses from Firebase and makes them into a Schedule
 * Then displays the student's schedule
 *@author Luis Armando Cordero
 **/

public class ScheduleActivity extends AppCompatActivity {
    private final String id="0";
    private Schedule s;
    private DatabaseReference ref;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference();
        s=new Schedule();
        s.courses=new ArrayList<>();
        makeSchedule();
    }
    public void getDay(View view){
        Spinner mySpinner=findViewById(R.id.daySpinner);
        String spinnerText=mySpinner.getSelectedItem().toString();
        ArrayList<String> list= s.getSchedule(spinnerText);
        String[] rows=scheduleRow(list);
        TextView row0 = findViewById(R.id.row1);
        TextView row1 = findViewById(R.id.row2);
        TextView row2 = findViewById(R.id.row3);
        TextView row3 = findViewById(R.id.row4);
        TextView row4 = findViewById(R.id.row5);
        TextView row5 = findViewById(R.id.row6);
        TextView row6 = findViewById(R.id.row7);
        TextView row7 = findViewById(R.id.row8);
        TextView row8 = findViewById(R.id.row9);
        TextView row9 = findViewById(R.id.row10);
        row0.setText(rows[0]);
        row1.setText(rows[1]);
        row2.setText(rows[2]);
        row3.setText(rows[3]);
        row4.setText(rows[4]);
        row5.setText(rows[5]);
        row6.setText(rows[6]);
        row7.setText(rows[7]);
        row8.setText(rows[8]);
        row9.setText(rows[9]);


    }
    public String[] scheduleRow(ArrayList<String>list){
        String[] rows=new String[10];
        for (int i=0;i<10;i++){
            rows[i]="\t";
        }
        for (String s:list){
            String[] help=s.split(":");
            int num=Integer.parseInt(help[0]);
            rows[num-8]+=s;
        }
        return rows;
    }
    public void makeSchedule(){

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> courses=getCourseList(dataSnapshot);
                for (DataSnapshot dsp: dataSnapshot.child("Courses").getChildren()){
                    for (String c:courses){

                        if (dsp.getKey().equals(c)){
                            Course course=getDBCourse(dsp);
                            s.courses.add(course);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public ArrayList<String> getCourseList(DataSnapshot dataSnapshot){
        ArrayList<String> courses=new ArrayList<>();
        for (DataSnapshot dsp: dataSnapshot.child("Registrations").getChildren()){
            String reg[] =dsp.getKey().split("-");

            if (reg[1].equals(id)){
                courses.add(reg[0]);
            }
        }
        return courses;
    }
    public Course getDBCourse(DataSnapshot dsp){
        Course course=new Course();
        course.setDepartment(dsp.child("department").getValue(String.class));
        course.setNum(dsp.child("num").getValue(Long.class));
        Lecture lec= setLectures(dsp.child("lectures"));
        Lecture tut= setLectures(dsp.child("tutorials"));
        course.setLectures(lec);
        course.setTutorials(tut);
        return course;
    }
    public Lecture setLectures(DataSnapshot dsp){
        Lecture lec=new Lecture();
        if(dsp.hasChild("monday"))
            lec.setMonday(dsp.child("monday").getValue(String.class));
        if(dsp.hasChild("tuesday"))
            lec.setTuesday(dsp.child("tuesday").getValue(String.class));
        if(dsp.hasChild("wednesday"))
            lec.setWednesday(dsp.child("wednesday").getValue(String.class));
        if(dsp.hasChild("thursday"))
            lec.setThursday(dsp.child("thursday").getValue(String.class));
        if(dsp.hasChild("friday"))
            lec.setFriday(dsp.child("friday").getValue(String.class));
        return lec;
    }


}