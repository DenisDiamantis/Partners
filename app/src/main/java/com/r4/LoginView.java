package com.r4;

import android.content.Intent;

public interface LoginView {

    public void signUp();
    public void showMenu(String AM);
    public void ShowError(String error);

    void showRegisterScreen();
}
