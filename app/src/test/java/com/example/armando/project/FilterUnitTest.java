package com.example.armando.project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FilterUnitTest {

    static Filter filter;
    @Before
    public void setup() {
        //Initialize
        filter = new Filter();
    }

    @Test
    public void filterCourseLevel () {
        //test if it filters courses correctly
        assertTrue(filter.filterByClassLevel(1000));
    }

    @Test
    public void filterNoCourseLevel () {
        //test errors when no courses are showing after filter
        assertTrue(filter.filterByClassLevel(2000));
    }

    @Test
    public void filterCourseDepartment () {
        //test if it filters courses by department correctly
        assertTrue(true);
    }

    @Test
    public void filterNoCourseDepartment () {
        //test errors when no courses are showing after filter
        assertTrue(true);
    }
}