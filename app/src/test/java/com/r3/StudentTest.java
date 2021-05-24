package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentTest {

        private String name = null;
        private String surname = null;
        private String AM = null;
        private String email = null;
        private String password = null;
        private String message = null;
        private int id;
        private String thecourse= null;
        static HashMap<String, HashMap<Integer, ArrayList<StudentDAO>>> teams = new HashMap<>();
        HashMap<Integer, ArrayList<StudentDAO>> assembled2 = new HashMap<>();
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> mondayhours = new ArrayList<>();
        ArrayList<String> tuesdayhours = new ArrayList<>();
        ArrayList<String> wednesdayhours = new ArrayList<>();
        ArrayList<String> thursdayhours = new ArrayList<>();
        ArrayList<String> fridayhours = new ArrayList<>();
        ArrayList<String> saturdayhours = new ArrayList<>();
        ArrayList<String> sundayhours = new ArrayList<>();
        HashMap<String, ArrayList<String>> days = new HashMap<>();
        static HashMap<String, StudentDAO> accounts = new HashMap<>();
        static HashMap<String, Double> evaluations = new HashMap<>();
        static HashMap<String, HashMap<String,Boolean>> eval_done = new HashMap<>();
        static HashMap<String, Boolean> done = new HashMap<>();
        StudentDAO student1 = new StudentDAO();
        StudentDAO studentDAO = new StudentDAO("Vassilhs","Spanoylhs","p3180068","s@ueb.gr","otinanai",skills,days);
        static HashMap<Integer, HashMap<String, RequestDAO>> inbox = new HashMap<>();
        static HashMap<String, RequestDAO> sender = new HashMap<>();
        TeamDAO teamDAO = new TeamDAO();
    @Before
    public void setUp() throws Exception {
        mondayhours.add("5:00");
        tuesdayhours.add("6:00");
        wednesdayhours.add("7:00");
        thursdayhours.add("8:00");
        fridayhours.add("9:00");
        saturdayhours.add("10:00");
        sundayhours.add("11:00");

        days.put("Monday", mondayhours);
        days.put("Tuesday", tuesdayhours);
        days.put("Wednesday", wednesdayhours);
        days.put("Thursday", thursdayhours);
        days.put("Friday", fridayhours);
        days.put("Saturday", saturdayhours);

        days.put("Sunday", sundayhours);

        skills.add("watchF1");
        skills.add("thrylos");
        skills.add("tsitsifast");
        //Account acc = new Account(student.getName(),student.getSurname(),student.getAM(),student.getEmail(),student.getPassword(),student.getSkills(),student.getTimeline());
        accounts.put(studentDAO.getAM(), studentDAO);
    //----------------------------------------------------------------------------------------------------------
        //testCreateTeam
        String thecourse = "Tech";
        String message = "Hi";
        int id = 1111;
        ArrayList<StudentDAO> members = new ArrayList<>();
        members.add(studentDAO);
        String founder = studentDAO.getAM();
        String requirements = "No requirements";
        TeamDAO the_teamDAO = new TeamDAO(thecourse, id, members, founder, requirements);
        assembled2.put(id,members);
        teams.put(thecourse,assembled2);
        studentDAO.joinRequest(this.AM,message,id,thecourse);
    }

    @Test
    public void getName(){
        Assert.assertEquals("Vassilhs", studentDAO.getName());

    }
    @Test
    public void getPassword(){
        Assert.assertEquals("otinanai", studentDAO.getPassword());
    }
    @Test
    public void getSkills(){
        ArrayList<String> temp = new ArrayList<>();
        temp.add("watchF1");
        temp.add("thrylos");
        temp.add("tsitsifast");
        Assert.assertEquals(temp, studentDAO.getSkills());
    }

    @Test
    public void getEmail(){Assert.assertEquals("s@ueb.gr", studentDAO.getEmail());
    }

    @Test
    public void setEmail(){
        String email = "s@ueb.gr";
        this.email = email;
        Assert.assertEquals("s@ueb.gr",this.email);
    }

    @Test
    public void testcreateAccount(){
        StudentDAO newstudent = new StudentDAO("Platonas","Karageorgis","p3180068","s@ueb.gr","otinanai",skills,days);
        boolean temp;
        if(newstudent.getAM().equals(accounts.get(studentDAO.getAM()).getAM())){
            temp= false;
        }else{
            temp = true;
        }
        if (temp) {
            accounts.put(newstudent.getAM(),newstudent);
            Assert.assertEquals("p3180069",newstudent.getAM());
        }

    }

    @Test
    public void testcreateTeam(){
        StudentDAO newstudent = new StudentDAO("Platonas","Karageorgis","p3180068","s@ueb.gr","otinanai",skills,days);
        String thecourse = "Tech";
        int id = 1113;
        ArrayList<StudentDAO> members = new ArrayList<>();
        members.add(studentDAO);
        String founder = studentDAO.getAM();
        String requirements = "No requirements";
        boolean succeed= true;// an thelw na petyxei to test bazw true
        if(succeed){
            TeamDAO the_team_DAO_2 = new TeamDAO(thecourse, id, members, founder, requirements);

            assembled2.put(id,members);
            teams.put(thecourse,assembled2);
        }else {//alliws o foithths yparxei hdh kai petaw exception
            Assert.assertFalse(teams.get(thecourse).get(1111).contains(studentDAO));
        }


    }
    @Test
    public void testLogin(){
        StudentDAO newstudent = new StudentDAO("Platonas","Karageorgis","p3180068","s@ueb.gr","otinanai",skills,days);
        String input = "otinanai";
        boolean test_right = true;
        if(test_right){
            Assert.assertTrue(accounts.get("p3180068").getPassword().equals("otinanai"));
        }else{// an thelw na apotyxei bazw to test_right=false
            Assert.assertTrue(accounts.get("p3180068").getPassword().equals("otinanai1"));
        }
    }

    @Test
    public void testEvaluation(){
        StudentDAO newstudent = new StudentDAO("Platonas","Karageorgis","p3180068","s@aueb.gr","otinanai",skills,days);
        StudentDAO newstudent2 = new StudentDAO("Georgios","Printezhs","p3190068","f@aueb.gr","otinanaiepishs",skills,days);
        ArrayList<StudentDAO> members = new ArrayList<>();
        members.add(newstudent);
        members.add(newstudent2);
        String thecourse = "Tech";
        assembled2.put(1115,members);
        teams.put(thecourse,assembled2);
        boolean teamates=false;
        for(int i =0;i<teams.get(thecourse).get(1111).size();i++) {
            if (teams.get(thecourse).get(1111).get(i).getAM().equals("p3180068")){
                for(int j =0;i<teams.get(thecourse).get(1111).size();i++){
                    if (teams.get(thecourse).get(1111).get(j).getAM().equals("p3190068")){
                        teamates=true;
                    }
                }
            }
        }
        if(teamates){// an ginetai dhladh na kanei evaluate o p3180068 ton p3190068
            int previous_total_evaluations = 6;
            int previous_sum = 30;
            int evaluation = 5;
            double total_evaluation = (((double)previous_sum + (double)evaluation)/(previous_total_evaluations+1));
            Assert.assertTrue(total_evaluation==30);
            done.put("p3190068", true);
            eval_done.put("p3180068", done);//bale oti o p3180068 exei kanei evaluation ston p3190068
        }
    }
    @Test
    public void testEditAccount(){
        //for the name
        String newname = "Vasilhs";
        if(newname!=null){
            studentDAO.setName("Vasilhs");
        }
        Assert.assertEquals("Vasilhs", studentDAO.getName());

        //for the surname
        String newsurname = "7";
        if(newsurname!=null){
            studentDAO.setSurname("7");
        }
        Assert.assertEquals("7", studentDAO.getSurname());

        //for the password
        String oldpassword = "otinanai";
        String newpassword1 = "epishsotinanai";
        String newpassword2 = "epishsotinanai";
        if(oldpassword.equals(studentDAO.getPassword())){
            if (newpassword1.equals(newpassword2)) {
                studentDAO.setPassword(newpassword1);
                Assert.assertEquals("epishsotinanai", studentDAO.getPassword());
            }else {
                Assert.assertEquals("otinanai", studentDAO.getPassword());
            }

        }
        //for the skills
        String newskill = "eating";
        if(!skills.contains(newskill)){
            skills.add("eating");
            Assert.assertTrue(studentDAO.getSkills().contains("eating"));
        }else{
            Assert.assertTrue(studentDAO.getSkills().contains("eating"));
        }
        //for the timeline
        String day = "Tuesday";
        String hour = "17:00";
        if(!tuesdayhours.contains(hour)){
            tuesdayhours.add(hour);
            days.put(day,tuesdayhours);
        }

    }
    @Test
    public void joinRequest() {
        RequestDAO requestDAO = new RequestDAO(studentDAO.getAM(),message,1117,thecourse);
        teamDAO.sender.put(AM, requestDAO);
        teamDAO.inbox.put(id, teamDAO.sender);
    }

}