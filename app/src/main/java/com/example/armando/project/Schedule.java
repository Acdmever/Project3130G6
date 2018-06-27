package com.example.armando.project;

import java.util.ArrayList;
import java.util.Collections;

public class Schedule {
    public Student student;
    public String semester;
    public String year;
    public ArrayList<Course> courses=new ArrayList<Course>();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    public ArrayList<String> getSchedule(String day){
        ArrayList<String> schedule=new ArrayList<String>();
        for (Course c:courses){
            String s;
            if (c.lectures.hasLectureOn(day)) {
                s = c.lectures.getCourseOfDay(day) + "\n\t" + c.department + " " + c.num+ " Lecture\n";
                schedule.add(s);
            }
            if (c.tutorials.hasLectureOn(day)){
                s = c.tutorials.getCourseOfDay(day) + "\n\t" + c.department + " " + c.num+" Tutorial\n";
                schedule.add(s);

            }


        }
        Collections.sort(schedule);
        return schedule;
    }
}