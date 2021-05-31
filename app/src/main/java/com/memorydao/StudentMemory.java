package com.memorydao;

import com.dao.StudentDAO;
import com.r4.Student;

import java.util.ArrayList;

public class StudentMemory implements StudentDAO {

    ArrayList<Student> students = new ArrayList<>();


    @Override
    public void saveStudent(Student student) {
        if(!students.contains(student)){
            students.add(student);
        }
    }
}
