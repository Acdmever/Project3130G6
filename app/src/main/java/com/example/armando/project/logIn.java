package com.example.armando.project;

public class logIn {

    public static int validate(String inputUser, String inputPass) {
        if (inputUser.equals("user") && inputPass.equals("pass"))
            return 1;
        else
            return 0;
    }
}
