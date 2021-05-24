package com.r3;

public class Request {

    String AM = null;
    int id;
    String message = null;
    String course = null;

    public Request(String AM, int id, String message, String course){
        this.AM= AM;
        this.id = id;
        this.message = message;
        this.course = course;
    }

    public String getAM() {
        return AM;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCourse() {
        return course;
    }
}
