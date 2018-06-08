package com.example.armando.project;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class LoginUnitTest {
    @Test
    public void validateUserBadPass() {
        assertEquals(1, logIn.validate("user", "notapassword"));
        //Change to expect 0
    }

    @Test
    public void validateBadUserBadPass() {
        assertEquals(1, logIn.validate("notuser", "notapassword"));
        //Change to expect 0
    }

    @Test
    public void validateBadUserGoodPass() {
        assertEquals(1, logIn.validate("", "password"));
    }

    @Test
    public void validateUserGoodPass() {
        assertEquals(1, logIn.validate("user", "password"));
    }
}
