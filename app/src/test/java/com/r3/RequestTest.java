package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class RequestTest {

    String AM = null;
    String message = null;
    int id;
    String thecourse = null;
    Team team = new Team();
    HashMap<String,String> all_messages = new HashMap<>();

    @Before
    public void setUp(){
        this.AM="p3180068";
        this.message="Hi";
        this.id = 1119;
        this.thecourse = "Tech";
    }

    @Test
    public void setAM(){
        AM = "p3180068";
        this.AM=AM;
        Assert.assertEquals("p3180068",this.AM);
    }

    @Test
    public void getAM(){
        Assert.assertEquals("p3180068",this.AM);
    }

    @Test
    public void setMessage(){
        message = "Hi";
        this.message=message;
        Assert.assertEquals("Hi",this.message);
    }

    @Test
    public void getMessage(){
        Assert.assertEquals("Hi",this.message);
    }

    @Test
    public void setID(){
        id =3;
        this.id=id;
        Assert.assertEquals(3, this.id);
    }

    @Test
    public void getID(){
        Assert.assertEquals(1119,this.id);
    }

    @Test
    public void setTheCourse(){
        thecourse = "Tech";
        this.thecourse = thecourse;
        Assert.assertEquals("Tech",this.thecourse);
    }

    @Test
    public void getTheCourse(){
        Assert.assertEquals("Tech",this.thecourse);
    }
}
