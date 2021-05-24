package com.r3;

import java.util.ArrayList;

public class Team {

    Project project = null;
    int id;
    Student founder = new Student();
    String requirements = null;
    ArrayList<Student> members;

    public Team(Project project, int id, Student founder, ArrayList<Student> members, String requirements){
        this.project = project;
        this.requirements = requirements;
        this.members = members;
        this.founder = founder;
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public int getId() {
        return id;
    }

    public Student getFounder() {
        return founder;
    }

    public String getRequirements() {
        return requirements;
    }

    public ArrayList<Student> getMembers() {
        return members;
    }
}
