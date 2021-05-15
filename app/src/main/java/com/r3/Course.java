package com.r3;


import java.util.*;

public class Course {

    int size;
    String name;
    static HashMap<String,Integer> courses = new HashMap<>();

    public Course(String name,int teammaxsize){
        this.size = teammaxsize;
        this.name = name;
        courses.put(name,teammaxsize);
    }
    public Course(){

    }
    public void setTeamSize(int size){
        this.size = size;
    }
    public int getTeamSize(){
        return size;
    }
    public void setCourseName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public ArrayList<String> getHashMapKey(HashMap<String, Integer> b) {
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, Integer>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String) f.getKey());
        }
        return list;
    }
}
