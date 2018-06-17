package com.example.armando.project;

public class Registration {
    public long course;
    public long student;
    public String key;

    public Registration() {
    }

    public Registration(long course, long student, String key) {
        this.course = course;
        this.student = student;
        this.key = key;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public long getStudent() {
        return student;
    }

    public void setStudent(long student) {
        this.student = student;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
