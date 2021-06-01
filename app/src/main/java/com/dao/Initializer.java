package com.dao;

import com.r4.Account;
import com.r4.Student;

public abstract class Initializer {

    public void prepareData(){
        Student student = new Student("Cristian","Karempe","p3180266","karempepaiktara","karempe@gmail.com",null,null);
        Student platonas = new Student("Platonas", "Karageorgis","p3180068","thelwdiakopes","kp@gmail.com",null,null);
        Account account = new Account(student);
        Account account1 = new Account(platonas);
        getAccountDAO().saveAccount(account);
        getAccountDAO().saveAccount(account1);

    }
    public abstract AccountDAO getAccountDAO();
}
