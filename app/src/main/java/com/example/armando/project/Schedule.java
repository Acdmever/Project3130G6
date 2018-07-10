package com.example.armando.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Schedule.java
 * Schedule object
 *@author Luis Armando Cordero
 *
 **/

public class Schedule {
    private Student student=new Student();
    private String semester;
    private String year;
    private ArrayList<Course> courses=new ArrayList<>();

    /**
     * Empty constructor required by firebase
     */
    public Schedule(){

    }

    /**
     * Get the student that this schedule belongs to
     *
     * @return student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Set the student that this schedule belongs to
     *
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Get the the semester
     *
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Set the semester
     *
     * @param  semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the year
     *
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * Set the year
     *
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Get the course list
     *
     * @return courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Set the course list
     *
     * @param courses
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Add a course to the course list
     *
     * @param course
     */
    public void addCourse(Course course){
        this.courses.add(course);
    }

    /**
     * Format the courses in the schedule
     *
     * @return schedule list
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