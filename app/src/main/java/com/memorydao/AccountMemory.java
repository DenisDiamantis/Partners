package com.memorydao;

import com.dao.AccountDAO;
import com.r4.Account;

import java.util.ArrayList;

public class AccountMemory implements AccountDAO {

    static ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public boolean loginCheck(String AM, String password){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAM().equals(AM) && accounts.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPasswordValidity(String password) {

        if (password.length() < 6 || password.length() > 15) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkPasswordEquality(String password1, String password2) {
        if(password1.equals(password2)){
            return true;
        }
        return false;

    }

    @Override
    public boolean checkName(String name) {
        if(!name.equals("")){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkSurname(String surname) {
        if(!surname.equals("")){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAMFormat(String AM) {
        if(AM.startsWith("p3") && AM.length()==8){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAMExistance(String AM) {
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getAM().equals(AM)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkEmailFormat(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!email.matches(regex)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkEmailExistance(String email) {
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void saveAccount(Account account) {
        if(!accounts.contains(account)){
            accounts.add(account);
        }

    }
}
