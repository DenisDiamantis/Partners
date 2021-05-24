package com.r3;

public class Account {

    String AM = null;
    String password = null;
    String email = null;

    public Account(String AM,String password, String email){
        this.AM = AM;
        this.password = password;
        this.email = email;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
