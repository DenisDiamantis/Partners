package com.r3;


import java.util.*;

public class CourseDAO {

    int size;
    String name;
    static HashMap<String,Integer> courses = new HashMap<>();

    public CourseDAO(String name, int teammaxsize){
        setTeamSize(teammaxsize);
        setCourseName(name);
        courses.put(name,teammaxsize);
    }
    public CourseDAO(){

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
    public String getCourseName(){
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
