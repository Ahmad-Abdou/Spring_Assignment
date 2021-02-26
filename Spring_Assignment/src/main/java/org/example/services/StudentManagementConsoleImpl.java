package org.example.services;

import org.example.dao.StudentDao;
import org.example.dao.sequencer.StudentSequencer;
import org.example.model.Student;
import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentManagementConsoleImpl implements StudentManagement{
    UserInputService userInputService;
    StudentDao studentDao;
    @Autowired
    public void setScannerService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }
       @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        Student createStudent = new Student(userInputService.getString());
        return createStudent;
    }

    @Override
    public Student save(Student student) {
        return  studentDao.saveOrUpdate(student);
    }

    @Override
    public Student find(int id) {
        if(id<= 0)throw  new IllegalArgumentException("Invalid id");
        Student student = studentDao.findById(id);
        return student;
    }

    @Override
    public Student remove(int id) {
        if(id <= 0 ) throw new IllegalArgumentException("Invalid id");
        Student student = studentDao.findById(id);
        studentDao.delete(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return  studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if(student == null)throw new IllegalArgumentException("Student does not exist");
        Student student1 = find(student.getId());
        student1.setName(userInputService.getString());
        return student1;
    }
}
