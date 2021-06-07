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

public class LoginScreen extends AppCompatActivity implements  LoginView{
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        setTitle("Project Partners");
        EditText AMText = findViewById(R.id.AM);
        EditText PasswordText = findViewById(R.id.Password);
        Button LoginButton = findViewById(R.id.Login);
        Button SignUpButton = findViewById(R.id.SignUp);
        InitializerMemory initializer = new InitializerMemory();
        initializer.prepareData();
        AccountDAO account = initializer.getAccountDAO();
        presenter=new LoginPresenter(this);
        presenter.setAccountDAO(account);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String AM = AMText.getText().toString();
                String password = PasswordText.getText().toString();
                presenter.login(AM,password);
            }
        });
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signUp();
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

    @Override
    public void ShowError(String error) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show();
    }
}