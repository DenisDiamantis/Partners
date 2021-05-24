package com.r3;

public class Project {

    int maxnumber;
    String deadline = null;

    public int getMaxnumber() {
        return maxnumber;
    }

    public String getDeadline() {
        return deadline;
    }

    public Project(int maxnumber, String deadline){
        this.deadline = deadline;
        this.maxnumber = maxnumber;
    }
}
