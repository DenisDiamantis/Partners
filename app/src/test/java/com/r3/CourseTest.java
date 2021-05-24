package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CourseTest {

    int size;
    String name;
    static HashMap<String,Integer> courses = new HashMap<>();
    CourseDAO courseDAO = new CourseDAO();
    CourseDAO courseDAO1 = new CourseDAO(name,size);
    @Before
    public void setUp(){
        int teammaxsize = 3;
        name = "Tech";
        this.size = teammaxsize;
        this.name = name;
        courses.put(name,teammaxsize);
        courseDAO1 = new CourseDAO(name,teammaxsize);
        courseDAO.getTeamSize();
        courseDAO.getCourseName();
        courseDAO1.getHashMapKey(courses);
    }

    @Test
    public void setTeamSize(){
        int teammaxsize=3;
        this.size=teammaxsize;
        Assert.assertEquals(3, this.size);
    }
    @Test
    public void getTeamSize(){
        Assert.assertEquals(3, courseDAO1.getTeamSize());
    }
    @Test
    public void setCourseName(){
        String name = "Tech";
        this.name=name;
        Assert.assertEquals("Tech", this.name);
    }
    @Test
    public void getName(){
        Assert.assertEquals("Tech", courseDAO1.getCourseName());
    }

    @Test
    public void getHashMapKey() {
        HashMap<String, Integer> b = courses;
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, Integer>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String)f.getKey());
        }
        if(courses.keySet().equals(set)){
            Assert.assertEquals(java.util.Optional.of(1118),list.get(0));
        }
    }
}
