package com.example.armando.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Schedule object that sorts courses by day and time
 * @author Luis Armando Cordero
 **/

public class Schedule {
    public Student student;
    public String semester;
    public String year;
    public ArrayList<Course> courses=new ArrayList<Course>();

    /**
     * Get the student that owns the schedule
     * @return student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Set the student that owns the schedule
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Get the semester that this schedule is for
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Set the semester that this schedule is for
     * @param semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the year that this schedule is for
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * Set the year that this schedule is for
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Get the courses that the schedule displays classes for
     * @return courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Set the courses that the schedule displays classes for
     * @param courses
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Get the list of classes sorted by time for the given day
     * @param day
     * @return
     */
    public ArrayList<String> getSchedule(String day){
        ArrayList<String> schedule=new ArrayList<String>();
        for (Course c:courses){
            String s;
            if (c.getLectures().hasLectureOn(day)) {
                s = c.getLectures().getCourseOfDay(day) + "\n\t" + c.getDepartment() + " " + c.getNum().toString()+ " Lecture\n";
                schedule.add(s);
            }
            if (c.getTutorials().hasLectureOn(day)){
                s = c.getTutorials().getCourseOfDay(day) + "\n\t" + c.getDepartment() + " " + c.getNum().toString()+" Tutorial\n";
                schedule.add(s);
            }
        }
        Collections.sort(schedule);
        return schedule;
    }
}