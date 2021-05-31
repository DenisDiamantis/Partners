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
    public void saveAccount(Account account) {
        if(!accounts.contains(account)){
            accounts.add(account);
        }

    }
}
