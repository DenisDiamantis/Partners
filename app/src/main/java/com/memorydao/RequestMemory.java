package com.memorydao;

import com.dao.RequestDAO;
import com.r4.Request;

import java.util.ArrayList;
import java.util.List;

public class RequestMemory implements RequestDAO {
    static List<Request> requests=new ArrayList<>();
    @Override
    public void saveRequest(Request request) {
        if(!requests.contains(request)){
            requests.add(request);
        }
    }
}