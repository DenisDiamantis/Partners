package com.r3;


import java.util.*;

public class Team {

    static HashMap<String, HashMap<Integer, ArrayList<Student>>> teams = new HashMap<>();
    static HashMap<String, Integer> team_founders = new HashMap<>();
    static HashMap<Integer, ArrayList<Student>> assembled = new HashMap<>();
    static HashMap<Integer,String> the_requirements = new HashMap<>();
    static HashMap<Integer, HashMap<String, Request>> inbox = new HashMap<>();
    static HashMap<String, Request> sender = new HashMap<>();
    HashMap<Integer, ArrayList<Student>> assembled2 = new HashMap<>();
    //String requirements = null;

    public Team(String course,int id, ArrayList<Student> members,String founder, String requirements){
        assembled2.put(id,members);
        assembled.put(id,members);
        teams.put(course,assembled2);
        team_founders.put(founder,id);
        //setRequirements(requirements);
        the_requirements.put(id,requirements);
    }
    public Team(){

    }
    public ArrayList<Integer> getHashMapKey(HashMap<Integer, ArrayList<Student>> b) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, ArrayList<Student>>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((Integer)f.getKey());
        }
        return list;
    }

}
