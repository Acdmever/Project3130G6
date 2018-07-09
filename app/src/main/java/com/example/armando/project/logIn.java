package com.example.armando.project;
/**
 * allows the user to login
 * @author Joel Fong
 * @author Fahad ALFaleh
 */
public class logIn {
    /**
     * this is a method that validated the user name and password of a Student
     * @return 1 if the user name and password is correct 0 if the user or password is incorrect
     */
    public static int validate(String inputUser, String inputPass) {
        if (inputUser.equals("user") && inputPass.equals("pass"))
            return 1;
        else
            return 0;
    }
}
