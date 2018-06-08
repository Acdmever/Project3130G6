package com.example.armando.project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ViewCourseDetailUnitTest {

    private static ViewCourseDetail vcd;
    @Before
    public void setup() {
        //Initializing course details object
        vcd = new ViewCourseDetail();
    }

    @Test
    public void showCourseDetails () {
        assertTrue(vcd.showCourseDetail(0));
    }

    @Test
    public void showCourseDetailError () {
        assertTrue(vcd.showCourseDetail(0));
    }
}