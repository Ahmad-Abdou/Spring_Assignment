package org.example;

import org.example.ComponentScanConfig.AppConfig;
import org.example.dao.StudentDao;
import org.example.model.Student;
import org.example.util.ScannerConfiguration;
import org.example.util.ScannerInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args){

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    StudentDao dao = context.getBean("studentDao", StudentDao.class);
    Student createdStudent = dao.saveOrUpdate(new Student("mehrdad"));
        Student createdStudent2 = dao.saveOrUpdate(new Student("ahmad"));
        Student createdStudent3 = dao.saveOrUpdate(new Student("Simon"));
        System.out.println("createdStudent = "+createdStudent);
        System.out.println("-----------------------------------------------");
        System.out.println("Finding All");
        dao.findAll().forEach(System.out::println);
        System.out.println("-----------------------------------------------");
        System.out.println("Finding by Id");
        System.out.println(dao.findById(2));
        System.out.println("-----------------------------------------------");
        System.out.println("Deleting student");
        System.out.println(dao.delete(3));
        System.out.println("-----------------------------------------------");
        System.out.println("Finding All");
        dao.findAll().forEach(System.out::println);
        System.out.println("-------------------------------     Part 2     --------------------------------------------");
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ScannerConfiguration.class);
        ScannerInputService sc =  context1.getBean("scannerInputService", ScannerInputService.class);
        System.out.println(sc.getInt());
        System.out.println(sc.getString());

  }
}
