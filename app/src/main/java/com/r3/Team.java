package com.r3;

import java.util.ArrayList;

public class Team {

    Project project;
    Student founder = new Student();
    String requirements = null;
    ArrayList<Student> members;
    ArrayList<Request> requests;
    public Team(Project project,Student founder, ArrayList<Student> members, String requirements){
        this.project = project;
        this.requirements = requirements;
        this.members = members;
        this.founder = founder;
    }

    public Project getProject() {
        return project;
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

    public void addRequests(Request request){
        requests.add(request);
    }
    public void acceptRequest(Request request,Student student){
        if(student.equals(founder)) {
            if (checkTeamSize()) {
                members.add(request.getStudent());
            }
        }

    }
    public void declineRequest(Request request, Student student){
        if(student.equals(founder)) {
            request.setStatus(false);
        }
    }
    public boolean checkTeamSize(){
        if(members.size()<project.getMaxNumber()) {
            return true;
        }
        for(int i = 0; i< requests.size();i++){
            requests.get(i).setStatus(false);
        }
        requests.removeAll(requests);
        return false;
    }
}
