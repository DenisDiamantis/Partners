package com.r3;

public class Request {

    Student sender;
    Team application_team;
    int id;
    String message = null;
    static boolean status = true;

    public Request(Student sender, Team team, String message){
        this.sender = sender;
        this.application_team = team;
        this.message = message;
    }

    public Student getSender() {
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
