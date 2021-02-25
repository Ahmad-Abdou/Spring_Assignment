package org.example.dao.StudentSequencer;

public class StudentSequencer {
    private static  int studentId ;

    public  static  int nextId(){
     return ++studentId;
    }
    public static int getStudentId(){
        return studentId;
    }
}
