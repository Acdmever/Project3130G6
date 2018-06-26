package com.example.armando.project;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class LectureTest {

    @Test
    public void compareTest(){
        Lecture one = new Lecture("13:05-13:55",null,"13:05-13:55",
                null,"13:05-13:55");
        Lecture two = new Lecture("13:35-14:25",null,null,null,
                "13:35-14:25");
        Lecture three = new Lecture("10:35-11:25","9:05-9:55",null,
                null, null);

        assertTrue(one.compare(two));
        assertTrue(two.compare(one));
        assertFalse(three.compare(one));
        assertFalse(one.compare(three));
    }
}
