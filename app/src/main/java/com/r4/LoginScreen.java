package com.r4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dao.AccountDAO;
import com.dao.Initializer;
import com.memorydao.AccountMemory;
import com.memorydao.InitializerMemory;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        EditText AMText = findViewById(R.id.AM);
        EditText PasswordText = findViewById(R.id.Password);
        Button LoginButton = findViewById(R.id.Login);
        Button SignUpButton = findViewById(R.id.SignUp);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitializerMemory initializer = new InitializerMemory();
                initializer.prepareData();
                AccountDAO account = initializer.getAccountDAO();
                String AM = AMText.getText().toString();
                String password = PasswordText.getText().toString();
                if(account.loginCheck(AM,password)){
                    showMenu(AM);
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid credentials, try again...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }
    public void signUp(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void showMenu(String AM){
        Intent intent = new Intent(this,Menu.class);
        intent.putExtra(Menu.CURRENT_USER_AM,AM);
        startActivity(intent);
    }
}