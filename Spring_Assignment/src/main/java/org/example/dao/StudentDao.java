package org.example.dao;

import org.example.model.Student;

import java.util.List;


public interface StudentDao {
    Student saveOrUpdate(Student appUser);

    Student findById(int id);

    boolean delete(int id);

    List<Student> findAll();
}
