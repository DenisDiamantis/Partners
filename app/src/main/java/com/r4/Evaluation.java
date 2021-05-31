package com.r4;

public class Evaluation {

    Student evaluator;
    Student evaluatee;
    int grade;


    public Evaluation(Student evaluator, Student evaluatee,int grade){
        this.evaluatee = evaluatee;
        this.evaluator = evaluator;
        this.grade = grade;
    }

    public Student getEvaluator() {
        return evaluator;
    }

    public Student getEvaluatee() {
        return evaluatee;
    }

    public int getGrade(){
        return grade;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }
}
