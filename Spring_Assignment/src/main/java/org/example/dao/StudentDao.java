package org.example.dao;

import org.example.model.Student;

import java.util.List;


public interface StudentDao {
    Student saveOrUpdate(Student student);

    Student findById(int id);

    boolean delete(int id);

    List<Student> findAll();
}
