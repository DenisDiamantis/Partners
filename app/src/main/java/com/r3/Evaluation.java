package com.r3;

public class Evaluation {

    String AM_evaluator = null;
    String AM_evaluatee = null;

    public Evaluation(String AM_evaluator, String AM_evaluatee){
        this.AM_evaluatee = AM_evaluatee;
        this.AM_evaluator = AM_evaluator;
    }

    public String getAM_evaluator() {
        return AM_evaluator;
    }

    public String getAM_evaluatee() {
        return AM_evaluatee;
    }
}
