package com.r4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Student {

    String name = null;
    String surname = null;
    String AM = null;
    String password = null;
    String email = null;
    String skills = null;
    String timeline;
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Request> requests = new ArrayList<>();
    ArrayList<Evaluation> evaluations = new ArrayList<>();


    public Student() {

    }

    public Student(String name, String surname, String AM, String password, String email, String skills, String timeline) {
        this.name = name;
        this.surname = surname;
        this.AM = AM;
        this.password = password;
        this.email = email;
        this.skills = skills;
        this.timeline = timeline;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAM() {
        return AM;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getSkills() {
        return skills;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public void addTeams(Team team) {
        teams.add(team);
    }

    public void Evaluate(int evaluation, Student evaluatee) {

        boolean flag = false;
        for(int j=0;j<teams.size();j++){
           if(teams.get(j).getMembers().contains(this) && teams.get(j).getMembers().contains(evaluatee)){
               flag = true;
           }
        }
        if(flag) {
            for(int k=0;k< evaluations.size();k++){
                if(evaluations.get(k).getEvaluatee().equals(evaluatee)){
                    return;
                }
            }
            Evaluation eval = new Evaluation(this, evaluatee, evaluation);
            evaluations.add(eval);
        }
    }

    public Request sendRequest(Team appl_team, String message) {
        Request req = new Request(this, appl_team, message);
        requests.add(req);
        return req;
    }

    public Team createTeam(Project project, String requirements) {
        ArrayList<Student> members = new ArrayList<>();
        members.add(this);
        Team team = new Team(project, this, members, requirements);
        teams.add(team);
        return team;
    }

    public void createAccount() {
        Account account = new Account(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void updateRequests() {
        Iterator<Request> iter = requests.iterator();
        while (iter.hasNext()) {
            Request temp = iter.next();
            if (!temp.getStatus()) {
                iter.remove();
            }
        }
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}
