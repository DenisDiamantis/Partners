package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvaluationTest {

    Student evaluator = new Student("Cristiano","Ronaldo","p3180068","cr7forthewin","cr7@gmail.com",null,null);
    Student evaluatee = new Student("Antelino","Vierinha","p3190068","mordorpresident","ork@ork.ork",null,null);
    Evaluation evaluation = new Evaluation(evaluator,evaluatee,5);

    @Test
    public void getEvaluator(){
        Assert.assertEquals(evaluator,evaluation.getEvaluator());
    }

    @Test
    public void getEvaluatee(){
        Assert.assertEquals(evaluatee,evaluation.getEvaluatee());
    }

    @Test
    public void getGrade(){
        Assert.assertEquals(5,evaluation.getGrade());
    }

    @Test
    public void setGrade(){
        evaluation.setGrade(4);
        Assert.assertEquals(4,evaluation.getGrade());
    }
}