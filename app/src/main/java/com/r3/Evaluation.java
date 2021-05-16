package com.r3;

import java.util.HashMap;

public class Evaluation {

    String AM;
    String AM_2;
    static HashMap<String, Double> evaluations = new HashMap<>();
    static HashMap<String, HashMap<String,Boolean>> eval_done = new HashMap<>();
    static HashMap<String, Boolean> done = new HashMap<>();


    public Evaluation(String AM, String AM_2){
        setEvaluatee(AM_2);
        setEvaluator(AM);
        done.put(AM_2, true);
        eval_done.put(AM, done);
    }
    public Evaluation(){

    }
    public String getEvaluator(){
        return AM;
    }
    public void setEvaluator(String AM){
        this.AM=AM;
    }

    public String getEvaluatee(){
        return AM_2;
    }
    public void setEvaluatee(String AM_2){
        this.AM_2=AM_2;
    }
}
