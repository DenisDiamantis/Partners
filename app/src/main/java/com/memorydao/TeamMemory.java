package com.memorydao;

import com.dao.TeamDAO;
import com.r4.Team;

import java.util.ArrayList;

public class TeamMemory implements TeamDAO {

    ArrayList<Team> teams = new ArrayList<>();

    @Override
    public void saveTeam(Team team) {
        if(!teams.contains(team)){
            teams.add(team);
        }
    }

}
