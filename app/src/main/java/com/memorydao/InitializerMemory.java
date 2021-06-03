package com.memorydao;

import com.dao.AccountDAO;
import com.dao.Initializer;
import com.dao.TeamDAO;

public class InitializerMemory extends Initializer {

    @Override
    public AccountDAO getAccountDAO() {
        return new AccountMemory();
    }

    @Override
    public TeamDAO getTeamDAO() {
        return new TeamMemory();
    }
}
