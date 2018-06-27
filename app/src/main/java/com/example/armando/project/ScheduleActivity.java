package com.example.armando.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;



import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {
    //public Schedule schedule=new Schedule();
    public Student student = new Student();
    public Course c0=new Course("CSCI", "Johnny F", "Winter","Intro","1100", "2018");
    public Course c1=new Course("CSCI", "Johnny D", "Winter","Intro","1101", "2018");
    public Course c2=new Course("CSCI", "Johnny T", "Winter","Intro","2100", "2018");
    public Schedule s=new Schedule();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity);

        Database db = new Database();

        Lecture l0= new Lecture();
        l0.setMonday("10:05-11:25");
        l0.setWednesday("10:05-11:25");
        Lecture t0=new Lecture();
        t0.setTuesday("13:30-14:30");
        Lecture l1=new Lecture();
        l1.setMonday("11:35-12:00");
        l1.setWednesday("11:35-12:00");
        Lecture l2=new Lecture();
        l2.setTuesday("10:05-11:25");
        l2.setThursday("10:05-11:25");
        s.courses=new ArrayList<Course>();
        c0.lectures=l0;
        c0.tutorials=t0;
        c1.lectures=l1;
        c2.lectures=l2;
        s.courses.add(c0);
        s.courses.add(c1);
        s.courses.add(c2);

        //Schedule schedule = db.getSchedule("ID");

    }
    public void getDay(View view){
        Spinner mySpinner=findViewById(R.id.daySpinner);
        String spinnerText=mySpinner.getSelectedItem().toString();
        ArrayList<String> list= s.getSchedule(spinnerText.toString());
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
}
