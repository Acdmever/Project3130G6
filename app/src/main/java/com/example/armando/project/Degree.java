package com.example.armando.project;

import java.util.ArrayList;
/**
 * Represent a degree and its requirements
 *
 * @author Dahn
 * @author Fahad
 */

public class Degree {

    private String name;
    private ArrayList<String> courses = new ArrayList<>();

    /**
     * Empty constructor required by firebase
     */
    public Degree(){

    }
    /**
     * This gets the list of courses
     * @return the list of courses in this degree
     */
    public Degree(String name,String key){
        this.name=name;
    }
    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
    /**
    * This sets a name of a degree
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * this gets the name of a degree
     * @return The name of a degree
     */
    public String getName() {
        return name;
    }
    /**
     * This adds a course to the list of courses required for the degree
     */
    public void addCourse(String courseName){ courses.add(courseName); }
    /**
     * This removes a course to the list of courses required for the degree
     */
    public void removeCourse(String courseName){ courses.remove(courseName); }
}
