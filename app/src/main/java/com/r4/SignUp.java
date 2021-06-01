package com.r4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dao.AccountDAO;
import com.memorydao.InitializerMemory;

public class SignUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText name = findViewById(R.id.Student_Name);
        EditText surname = findViewById(R.id.Student_Surname);
        EditText password1 = findViewById(R.id.Student_Password1);
        EditText password2 = findViewById(R.id.Student_Password2);
        EditText email = findViewById(R.id.Student_Email);
        EditText AM = findViewById(R.id.Student_AM);
        EditText skills = findViewById(R.id.Student_Skills);
        EditText timeline = findViewById(R.id.Student_Timeline);
        Button continue_btn = findViewById(R.id.button);
        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitializerMemory initializer = new InitializerMemory();
                initializer.prepareData();
                AccountDAO account = initializer.getAccountDAO();
                String input_AM = AM.getText().toString();
                String input_password1 = password1.getText().toString();
                String input_password2 = password2.getText().toString();
                String input_email = email.getText().toString();
                String input_name = name.getText().toString();
                String input_surname = name.getText().toString();
                if(account.checkAMExistance(input_AM) && account.checkAMFormat(input_AM) && account.checkName(input_name) && account.checkSurname(input_surname) && account.checkEmailExistance(input_email) && account.checkEmailFormat(input_email) && account.checkPasswordValidity(input_password1) && account.checkPasswordEquality(input_password1, input_password2)){
                    showMenu();
                }else{
                    Toast.makeText(getApplicationContext(),"Please fit all the criteria in order to proceed...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void showMenu(){
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
    /*public void inputCheck(){

    }*/

}