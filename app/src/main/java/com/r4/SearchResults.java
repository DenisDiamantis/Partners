package com.r4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.dao.AccountDAO;
import com.dao.StudentDAO;
import com.dao.TeamDAO;
import com.memorydao.AccountMemory;
import com.memorydao.StudentMemory;
import com.memorydao.TeamMemory;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends AppCompatActivity implements TeamFragment.OnInteractionListener {

    public static final String COURSE_NAME_KEYWORD = "course_name_keyword";
    private TeamDAO teamDAO;
    private StudentDAO studentDAO;
    private String user;
    private String course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teamDAO=new TeamMemory();
        studentDAO=new StudentMemory();
        Intent intent = getIntent();
        user = intent.getStringExtra(Menu.CURRENT_USER_AM);
        course = intent.getStringExtra(Menu.COURSE_SEARCH);
        setContentView(R.layout.activity_search_results);
        setTitle("Search Results");
    }

    @Override
    public void TeamSelection(Team team) {
        for(int i=0;i<studentDAO.getStudents().size();i++)
        {
            Log.e("user",user);
            Log.e("student",studentDAO.getStudents().get(i).getAM());
            if(user.equals(studentDAO.getStudents().get(i).getAM())){
                Log.e("Im in","finally");
                Request request=new Request(studentDAO.getStudents().get(i),team,"I would like to join your team...");
                for(int j=0;j<teamDAO.allTeams().size();j++)
                {
                    Log.e("team",team.toString());
                    Log.e("dao",teamDAO.allTeams().get(j).toString());
                    if(team.equals(teamDAO.allTeams().get(j))){
                        Log.e("TOAST","inside");
                        teamDAO.allTeams().get(j).addRequests(request);
                        Toast.makeText(getApplicationContext(),"Application made",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    @Override
    public List<Team> getTeams() {
        List<Team> list = new ArrayList<>();
        for(int p=0;p<teamDAO.allTeams().size();p++){
            if(teamDAO.allTeams().get(p).getProject().getCourse().getTitle().equals(course)){
               list.add(teamDAO.allTeams().get(p));
            }
        }
        return list; 
    }
}