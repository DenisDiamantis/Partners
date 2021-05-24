package com.r3;

public class Student {

    String name = null;
    String surname = null;
    String AM = null;
    String password = null;
    String email = null;
    String skills = null;
    String timeline = null;

    public Student(){

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
}
