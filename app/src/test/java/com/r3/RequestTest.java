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
    TeamDAO teamDAO = new TeamDAO();
    HashMap<String,String> all_messages = new HashMap<>();
    RequestDAO requestDAO = new RequestDAO();
    RequestDAO requestDAO1 = new RequestDAO(AM,message,id,thecourse);
    HashMap<String, RequestDAO> requests = new HashMap<>();

    @Before
    public void setUp(){
        this.AM="p3180068";
        this.message="Hi";
        this.id = 1119;
        this.thecourse = "Tech";
        requestDAO1 = new RequestDAO(this.AM,this.message,this.id,this.thecourse);
        requestDAO1.getHashMapKey(requests);
    }

    @Test
    public void setAM(){
        AM = "p3180068";
        this.AM=AM;
        Assert.assertEquals("p3180068",this.AM);
    }

    @Test
    public void getAM(){
        Assert.assertEquals("p3180068", requestDAO1.getAM());
    }

    @Test
    public void setMessage(){
        message = "Hi";
        this.message=message;
        Assert.assertEquals("Hi",this.message);
    }

    @Test
    public void getMessage(){
        Assert.assertEquals("Hi", requestDAO1.getMessage());
    }

    @Test
    public void setID(){
        id =3;
        this.id=id;
        Assert.assertEquals(3, this.id);
    }

    @Test
    public void getID(){
        Assert.assertEquals(1119, requestDAO1.getID());
    }

    @Test
    public void setTheCourse(){
        thecourse = "Tech";
        this.thecourse = thecourse;
        Assert.assertEquals("Tech",this.thecourse);
    }

    @Test
    public void getTheCourse(){
        Assert.assertEquals("Tech", requestDAO1.getTheCourse());
    }

    @Test
    public void getHashMapKey() {
        HashMap<String, RequestDAO> b = requests;
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, RequestDAO>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String)f.getKey());
        }

    }
}
