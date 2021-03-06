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

    private Course c0=new Course();
    private Course c1=new Course();
    private Course c2=new Course();
    private Schedule s=new Schedule();

    @Before
    public void start() {
        c0.setDepartment("CSCI");
        c0.setNum(Long.valueOf(1100));
        c1.setDepartment("CSCI");
        c1.setNum(Long.valueOf(1101));
        c2.setDepartment("CSCI");
        c2.setNum(Long.valueOf(2100));
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
        c0.setLectures(l0);
        c0.setTutorials(t0);
        c1.setLectures(l1);
        c2.setLectures(l2);
        s.addCourse(c0);
        s.addCourse(c1);
        s.addCourse(c2);
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