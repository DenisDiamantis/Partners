package com.memorydao;

import com.dao.TeamDAO;
import com.r4.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamMemory implements TeamDAO {

    static List<Team> teams = new ArrayList<>();

    @Override
    public void saveTeam(Team team) {
        if(!teams.contains(team)){
            teams.add(team);
        }
    }

    @Override
    public List<Team> allTeams() {
        return teams;
    }

}
