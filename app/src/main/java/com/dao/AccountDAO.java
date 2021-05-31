package com.dao;
import com.r4.Account;
import com.r4.Student;

public interface AccountDAO {

    public void saveAccount(Account account);

    public boolean loginCheck(String AM, String password);
}
