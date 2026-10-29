package org.example.repositery;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user =  "hr";
    String pass = "pass";

    public void createStudentUser(Student student){

        String data = """
        INSERT INTO crudstudentEx11 (id, name, email, age)
        VALUES (?, ?, ?, ?)
        """;

        try(
                Connection con = DriverManager.getConnection(url , user , pass);

                PreparedStatement preparedStmt = con.prepareStatement(data);
                ){

            preparedStmt.setLong(1, student.getId());
            preparedStmt.setString(2, student.getName());
            preparedStmt.setString(3, student.getEmail());
            preparedStmt.setInt(4, student.getAge());

            int rowAffected = preparedStmt.executeUpdate();

            if (rowAffected > 0) {
                System.out.println("Data Inserted Successfully");
            } else {
                System.out.println("Something went wrong");
            }

            preparedStmt.close();
            con.close();

        }catch(SQLException e){
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }


    public void updateStudentUser(Student student , Long id){

        String sql = """
                             Update crudstudentEx11
                             set name=?,
                                 email=?,
                                 age=?
                             where id=?
                        """;
        try(
                Connection con = DriverManager.getConnection(url , user , pass);

                PreparedStatement preparedStmt = con.prepareStatement(sql);
                ){


            preparedStmt.setString(1, student.getName());
            preparedStmt.setString(2, student.getEmail());
            preparedStmt.setInt(3, student.getAge());
            preparedStmt.setInt(4, Math.toIntExact(id));


            int result2 = preparedStmt.executeUpdate();




            if(result2 ==1){
                System.out.println("row upadted succesfully");
            }else{
                System.out.println("row not updated");
            }

        }catch(SQLException e){
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }


    }


    public void deleteStudentUser(Long id){

        String sql = """
                      delete from crudstudentEx11 where  id = ?
                      """;

        try(Connection con = DriverManager.getConnection(url , user , pass);

            PreparedStatement  prepStmt = con.prepareStatement(sql);
            ){

            prepStmt.setLong(1,id);

            int rowAffected = prepStmt.executeUpdate(sql);

            if(rowAffected ==1){
                System.out.println("row deleted successfully");
            }else{
                System.out.println("row not deleted");
            }

        }catch(SQLException e){
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

    }



    public void getStudentUser(Long id) {

        String sql = """
            SELECT id, name, email, age
            FROM crudstudentEx11
            WHERE id = ?
            """;

        try (
                Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement preStmt = con.prepareStatement(sql)
        ) {

            preStmt.setLong(1, id);

            try (ResultSet result = preStmt.executeQuery()) {

                if (result.next()) {
                    Student student = mapRow(result);
                    System.out.println(student);
                } else {
                    System.out.println("Student not found with ID: " + id);
                }
            }

        } catch (SQLException e) {
            System.out.println("Data not fetched");
            e.printStackTrace();
        }
    }




    public void completCRUD(){
        try{
            Connection con = DriverManager.getConnection(url , user , pass);

            Statement statement = con.createStatement();


            String sql = "Select id,name,email,age " +
                    "from crudstudentEx11 where id = 15 ";

            boolean result = statement.execute(sql);

            if(result){
                ResultSet resultset = statement.getResultSet();
                 System.out.println(resultset);
            }else{
                int rowAffected = statement.getUpdateCount();
                System.out.println(rowAffected);
            }



            System.out.println("Data Successfully fetched");

            con.close();

        }catch(SQLException e){
            System.out.println("Data Not fetched");
            e.printStackTrace();
        }

    }



    private Student mapRow(ResultSet result) throws SQLException {
        Student student  = new Student();

        student.setId(result.getLong("id"));
        student.setAge(result.getInt("Age"));
        student.setEmail(result.getString("Email"));
        student.setName(result.getString("Name"));

        return   student;
    }

}

















//            String table = "CREATE TABLE crudstudentEx11 ("
//                    + "id NUMBER PRIMARY KEY, "
//                    + "name VARCHAR2(100) NOT NULL, "
//                    + "email VARCHAR2(100) UNIQUE, "
//                    + "age NUMBER(3)"
//                    + ")";
//
//
//            int result1 = statement.executeUpdate(table);
//            System.out.println(result1);