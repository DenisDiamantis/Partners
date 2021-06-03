package com.dao;

import com.r4.Team;

import java.util.List;

public interface TeamDAO {


    public void saveTeam(Team team);


    List<Team> allTeams();
}
