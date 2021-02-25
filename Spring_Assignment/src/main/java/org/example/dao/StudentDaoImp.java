package org.example.dao;

import org.example.dao.StudentSequencer.StudentSequencer;
import org.example.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("studentDao")
public class StudentDaoImp implements  StudentDao{
    List<Student> list = new ArrayList<>();

    @Override
    public Student saveOrUpdate(Student student) {
        if(student.getId() == 0){
            student.setId(StudentSequencer.nextId());
            list.add(student);
        }
        else {
            Student student1 = findById(student.getId());
            student1.setName(student.getName());
        }
        return student;
    }

    @Override
    public Student findById(int id) {
        if(id == 0){
            throw  new IllegalArgumentException("id should not be 0");
        }
        return list.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {

        return list.removeIf(student -> student.getId() == id);
    }

    @Override
    public List<Student> findAll() {
        return list;
    }
}
