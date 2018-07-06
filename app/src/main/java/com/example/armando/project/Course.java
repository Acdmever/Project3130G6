package com.example.armando.project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a course and its related information.
 *
 * @author Matt
 * @author Dahn
 * @author Nic
 */
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

    /**
     * Get the database key for this course
     *
     * @return database key
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the database key for this course
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Empty constructor required by firebase
     */
    public Course() { }

    /**
     * Create a course defining all fields
     *
     * @param department
     * @param instructor
     * @param semester
     * @param name
     * @param key
     * @param num
     * @param year
     * @param description
     * @param lectures
     * @param tutorials
     * @param limit
     */
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

    /**
     * Get the tutorials for this course
     * @return tutorials
     */
    public Lecture getTutorials() {
        return tutorials;
    }

    /**
     * Set the tutorials for this course
     * @param tutorials
     */
    public void setTutorials(Lecture tutorials) {
        this.tutorials = tutorials;
    }

    /**
     * Get the lectures for this course
     * @return lectures
     */
    public Lecture getLectures() {
        return lectures;
    }

    /**
     * Set the lectures for this course
     * @param lectures
     */
    public void setLectures(Lecture lectures) {
        this.lectures = lectures;
    }

    /**
     * Get the instructor for this course
     * @return instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Set the instructor
     * @param instructor
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * Get the semester this course takes place in
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Set the semester that the course takes place in
     * @param semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the course name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the course name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the year that the course takes place in
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * Set the year that the course takes place in
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Get the course description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the course description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the course number
     * @return course_number
     */
    public Long getNum() {
        return num;
    }

    /**
     * Get the maximum amount of students that can enroll in this course
     * @return student_limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Set the maximum amount of students that can enroll in this course
     * @return student_limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Set the course number
     * @param num
     */
    public void setNum(Long num) {
        this.num = num;
    }

    /**
     * Get the course's department
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Set the course's department
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Get the list of students that are in the course
     * @return students
     */
    public ArrayList<String> getStudents() {
        return students;
    }

    /**
     * Set the list of students that are in the course
     * @param students
     */
    public void setStudents(ArrayList<String> students) {
        this.students = students;
    }

    /**
     * Get a string that describes the course by ddepartment, number, and name
     * @return headerString
     */
    public String makeHeaderString(){
       return getDepartment()+" "+getNum()+": "+getName();
    }

    /**
     * Get a string that describes the course by semester and year
     * @return footerString
     */
    public String makeFooterString(){
        return getSemester()+" "+getYear();
    }

    /**
     * Get all the course details in a HashMap
     * @return courseDetails
     */
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

    /**
     * Add a student's key to list of students that are in the course
     * @param studentKey
     */
    private void addStudentToList(String studentKey){
        students.add(studentKey);
    }

    private void removeStudentFromList(String studentKey){
        students.remove(studentKey);
    }

    /**
     * Register a student for the course
     *
     * This method ensures the course's user list is updated and a registration
     * object created to match.
     *
     * @return reg
     */
    public Registration addStudent(String studentKey){
        addStudentToList(studentKey);
        Registration reg =  new Registration(Integer.parseInt(key), Integer.parseInt(studentKey));
        return reg;
    }

    public ArrayList<String> removeStudent(String studentKey){
        removeStudentFromList(studentKey);
        return students;
    }

    //true = conflict
    public boolean checkForTimeConflict(Course newCourse){
        boolean result = false;
        Lecture newLectures = newCourse.getLectures();
        Lecture newTutorials = newCourse.getTutorials();

        if(newLectures != null){
            if((this.lectures != null) && this.lectures.compare(newLectures)){
                return true;
            }

            if((this.tutorials != null) && this.tutorials.compare(newLectures)){
                return true;
            }
        }

        if(newTutorials != null){
            if((this.lectures != null) && this.lectures.compare(newTutorials)){
                return true;
            }

            if((this.tutorials != null) && this.tutorials.compare(newTutorials)){
                return true;
            }
        }
        return result;
    }
}