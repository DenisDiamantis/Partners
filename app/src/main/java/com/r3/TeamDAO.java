package com.r3;


import java.util.*;

public class TeamDAO {

    static HashMap<String, HashMap<Integer, ArrayList<StudentDAO>>> teams = new HashMap<>();
    static HashMap<String, Integer> team_founders = new HashMap<>();
    static HashMap<Integer, ArrayList<StudentDAO>> assembled = new HashMap<>();
    static HashMap<Integer,String> the_requirements = new HashMap<>();
    static HashMap<Integer, HashMap<String, RequestDAO>> inbox = new HashMap<>();
    static HashMap<String, RequestDAO> sender = new HashMap<>();
    HashMap<Integer, ArrayList<StudentDAO>> assembled2 = new HashMap<>();
    //String requirements = null;

    public TeamDAO(String course, int id, ArrayList<StudentDAO> members, String founder, String requirements){
        assembled2.put(id,members);
        assembled.put(id,members);
        teams.put(course,assembled2);
        team_founders.put(founder,id);
        //setRequirements(requirements);
        the_requirements.put(id,requirements);
    }
    public TeamDAO(){

    }
    public ArrayList<Integer> getHashMapKey(HashMap<Integer, ArrayList<StudentDAO>> b) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, ArrayList<StudentDAO>>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((Integer)f.getKey());
        }
        return list;
    }

}
