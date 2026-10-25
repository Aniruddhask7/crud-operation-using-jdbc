package org.example.repositery;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user =  "hr";
    String pass = "pass";

    public void createUser(){

        try{
            Connection con = DriverManager.getConnection(url , user , pass);

             Statement statement = con.createStatement();


//            String table = "CREATE TABLE studentExd ("
//                    + "id NUMBER PRIMARY KEY, "
//                    + "name VARCHAR2(100) NOT NULL, "
//                    + "email VARCHAR2(100) UNIQUE, "
//                    + "age NUMBER(3)"
//                    + ")";


//            int result1 = statement.executeUpdate(table);

            String data = "insert into studentExd (id , name , email , age)" +"values ('103','Amol' , 'amol@gmail.com' , '29')";

            int result2 = statement.executeUpdate(data);


            if(result2 ==1){
                System.out.println("One row inserted successfully");
            }else{
                System.out.println("Table not created");
            }




            con.close();

        }catch(SQLException e){
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }




    }


    public void updateUser(){

        try{
            Connection con = DriverManager.getConnection(url , user , pass);

            Statement statement = con.createStatement();


            String sql = "update studentExd set age = 20 where id = 101";

            int result2 = statement.executeUpdate(sql);


            if(result2 ==1){
                System.out.println("row upadted succesfully");
            }else{
                System.out.println("row not updated");
            }




            con.close();

        }catch(SQLException e){
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }


    }


    public void deleteUser(){


        try{
            Connection con = DriverManager.getConnection(url , user , pass);

            Statement statement = con.createStatement();


            String sql = "delete from studentExd where  id = 101";

            int result2 = statement.executeUpdate(sql);


            if(result2 ==1){
                System.out.println("row deleted successfully");
            }else{
                System.out.println("row not deleted");
            }




            con.close();

        }catch(SQLException e){
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

    }



    public void getUser(){
        try{
            Connection con = DriverManager.getConnection(url , user , pass);

            Statement statement = con.createStatement();


            String sql = "Select * from studentExd";

          ResultSet  result =   statement.executeQuery(sql);


//          Student student = mapRow(result);

          ResultSet rs = statement.executeQuery("Select * from studentExd");

          while(rs.next()){
              System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
          }

            System.out.println("Data Successfully fetched");

            con.close();

        }catch(SQLException e){
            System.out.println("Data Not fetched");
            e.printStackTrace();
        }



    }

//    private Student mapRow(ResultSet result) throws SQLException {
//        Student student  = new Student();
//
//        student.setId(result.getLong("id"));
//        student.setAge(result.getInt("Age"));
//        student.setEmail(result.getString("Email"));
//        student.setName(result.getString("Name"));
//
//        return   student;
//    }

}
