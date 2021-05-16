package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RequestTest {

    String AM = null;
    String message = null;
    int id;
    String thecourse = null;
    Team team = new Team();
    HashMap<String,String> all_messages = new HashMap<>();
    Request request = new Request();
    Request request1 = new Request(AM,message,id,thecourse);
    HashMap<String, Request> requests = new HashMap<>();

    @Before
    public void setUp(){
        this.AM="p3180068";
        this.message="Hi";
        this.id = 1119;
        this.thecourse = "Tech";
        request1 = new Request(this.AM,this.message,this.id,this.thecourse);
        request1.getHashMapKey(requests);
    }

    @Test
    public void setAM(){
        AM = "p3180068";
        this.AM=AM;
        Assert.assertEquals("p3180068",this.AM);
    }

    @Test
    public void getAM(){
        Assert.assertEquals("p3180068",request1.getAM());
    }

    @Test
    public void setMessage(){
        message = "Hi";
        this.message=message;
        Assert.assertEquals("Hi",this.message);
    }

    @Test
    public void getMessage(){
        Assert.assertEquals("Hi",request1.getMessage());
    }

    @Test
    public void setID(){
        id =3;
        this.id=id;
        Assert.assertEquals(3, this.id);
    }

    @Test
    public void getID(){
        Assert.assertEquals(1119,request1.getID());
    }

    @Test
    public void setTheCourse(){
        thecourse = "Tech";
        this.thecourse = thecourse;
        Assert.assertEquals("Tech",this.thecourse);
    }

    @Test
    public void getTheCourse(){
        Assert.assertEquals("Tech",request1.getTheCourse());
    }

    @Test
    public void getHashMapKey() {
        HashMap<String, Request> b = requests;
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, Request>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String)f.getKey());
        }

    }
}
