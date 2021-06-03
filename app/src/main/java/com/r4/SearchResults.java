package com.r4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.dao.TeamDAO;
import com.memorydao.TeamMemory;

import java.util.List;

public class SearchResults extends AppCompatActivity implements TeamFragment.OnInteractionListener {

    public static final String COURSE_NAME_KEYWORD = "course_name_keyword";
    private TeamDAO teamDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teamDAO=new TeamMemory();
        Intent intent=getIntent();
        String course=intent.getStringExtra(COURSE_NAME_KEYWORD);
        setContentView(R.layout.activity_search_results);
        setTitle("Search Results");
    }

    @Override
    public void TeamSelection(Team team) {

    }

    @Override
    public List<Team> getTeams() {
        return teamDAO.allTeams();
    }
}