package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TeamTest {

    static HashMap<Integer, ArrayList<Student>> assembled = new HashMap<>();
    ArrayList<Student> students = new ArrayList<>();
    Team team = new Team();
    @Before
    public void setUp() throws Exception {
        Account account = new Account();
        HashMap<String, ArrayList<String>> days = new HashMap<>();
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> mondayhours = new ArrayList<>();
        ArrayList<String> tuesdayhours = new ArrayList<>();
        ArrayList<String> wednesdayhours = new ArrayList<>();
        ArrayList<String> thursdayhours = new ArrayList<>();
        ArrayList<String> fridayhours = new ArrayList<>();
        ArrayList<String> saturdayhours = new ArrayList<>();
        ArrayList<String> sundayhours = new ArrayList<>();

        skills.add("watchF1");
        skills.add("thrilos");
        skills.add("tsitsifast");

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
        Student student = new Student("Kleiw", "Patatsh", "p3180266", "nikolpatatsi@gmail.com", "klei-w", skills, days);
        students.add(student);
        int team_id = 1118;
        assembled.put(1118,students);
        team.getHashMapKey(assembled);
    }
    @Test
    public void getHashMapKey() {
        HashMap<Integer, ArrayList<Student>> b = assembled;
        ArrayList<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, ArrayList<Student>>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((Integer)f.getKey());
        }
        if(assembled.keySet().equals(set)){
            Assert.assertEquals(java.util.Optional.of(1118),list.get(0));
        }
    }
}
