package com.r3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    Account account = new Account("p3180068","cr7forthewin","cr7@gmail.com");

    @Test
    public void getEmail(){
        Assert.assertEquals("cr7@gmail.com",account.getEmail());
    }
    @Test
    public void getPassword(){
        Assert.assertEquals("cr7forthewin",account.getPassword());
    }
    @Test
    public void getAM(){
        Assert.assertEquals("p3180068",account.getAM());
    }
    @Test
    public void setPassword(){
        account.setPassword("messiisbetter");
        Assert.assertEquals("messiisbetter",account.getPassword());
    }
}