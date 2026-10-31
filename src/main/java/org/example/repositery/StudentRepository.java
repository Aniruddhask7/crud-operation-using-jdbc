
package org.example.repositery;

import org.example.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.example.exception.EmailAlreadyExistException;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Map database row to Student object
    private final RowMapper<Student> studentRowMapper = (rs, rowNum) -> {
        Student student = new Student();

        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setAge(rs.getInt("age"));

        return student;
    };

    // CREATE
    public void createStudentUser(Student student) {

        try{
            String sql = """
                INSERT INTO crudstudentEx11 (id, name, email, age)
                VALUES (?, ?, ?, ?)
                """;

            jdbcTemplate.update(
                    sql,
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getAge()
            );
        }catch (EmailAlreadyExistException e) {
            throw new EmailAlreadyExistException("Email already exists "+student.getEmail());
        }

    }

    // READ ALL
    public List<Student> getStudent() {

        String sql = """
                SELECT id, name, email, age
                FROM crudstudentEx11
                ORDER BY id
                """;

        return jdbcTemplate.query(sql, studentRowMapper);
    }

    // READ BY ID
    public Student getStudentUser(Long id) {

        String sql = """
                SELECT id, name, email, age
                FROM crudstudentEx11
                WHERE id = ?
                """;

        List<Student> students =
                jdbcTemplate.query(sql, studentRowMapper, id);

        return students.isEmpty() ? null : students.get(0);
    }

    // UPDATE
    public void updateStudent(Student student, Long id) {

        String sql = """
                UPDATE crudstudentEx11
                SET name = ?, email = ?, age = ?
                WHERE id = ?
                """;

        int rowsAffected = jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                id
        );

        if (rowsAffected > 0) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    // DELETE
    public void deleteStudentUser(Long id) {

        String sql = """
                DELETE FROM crudstudentEx11
                WHERE id = ?
                """;

        int rowsAffected = jdbcTemplate.update(sql, id);

        if (rowsAffected > 0) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
}
