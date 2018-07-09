package com.example.armando.project;

import com.google.firebase.FirebaseApp;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ScheduleTest {

    public Student student = new Student();
    public Course c0=new Course("CSCI", "Johnny F", "Winter","Intro",Long.valueOf(1100), "2018");
    public Course c1=new Course("CSCI", "Johnny D", "Winter","Intro",Long.valueOf(1101), "2018");
    public Course c2=new Course("CSCI", "Johnny T", "Winter","Intro",Long.valueOf(2100), "2018");
    public Schedule s=new Schedule();

    @Before
    public void start() {

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
    }

    @Test
    public void monday() {
        ArrayList<String>li=s.getSchedule("monday");
        String str="";
        for (String st:li){
            str+=st;
        }
        assertEquals("10:05-11:25\n\tCSCI 1100 Lecture\n11:35-12:00\n\tCSCI 1101 Lecture\n",str);
    }
    @Test
    public void tuesday() {
        ArrayList<String>li=s.getSchedule("tuesday");
        String str="";
        for (String st:li){
            str+=st;
        }
        assertEquals("10:05-11:25\n\tCSCI 2100 Lecture\n13:30-14:30\n\tCSCI 1100 Tutorial\n",str);
    }
    @Test
    public void wednesday(){
        ArrayList<String>li=s.getSchedule("wednesday");
        String str="";
        for (String st:li){
            str+=st;
        }
        assertEquals("10:05-11:25\n\tCSCI 1100 Lecture\n11:35-12:00\n\tCSCI 1101 Lecture\n",str);
    }
    @Test
    public void thursday() {
        ArrayList<String>li=s.getSchedule("thursday");
        String str="";
        for (String st:li){
            str+=st;
        }
        assertEquals("10:05-11:25\n\tCSCI 2100 Lecture\n",str);
    }
    @Test
    public void friday(){
        ArrayList<String>li=s.getSchedule("friday");
        String str="";
        for (String st:li){
            str+=st;
        }
        assertEquals("",str);
    }
}