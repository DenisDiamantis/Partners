package com.r4;

import com.dao.AccountDAO;

public class LoginPresenter {
    private LoginView view;
    private AccountDAO accountDAO;
    public LoginPresenter(LoginView view) {
        this.view=view;
    }


    public void login(String AM,String password){
        if(accountDAO.loginCheck(AM,password)){
            view.showMenu(AM);
        }else{
           view.ShowError("Account not found with those credentials");
        }
    }
    public void signUp(){
        view.signUp();
    }
    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
