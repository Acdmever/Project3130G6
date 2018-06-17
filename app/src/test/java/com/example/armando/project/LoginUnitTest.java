package com.example.armando.project;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class LoginUnitTest {
    @Test
    public void validateUserBadPass() {
        assertEquals(0, logIn.validate("user", "notapassword"));
    }

    @Test
    public void validateBadUserBadPass() {
        assertEquals(0, logIn.validate("notuser", "notapassword"));
    }

    @Test
    public void validateBadUserGoodPass() {
        assertEquals(0, logIn.validate("", "password"));
    }

    @Test
    public void validateUserGoodPass() {
        assertEquals(1, logIn.validate("user", "password"));
    }
}
