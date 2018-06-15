package com.example.armando.project;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourseUnitTests {

    @Test
    public void headerAndFooterTest(){
        Course course = new Course();
        course.setDepartment("Spanish");
        course.setNum(3100);
        course.setName("Testing Stuff");
        course.setSemester("Fall");
        course.setYear("2013-2014");

        String header = course.makeHeaderString();
        String footer = course.makeFooterString();

        assertEquals("Spanish 3100: Testing Stuff", header);
        assertEquals("Fall 2013-2014", footer);


    }

}
