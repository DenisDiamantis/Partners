package com.r4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dao.Initializer;
import com.memorydao.InitializerMemory;

public class Menu extends AppCompatActivity implements MenuView{
    Button search_team_btn;
    Button messages_btn;
    Button create_team_btn;
    Button evaluate_btn;
    Button my_teams;
    EditText course_Txt;
    MenuPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
                presenter.showResults(course);
                //showMenu();
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
    public void showResults(String course) {
        Intent intent = new Intent(this,SearchResults.class);
        intent.putExtra(SearchResults.COURSE_NAME_KEYWORD,course);
        startActivity(intent);
    }
}