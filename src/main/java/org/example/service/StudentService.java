
package org.example.service;

import org.example.model.Student;
import org.example.repositery.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public void createStudent(Student student) {
        studentRepository.createStudentUser(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.getStudent();
    }

    // READ BY ID
    public Student getStudentById(Long id) {
        return studentRepository.getStudentUser(id);
    }

    // UPDATE
    public void updateStudent(Student student) {
        studentRepository.updateStudent(
                student,
                student.getId()
        );
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteStudentUser(id);
    }
}
