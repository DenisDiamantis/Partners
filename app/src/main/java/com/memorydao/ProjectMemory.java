package com.memorydao;

import com.dao.ProjectDAO;
import com.r4.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectMemory implements ProjectDAO {
    static List<Project> projects=new ArrayList<>();


    @Override
    public void saveProject(Project project) {
        if(!projects.contains(projects)){
            projects.add(project);
        }
    }

    @Override
    public List<Project> getAvailableProjects() {
        return projects;
    }

    @Override
    public Project findProject(String course) {
        for (int i=0;i<projects.size();i++){
            if(projects.get(i).getCourse().equals(course))
                return projects.get(i);
        }
        return null;
    }
}
