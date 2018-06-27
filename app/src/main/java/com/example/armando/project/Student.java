package com.example.armando.project;


public class Student {

    public String firstName;
    public String lastName;
    //private String id;
    public String password;
    public String username;
    public Student(){}
    public Student(String firstName , String lastName, String password, String username){
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.username=username;
    }

    public void setFirstName(String fn) {

        this.firstName=fn;
    }
    public void setLastName(String ln) {

        this.lastName=ln;
    }
    public void setPassword(String pw) {
        this.password=pw;
    }
    public void setUsername(String un) {
        this.username=un;
    }
    /*public void setID(String id){
        this.ID=id;
    }*/
    public String getFirstName() {

        return this.firstName;
    }
    public String getLastName() {

        return this.lastName;
    }
    public String getPassword() {

        return this.password;
    }
    public String getUsername() {

        return this.username;
    }
    public static void transfer(Student s1, Student s2){
        s2.setLastName(s1.getLastName());
        s2.setFirstName(s1.getFirstName());
        s2.setUsername(s1.getUsername());
        s2.setPassword(s1.getPassword());

    }

}
