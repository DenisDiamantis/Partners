package com.dao;

import com.r4.Account;
import com.r4.Course;
import com.r4.Project;
import com.r4.Student;
import com.r4.Team;

import java.util.ArrayList;

public abstract class Initializer {

    public void prepareData(){
        Student student = new Student("Cristian","Karempe","p3180266","karempepaiktara","karempe@gmail.com",null,null);
        Student platonas = new Student("Platonas", "Karageorgis","p3180068","thelwdiakopes","kp@gmail.com",null,null);
        Project r4=new Project(new Course("Software Engineering"),3,"8/6/2020");
        ArrayList<Student> members=new ArrayList<>();
        members.add(student);
        members.add(platonas);
        Team test=new Team(r4,platonas,members,"mono olympiakoi");
        getTeamDAO().saveTeam(test);
        Account account = new Account(student);
        Account account1 = new Account(platonas);
        getAccountDAO().saveAccount(account);
        getAccountDAO().saveAccount(account1);

    }
    public abstract AccountDAO getAccountDAO();

    public abstract TeamDAO getTeamDAO();
}
