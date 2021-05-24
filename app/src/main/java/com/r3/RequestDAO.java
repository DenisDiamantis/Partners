package com.r3;

import java.util.*;

public class RequestDAO {

    String AM = null;
    String message = null;
    int id;
    String thecourse = null;
    TeamDAO teamDAO = new TeamDAO();
    HashMap<String,String> all_messages = new HashMap<>();
    public RequestDAO(){

    }
    public RequestDAO(String AM, String message, int id, String thecourse){
        setAM(AM);
        setMessage(message);
        setID(id);
        setTheCourse(thecourse);
    }
    public void setAM(String AM){
        this.AM=AM;
    }
    public String getAM(){
        return AM;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }//(8667,(p3180068,message,8667))
    public void setID(int id){
        this.id=id;
    }
    public int getID(){
        return id;
    }
    public void setTheCourse(String thecourse){
        this.thecourse= thecourse;
    }
    public String getTheCourse(){
        return thecourse;
    }

    public ArrayList<String> getHashMapKey(HashMap<String, RequestDAO> b) {
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, RequestDAO>> set;
        set = b.entrySet();
        Iterator iterator = set.iterator();
        for (int o = 0; o < set.size(); o++) {
            Map.Entry f = (Map.Entry) iterator.next();
            list.add((String)f.getKey());
        }
        return list;
    }
}
