package com.r4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dao.Initializer;
import com.memorydao.InitializerMemory;

public class Menu extends AppCompatActivity implements MenuView{
    protected static final String CURRENT_USER_AM = "current user AM";
    public static final String COURSE_SEARCH = "course_search";
    Button search_team_btn;
    Button messages_btn;
    Button create_team_btn;
    Button evaluate_btn;
    Button my_teams;
    EditText course_Txt;
    MenuPresenter presenter;
    protected static final String user="p3180068";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
       // user=intent.getStringExtra(CURRENT_USER_AM);
        setContentView(R.layout.activity_menu);
        setTitle("Menu");
        Initializer initializer=new InitializerMemory();
        initializer.prepareData();
        search_team_btn = findViewById(R.id.Search_Button);
        messages_btn = findViewById(R.id.Message_Button);
        create_team_btn = findViewById(R.id.Create_Team_Button);
        evaluate_btn = findViewById(R.id.Evaluate_Button);
        my_teams = findViewById(R.id.My_Teams_Button);
        course_Txt = findViewById(R.id.Enter_Course);
        presenter=new MenuPresenter(this);
        search_team_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  course=course_Txt.getText().toString();
                presenter.showResults(course,user);
                //showMenu();
            }
        });
        messages_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        create_team_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
        my_teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getTeams
            }
        });
    }
    public void showMenu(){
        Intent intent = new Intent(this,CreateTeam.class);
        startActivity(intent);
    }

    @Override
    public void showError(String course_cannot_be_null) {

    }

    @Override
    public void showResults(String course,String user) {
        Intent intent = new Intent(this,SearchResults.class);
        Log.e("user",user);
        intent.putExtra(CURRENT_USER_AM,user);
        intent.putExtra(COURSE_SEARCH,course);
        startActivity(intent);
    }

    @Override
    public void showMessages(String user){

    }
}