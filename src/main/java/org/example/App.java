package org.example;

import org.example.model.Student;
import org.example.repositery.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */

@SpringBootApplication
 public class App {

    public static void main(String[] args) {


        StudentRepository studrepo = new StudentRepository();
         // studrepo.createStudentUser(new Student(42L, "vaibjav" , "vaibhav@gmail.com",73));
        studrepo.updateStudentUser(new Student("Arjun" , "arj@gmail.com" , 19),8L);
       // studrepo.deleteStudentUser();
        //studrepo.getUser();
        //studrepo.completCRUD();



    }

}
