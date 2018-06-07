package com.example.armando.project;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Before
    public void makeStudent() {
        //Student student = new Student();
    }
    @Test public void writeToDB() {
        Student student = new Student();
        String test = student.writeMessage();
    }

    @Test
    public void studentThings() {
        Student student = new Student();
        String pass = new String();
        pass = student.setFirstName("test complete");
        assertNotNull(pass);
    }
}