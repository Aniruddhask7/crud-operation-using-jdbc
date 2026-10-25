package org.example;

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
        studrepo.createUser();

        studrepo.updateUser();

//        studrepo.deleteUser();

        studrepo.getUser();



    }

}
