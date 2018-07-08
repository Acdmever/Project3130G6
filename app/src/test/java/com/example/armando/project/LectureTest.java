package com.example.armando.project;

import org.junit.Test;

import java.time.LocalTime;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LectureTest {

    @Test
    public void compareTest(){
        Lecture one = new Lecture("13:05-13:55",null,"13:05-13:55",
                null,"13:05-13:55");
        Lecture two = new Lecture("13:35-14:25",null,null,null,
                "13:35-14:25");
        Lecture three = new Lecture("10:35-11:25","9:05-9:55",null,
                null, null);
        Lecture four = new Lecture("12:35-14:25",null,null,
                null,null);

        assertTrue(one.compare(two));
        assertTrue(two.compare(one));
        assertTrue(one.compare(four));
        assertTrue(four.compare(one));
        assertFalse(three.compare(one));
        assertFalse(one.compare(three));
    }

    @Test
    public void timesTest(){
        Lecture one = new Lecture("13:05-13:55",null,"13:05-13:55",
                null,"13:05-13:55");
        String[] monday = {"13:05", "13:55"};
        String[] tuesday = null;
        String[] wednesday = {"13:05", "13:55"};
        String[] thursday = null;
        String[] friday = {"13:05", "13:55"};

        String[][] auto = one.getStartStopTimes();

        assertArrayEquals(monday, auto[0]);
        assertArrayEquals(tuesday, auto[1]);
        assertArrayEquals(wednesday, auto[2]);
        assertArrayEquals(thursday, auto[3]);
        assertArrayEquals(friday, auto[4]);
    }
}
