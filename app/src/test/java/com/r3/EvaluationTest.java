package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class EvaluationTest {

    String AM;
    String AM_2;
    static HashMap<String, Double> evaluations = new HashMap<>();
    static HashMap<String, HashMap<String,Boolean>> eval_done = new HashMap<>();
    static HashMap<String, Boolean> done = new HashMap<>();

    @Before
    public void setUp(){

        this.AM = "p3180068";
        this.AM_2 = "p3180266";
        done.put(AM_2, true);
        eval_done.put(AM, done);
    }

    @Test
    public void getEvaluator(){
        Assert.assertEquals("p3180068", this.AM);
    }

    @Test
    public void setEvaluator(){
        AM = "p3180068";
        this.AM=AM;
        Assert.assertEquals("p3180068", this.AM);

    }

    @Test
    public void getEvaluatee(){
        Assert.assertEquals("p3180266", this.AM_2);
    }

    @Test
    public void setEvaluatee() {
        AM_2 = "p3180266";
        this.AM_2 = AM_2;
        Assert.assertEquals("p3180266", this.AM_2);
    }
}
