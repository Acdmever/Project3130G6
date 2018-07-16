package com.example.armando.project;
/**
 * This creates a registration with a student and a course in it
 * @author Matthew MacMullin
 * @author Jessica Irving
 */
public class Registration {
    private Integer course;
    private Integer student;
    private String grade; //grade received, IP if in progress, RG if registered and not yet started.

    /**
     * Empty constructor for student
     */
    public Registration() {
    }
    /**
     * This constructors a registration with a course and student parameter
     * @param course is the number of a course registered in
     * @param student
     */
    public Registration(Integer course, Integer student) {
        this.course = course;
        this.student = student;
        this.grade = "IP";
    }
    /**
     * gets the course number
     * @return returns the course number
     */
    public Integer getCourse() {
        return course;
    }
    /**
     * set the course number
     */
    public void setCourse(Integer course) {
        this.course = course;
    }
    /**
     * this returns the student number
     * @return returns the student number
     */
    public Integer getStudent() {
        return student;
    }

    /**
     * set this student student number
     */
    public void setStudent(Integer student) { this.student = student; }

    /**
     * get the grade received
     */
    public String getGrade() { return grade; }

    /**
     * set the grade received
     */
    public void setGrade(String grade) { this.grade = grade; }

    /**
     * this method check if to registration objects are equal
     * @param reg is a registration
     * @return true if the registration is equal to another registration false otherwise
     */
    public boolean equals(Registration reg) {
        if(reg.getCourse() != course || reg.getStudent() != student) {
            return false;
        }
            return true;
    }
}
