package com.dao;

import com.r4.Account;
import com.r4.Student;

public abstract class Initializer {

    public void prepareData(){
        Student student = new Student("Cristian","Karempe","p3180266","karempepaiktara","karempe@gmail.com",null,null);
        Account account = new Account(student);
        getAccountDAO().saveAccount(account);

    }
    public abstract AccountDAO getAccountDAO();
}
