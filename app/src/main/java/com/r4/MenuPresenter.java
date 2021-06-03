package com.r4;

import android.util.Log;

public class MenuPresenter {
    private MenuView view;

    public MenuPresenter(MenuView menu) {
        this.view=menu;
    }

    public void showResults(String course,String user) {
        Log.e("user",user);
        if(course.isEmpty()){
            view.showError("Course cannot be null");
        }else
        {
            Log.e(course,"course");
            view.showResults(course,user);
        }
    }
}
