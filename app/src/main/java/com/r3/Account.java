package com.r3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Account {

    static HashMap<String, Student> accounts = new HashMap<>();
    static HashMap<String, ArrayList<String>> skillsmap = new HashMap<>();
    static HashMap<String, HashMap<String, ArrayList<String>>> timelinemap = new HashMap<>();

    public Account(String name, String surname, String AM, String email, String password,ArrayList<String> skills, HashMap<String, ArrayList<String>> timeline){
        skillsmap.put(AM, skills);
        timelinemap.put(AM, timeline);
        Student student = new Student(name, surname, AM, email, password, skills, timeline);
        accounts.put(AM,student);
    }
    public Account(){

    }

    public ArrayList<String> getHashMapKey(HashMap<String, String> b) {
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, String>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String) f.getKey());
        }
        return list;
    }

    public ArrayList<String> getHashMapKeyStudent(HashMap<String, Student> b) {
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, Student>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String) f.getKey());
        }
        return list;
    }


}
