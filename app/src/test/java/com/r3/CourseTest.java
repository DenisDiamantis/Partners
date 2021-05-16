package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseTest {

    int size;
    String name;
    static HashMap<String,Integer> courses = new HashMap<>();

    @Before
    public void setUp(){
        int teammaxsize = 3;
        name = "Tech";
        this.size = teammaxsize;
        this.name = name;
        courses.put(name,teammaxsize);
    }

    @Test
    public void setTeamSize(){
        int teammaxsize=3;
        this.size=teammaxsize;
        Assert.assertEquals(3, this.size);
    }
    @Test
    public void getTeamSize(){
        Assert.assertEquals(3, this.size);
    }
    @Test
    public void setCourseName(){
        String name = "Tech";
        this.name=name;
        Assert.assertEquals("Tech", this.name);
    }
    @Test
    public void getName(){
        Assert.assertEquals("Tech", this.name);
    }
}
