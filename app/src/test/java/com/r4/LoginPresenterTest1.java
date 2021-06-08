package com.r4;

import com.dao.AccountDAO;
import com.dao.Initializer;
import com.memorydao.AccountMemory;
import com.memorydao.InitializerMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPresenterTest1{

    private LoginViewStub view;
    private LoginPresenter presenter;
    private AccountDAO accountDAO;
    @Before
    public void setup(){
        Initializer initializer = new InitializerMemory();
        initializer.prepareData();
        accountDAO = new AccountMemory();
        view = new LoginViewStub();
        presenter = new LoginPresenter(view);
        presenter.setAccountDAO(accountDAO);
    }

    @Test
    public void successfulLogin(){
        presenter.login("p3180068","olimpiakara");
        Assert.assertEquals(0,view.getErrorCount());
    }
    @Test
    public void loginFailed(){
        presenter.login("p3180068","olympiakos");
        Assert.assertEquals(1,view.getErrorCount());
    }
    @Test
    public void signUp(){
        presenter.signUp();
        Assert.assertEquals(0, view.getErrorCount());
    }

}