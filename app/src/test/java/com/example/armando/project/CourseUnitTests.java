package com.example.armando.project;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
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
        mockCourseDetails.put("limit", mockCourse.getLimit()+"");

        assertEquals(mockCourseDetails.get("description"), mockCourse.getCourseDetail().get("description"));
    }

    @Test
    public void checkForTimeConflictTest(){
        Lecture one = new Lecture(null,null,"13:05-13:55",
                null,null);
        Lecture two = new Lecture("13:35-14:25",null,null,null,
                "13:35-14:25");
        Lecture three = new Lecture("10:35-11:25","9:05-9:55",null,
                null, null);
        Lecture four = new Lecture(null,null,"8:35-9:55",null,"8:35-9:55");
        Lecture five = new Lecture(null,"9:35-10:55",null,null,"9:35-10:55");

        Course course1 = new Course();
        course1.setLectures(three);
        course1.setTutorials(two);
        course1.setSemester("winter");
        course1.setYear("2018-2019");

        Course course2 = new Course();
        course2.setLectures(four);
        course2.setTutorials(one);
        course2.setSemester("fall");
        course2.setYear("2018-2019");

        Course course3 = new Course();
        course3.setTutorials(two);
        course3.setSemester("winter");
        course3.setYear("2018-2019");

        Course course4 = new Course();
        course4.setTutorials(five);
        course4.setSemester("winter");
        course4.setYear("2018-2019");

        assertFalse(course1.checkForTimeConflict(course2));
        assertTrue(course4.checkForTimeConflict(course1));
        assertTrue(course4.checkForTimeConflict(course3));

    }

}
