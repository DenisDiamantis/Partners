package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentTest{
    Course course = new Course("Techno");
    ArrayList<Student> members = new ArrayList<>();
    Student sender = new Student("Zinedine","Zidane","p3180060","halamadrid","zinedine@gmail.com",null,null);
    Student founder = new Student("Cristian","Karempe","p3180266","karempepaiktara","karempe@gmail.com",null,null);
    Project project = new Project(course,3,"06/06/2021");
    Student evaluator = new Student("Cristiano","Ronaldo","p3180068","cr7forthewin","cr7@gmail.com",null,null);
    Student evaluatee = new Student("Antelino","Vierinha","p3190068","mordorpresident","ork@ork.ork",null,null);
    ArrayList<Evaluation> evaluations = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Request> requests = new ArrayList<>();
    Team team = new Team(project,founder,members,"No requirements");

    @Before
    public void setUp(){
        members.add(evaluator);
        members.add(evaluatee);
    }

    @Test
    public void Evaluate(){
        Evaluation evaluation = new Evaluation(evaluator,evaluatee,5);
        evaluator.addTeams(team);
        evaluator.Evaluate(5,evaluatee);
        Assert.assertEquals(evaluator,evaluation.getEvaluator());
    }
    @Test
    public void getTeams(){
        sender.addTeams(team);
        ArrayList<Team> temp = new ArrayList<>();
        temp.add(team);
        Assert.assertEquals(temp,sender.getTeams());

    }
    @Test
    public void getName(){
        Assert.assertEquals("Zinedine",sender.getName());
    }
    @Test
    public void getSurname(){
        Assert.assertEquals("Zidane",sender.getSurname());
    }
    @Test
    public void getAM(){
        Assert.assertEquals("p3180060",sender.getAM());
    }
    @Test
    public void getEmail(){
        Assert.assertEquals("zinedine@gmail.com",sender.getEmail());
    }
    @Test
    public void getPassword(){
        Assert.assertEquals("halamadrid",sender.getPassword());
    }
    @Test
    public void setName(){
        sender.setName("Zidanaros");
        Assert.assertEquals("Zidanaros",sender.getName());
    }
    @Test
    public void setSurname(){
        sender.setSurname("Zidanaros");
        Assert.assertEquals("Zidanaros",sender.getSurname());
    }
    @Test
    public void createAccount(){
        Account account = new Account(sender.getAM(), sender.getPassword(), sender.getAM());
        sender.createAccount();
        Assert.assertEquals("p3180060", sender.getAM());
    }
    @Test
    public void updateRequests(){
        Request request = new Request(sender,team,"Hi");
        sender.updateRequests();
        Assert.assertEquals(0,sender.requests.size());
    }
    @Test
    public void createTeam(){
        boolean flag = false;
        Course course2 = new Course("Katanemhmena");
        Project project2 = new Project(course2,3,"06/06/2021");
        Team cr_team = evaluatee.createTeam(project2,"No requirements");
        ArrayList<Team> temp = evaluatee.getTeams();
        for(int i=0;i<evaluatee.teams.size();i++) {
            if(temp.get(i).equals(cr_team)){
                flag = true;
            }
        }
        Assert.assertEquals(true,flag);
    }
    @Test
    public void sendRequest(){
        boolean flag = false;
        Request req = sender.sendRequest(team,"Hi");
        ArrayList<Request> temp = sender.requests;
        for(int i = 0; i< sender.requests.size();i++) {
            if(temp.get(i).equals(req)){
                flag = true;
            }
        }
        Assert.assertEquals(true,flag);
    }
    @Test
    public void getSkills(){
        ArrayList<String> skills = new ArrayList<>();
        HashMap<String, ArrayList<String>> timeline = new HashMap<>();
        Student onemore = new Student("Yann","Mvila","p3180267","paiktaraemvila","mvila@gmail.com",skills,timeline);
        skills.add("Paiktaras");
        Assert.assertEquals("Paiktaras", onemore.getSkills().get(0));
    }
    @Test
    public void getTimeline(){
        ArrayList<String> skills = new ArrayList<>();
        HashMap<String, ArrayList<String>> timeline = new HashMap<>();
        Student onemore = new Student("Yann","Mvila","p3180267","paiktaraemvila","mvila@gmail.com",skills,timeline);
        ArrayList<String> mondayhours = new ArrayList<>();
        ArrayList<String> tuesdayhours = new ArrayList<>();
        ArrayList<String> wednesdayhours = new ArrayList<>();
        ArrayList<String> thursdayhours = new ArrayList<>();
        ArrayList<String> fridayhours = new ArrayList<>();
        ArrayList<String> saturdayhours = new ArrayList<>();
        ArrayList<String> sundayhours = new ArrayList<>();
        timeline.put("Monday", mondayhours);
        timeline.put("Tuesday", tuesdayhours);
        timeline.put("Wednesday", wednesdayhours);
        timeline.put("Thursday", thursdayhours);
        timeline.put("Friday", fridayhours);
        timeline.put("Saturday", saturdayhours);
        timeline.put("Sunday", sundayhours);
        mondayhours.add("18:00");
        ArrayList<String> temp = onemore.getTimeline().get("Monday");
        Assert.assertEquals("18:00",temp.get(0));
    }
    @Test
    public void setSkills(){
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Everything");
        HashMap<String, ArrayList<String>> timeline = new HashMap<>();
        Student onemore = new Student("Yann","Mvila","p3180267","paiktaraemvila","mvila@gmail.com",skills,timeline);
        onemore.setSkills(temp);
        Assert.assertEquals("Everything",onemore.getSkills().get(0));
    }
    @Test
    public void setTimeline(){
        ArrayList<String> skills = new ArrayList<>();
        HashMap<String, ArrayList<String>> timeline = new HashMap<>();
        HashMap<String, ArrayList<String>> anotherone = new HashMap<>();
        Student onemore = new Student("Yann","Mvila","p3180267","paiktaraemvila","mvila@gmail.com",skills,timeline);
        ArrayList<String> mondayhours = new ArrayList<>();
        ArrayList<String> tuesdayhours = new ArrayList<>();
        ArrayList<String> wednesdayhours = new ArrayList<>();
        ArrayList<String> thursdayhours = new ArrayList<>();
        ArrayList<String> fridayhours = new ArrayList<>();
        ArrayList<String> saturdayhours = new ArrayList<>();
        ArrayList<String> sundayhours = new ArrayList<>();
        anotherone.put("Monday", mondayhours);
        anotherone.put("Tuesday", tuesdayhours);
        anotherone.put("Wednesday", wednesdayhours);
        anotherone.put("Thursday", thursdayhours);
        anotherone.put("Friday", fridayhours);
        anotherone.put("Saturday", saturdayhours);
        anotherone.put("Sunday", sundayhours);
        mondayhours.add("18:00");
        onemore.setTimeline(anotherone);
        Assert.assertEquals("18:00",anotherone.get("Monday").get(0));
    }
    @Test
    public void setPassword(){
        sender.setPassword("changed");
        Assert.assertEquals("changed",sender.getPassword());
    }

}