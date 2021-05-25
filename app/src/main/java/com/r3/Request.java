package com.r3;

public class Request {

    Student sender;
    Team application_team;
    int id;
    String message = null;
    boolean status = true;
    public Request(Student student, Team team, String message){
        this.sender = student;
        this.application_team = team;
        this.message = message;
    }

    public Student getStudent() {
        return sender;
    }

    public Team getApplicationTeam() {
        return application_team;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
