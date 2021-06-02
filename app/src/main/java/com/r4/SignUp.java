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
                int conditions = 0;
                if(account.checkAMExistance(input_AM)){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"The AM you entered already exists...", Toast.LENGTH_SHORT).show();
                }
                if(account.checkAMFormat(input_AM)){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"Please check the AM...", Toast.LENGTH_SHORT).show();
                }
                if(account.checkName(input_name)){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"Name can not be null...", Toast.LENGTH_SHORT).show();
                }
                if(account.checkSurname(input_surname)){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"Surname can not be null...", Toast.LENGTH_SHORT).show();
                }
                if(account.checkEmailExistance(input_email)){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"The email you entered already exists...", Toast.LENGTH_SHORT).show();
                }
                if(account.checkEmailFormat(input_email)){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"Incorrect email format", Toast.LENGTH_SHORT).show();
                }
                if(account.checkPasswordValidity(input_password1) ){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"The password must be between 6-15 characters...", Toast.LENGTH_SHORT).show();
                }
                if(account.checkPasswordEquality(input_password1, input_password2)){
                    conditions++;
                }else{
                    Toast.makeText(getApplicationContext(),"The passwords you entered do not match...", Toast.LENGTH_SHORT).show();
                }
                if(conditions==8){
                    showMenu();
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