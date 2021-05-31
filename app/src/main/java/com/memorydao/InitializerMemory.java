package com.memorydao;

import com.dao.AccountDAO;
import com.dao.Initializer;

public class InitializerMemory extends Initializer {

    @Override
    public AccountDAO getAccountDAO() {
        return new AccountMemory();
    }
}
