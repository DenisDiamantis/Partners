package com.r4;

import android.util.Log;

import com.dao.CourseDAO;
import com.dao.RequestDAO;
import com.memorydao.CourseMemory;
import com.memorydao.RequestMemory;

public class MenuPresenter {
    private MenuView view;
    private CourseDAO courseDAO;
    public MenuPresenter(MenuView menu) {
        this.view=menu;
    }

    public void showResults(String course,String user) {
        if(course.isEmpty()){
            view.showError("Course cannot be null");
        }else
        {
            if(courseDAO.findCourse(course)) view.showResults(course,user);
            else{
                view.showErrorCourse("Course may not have project or else check your input...");
            }
        }
    }
    public void editInfo() {
        view.editInfo();
    }
    public void myTeams(){
        view.myTeams();
    }

    public void createTeam(){
        view.createTeam();
    }

    public void showMessages(String user) {
        view.showMessages(user);
    }

    public void setCourseDAO(CourseDAO courseDAO){
        this.courseDAO = courseDAO;
    }
}
