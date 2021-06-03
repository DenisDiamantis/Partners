package com.memorydao;

import com.dao.StudentDAO;
import com.r4.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMemory implements StudentDAO {

    static  ArrayList<Student> students = new ArrayList<>();


    @Override
    public void saveStudent(Student student) {
        if(!students.contains(student)){
            students.add(student);
        }
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }
}
