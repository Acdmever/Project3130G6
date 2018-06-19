package com.example.armando.project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ViewCourseDetailUnitTest {

    private static ViewCourseDetail vcd;
    private static Course mockCourse;
    @Before
    public void setup() {
        //Initializing course details object
        vcd = new ViewCourseDetail();
        mockCourse = new Course();
        mockCourse.setDepartment("Spanish");
        mockCourse.setNum((long)3100);
        mockCourse.setName("Testing Stuff");
        mockCourse.setSemester("Fall");
        mockCourse.setYear("2013-2014");
        mockCourse.setDescription("Learn how to test in Spanish");
    }

    @Test
    public void showCourseDetails () {
        String[] mockCourseDetails = mockCourse.getCourseDetail();
        assertTrue(vcd.showCourseDetail(mockCourseDetails));
    }

    @Test
    public void showCourseDetailError () {
        String[] mockCourseDetails = mockCourse.getCourseDetail();
        assertTrue(vcd.showCourseDetail(mockCourseDetails));
    }
}