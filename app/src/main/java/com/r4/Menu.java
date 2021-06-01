package com.r4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button search_team_btn = findViewById(R.id.Search_Button);
        Button messages_btn = findViewById(R.id.Message_Button);
        Button create_team_btn = findViewById(R.id.Create_Team_Button);
        Button evaluate_btn = findViewById(R.id.Evaluate_Button);
        Button my_teams = findViewById(R.id.My_Teams_Button);
        EditText course = findViewById(R.id.Enter_Course);
        create_team_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }
    public void showMenu(){
        Intent intent = new Intent(this,CreateTeam.class);
        startActivity(intent);
    }
}