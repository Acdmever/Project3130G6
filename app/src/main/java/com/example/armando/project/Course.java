package com.example.armando.project;

public class Course {
    public String department;
    public String instructor;
    public String semester;
    public String name;
    public String year;
    public Long num;
    public Lecture lectures=new Lecture();
    public Lecture tutorials=new Lecture();

    public Course() { }

    public Course(String department, String instructor, String semester, String name, Long num, String year){
        this.department = department;
        this.instructor = instructor;
        this.semester = semester;
        this.name = name;
        this.num = num;
        this.year = year;
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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Lecture getLectures() {
        return lectures;
    }

    public void setLectures(Lecture lectures) {
        this.lectures = lectures;
    }
    public Lecture getTutorials() {
        return tutorials;
    }

    public void setTutorials(Lecture tutorials) {
        this.tutorials = tutorials;
    }
}

