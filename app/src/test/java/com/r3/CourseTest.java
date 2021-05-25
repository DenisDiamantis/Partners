package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourseTest{

    Course course = new Course("Techno");

    @Test
    public void getTitle(){
        Assert.assertEquals("Techno",course.getTitle());
    }

}