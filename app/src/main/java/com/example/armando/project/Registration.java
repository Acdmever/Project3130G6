package com.example.armando.project;

public class Registration {
    private Integer course;
    private Integer student;

    public Registration() {
    }

    public Registration(Integer course, Integer student) {
        this.course = course;
        this.student = student;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) { this.student = student; }

    public boolean equals(Registration reg) {
        if(reg.getCourse() != course || reg.getStudent() != student) {
            return false;
        }
            return true;
    }
}
