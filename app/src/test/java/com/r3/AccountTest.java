package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AccountTest {

    static HashMap<String, StudentDAO> accounts = new HashMap<>();
    AccountDAO acc;

    @Before
    public void setUp() throws Exception {
        AccountDAO accountDAO = new AccountDAO();
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
        AccountDAO acc = new AccountDAO("Kleiw", "Patatsh", "p3180266", "nikolpatatsi@gmail.com", "klei-w", skills, days);
        StudentDAO studentDAO = new StudentDAO("Kleiw", "Patatsh", "p3180266", "nikolpatatsi@gmail.com", "klei-w", skills, days);
        accounts.put(studentDAO.getAM(), studentDAO);
        acc.getHashMapKeyStudent(accounts);
    }

    @Test
    public void getHashMapKeyStudent(){
        HashMap<String, StudentDAO> b = accounts;
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, StudentDAO>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String) f.getKey());
        }
        if(accounts.keySet().equals(set)){
            Assert.assertEquals("p3180266",acc.getHashMapKeyStudent(accounts));
        }
    }
}
