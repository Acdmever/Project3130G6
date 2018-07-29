package com.example.armando.project;

import java.io.Serializable;

/**
 * keeping track of a student's Fisrt name, last name, username and password.
 * @author Luis Armando Cordero
 */
public class Student implements Serializable{

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    /**
     * Empty constructor for student
     */
    public Student() { }
    /**
     * This constructors a student with a first name, last name, username,
     * and a password
     * @param firstName is the first name of a student
     * @param lastName is the last name of a student
     * @param username is the user name of a student
     * @param password is the password of a student
     */
    public Student(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    /**
     * this returns the first name of a student
     * @return this student first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * this sets the users first name
     * @param firstName this is the first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * this returns the last name of a student
     * @return this student last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * this sets the users last name
     * @param lastName this is the last name of the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * this returns the student name of a student
     * @return this student user name
     */
    public String getUsername() {
        return username;
    }
    /**
     * this sets the student user name
     * @param username this is the username of a student
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * this returns the student password
     * @return this student password
     */
    public String getPassword() {
        return password;
    }
    /**
     * this sets the password of a student
     * @param password this is the password of a student
     */
    public void setPassword(String password) {
        this.password = password;
    }
}