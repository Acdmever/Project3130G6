package com.example.armando.project;

import java.util.ArrayList;

public class Schedule {
    public Student student;
    public String semester;
    public String year;
    public ArrayList<Course> courses;

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
            
        }
        return schedule;
    }
}
