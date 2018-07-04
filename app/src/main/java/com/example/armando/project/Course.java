package com.example.armando.project;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String department;
    private String instructor;
    private Lecture lectures;
    private String semester;
    private String name;
    private Lecture tutorials;
    private int limit;
    private String year;
    private String description;
    private Long num;
    private String key;
    private ArrayList<String> students = new ArrayList();


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Course() { }

    public Course(String department, String instructor, String semester, String name, String key,
                  Long num, String year, String description, Lecture lectures, Lecture tutorials, int limit){
        this.key = key;
        this.department = department;
        this.instructor = instructor;
        this.semester = semester;
        this.name = name;
        this.num = num;
        this.year = year;
        this.description = description;
        this.lectures = lectures;
        this.lectures = tutorials;
        this.limit = limit;
    }

    public Lecture getTutorials() {
        return tutorials;
    }

    public void setTutorials(Lecture tutorials) {
        this.tutorials = tutorials;
    }

    public Lecture getLectures() {
        return lectures;
    }

    public void setLectures(Lecture lectures) {
        this.lectures = lectures;
    }
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNum() {
        return num;
    }

    public int getLimit() { return limit; }
    public void setLimit() { this.limit = limit; }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<String> students) {
        this.students = students;
    }

    public String makeHeaderString(){
       return getDepartment()+" "+getNum()+": "+getName();
    }

    public String makeFooterString(){
        return getSemester()+" "+getYear();
    }

    public HashMap<String, String> getCourseDetail() {
        HashMap<String, String> courseDetails = new HashMap<>();
        courseDetails.put("department", this.getDepartment());
        courseDetails.put("instructor", this.getInstructor());
        courseDetails.put("name", this.getName());
        courseDetails.put("num", this.getNum()+"");
        courseDetails.put("semester", this.getSemester());
        courseDetails.put("year", this.getYear());
        courseDetails.put("description", this.getDescription());
        courseDetails.put("enrolment", this.getStudents().size()+"");
        courseDetails.put("limit", this.getLimit()+"");

        return courseDetails;
    }

    private void addStudentToList(String studentKey){
        students.add(studentKey);
    }

    //This method should be used whenever a user registers for a course, it ensures the course's
    //user list is updated and a registration object created to match.
    public Registration addStudent(String studentKey){
        addStudentToList(studentKey);
        Registration reg =  new Registration(Integer.parseInt(key), Integer.parseInt(studentKey));
        return reg;
    }

    //TODO add remove student in refactoring and/or for iteration 2.
}