package com.r3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AccountDAO {

    static HashMap<String, StudentDAO> accounts = new HashMap<>();
    static HashMap<String, ArrayList<String>> skillsmap = new HashMap<>();
    static HashMap<String, HashMap<String, ArrayList<String>>> timelinemap = new HashMap<>();

    public AccountDAO(String name, String surname, String AM, String email, String password, ArrayList<String> skills, HashMap<String, ArrayList<String>> timeline){
        skillsmap.put(AM, skills);
        timelinemap.put(AM, timeline);
        StudentDAO studentDAO = new StudentDAO(name, surname, AM, email, password, skills, timeline);
        accounts.put(AM, studentDAO);
    }
    public AccountDAO(){

    }


    public ArrayList<String> getHashMapKeyStudent(HashMap<String, StudentDAO> b) {
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, StudentDAO>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String) f.getKey());
        }
        return list;
    }


}
