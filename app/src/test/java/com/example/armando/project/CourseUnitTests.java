package com.example.armando.project;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class CourseUnitTests {

    @Test
    public void headerAndFooterTest(){
        Course course = new Course();
        course.setDepartment("Spanish");
        course.setNum((long)3100);
        course.setName("Testing Stuff");
        course.setSemester("Fall");
        course.setYear("2013-2014");

        String header = course.makeHeaderString();
        String footer = course.makeFooterString();

        assertEquals("Spanish 3100: Testing Stuff", header);
        assertEquals("Fall 2013-2014", footer);
    }

    @Test
    public void studentListTest(){
        Course course = new Course();
        course.setKey("0");
        course.setStudents(new ArrayList<String>());

        Registration reg = course.addStudent("0");
        assertTrue(reg.equals(new Registration(0,0)));
    }

    @Test
    public void courseDetailsTest() {
        Course mockCourse = new Course();
        mockCourse.setDepartment("Spanish");
        mockCourse.setInstructor("Fernando R");
        mockCourse.setNum((long)3100);
        mockCourse.setName("Testing Stuff");
        mockCourse.setSemester("Fall");
        mockCourse.setYear("2013-2014");
        mockCourse.setDescription("Learn how to test in Spanish");

        HashMap<String, String> mockCourseDetails = new HashMap<>();
        mockCourseDetails.put("department", mockCourse.getDepartment());
        mockCourseDetails.put("instructor", mockCourse.getInstructor());
        mockCourseDetails.put("name", mockCourse.getName());
        mockCourseDetails.put("num", mockCourse.getNum()+"");
        mockCourseDetails.put("semester", mockCourse.getSemester());
        mockCourseDetails.put("year", mockCourse.getYear());
        mockCourseDetails.put("description", mockCourse.getDescription());
        mockCourseDetails.put("enrolment", mockCourse.getEnrolment()+"");
        mockCourseDetails.put("limit", mockCourse.getLimit()+"");

        assertEquals(mockCourseDetails.get("description"), mockCourse.getCourseDetail().get("description"));
    }

}
