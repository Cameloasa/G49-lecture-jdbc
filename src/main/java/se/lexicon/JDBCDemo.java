package se.lexicon;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            //Create connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "root1234");
            //Create statement
            Statement statement = connection.createStatement();
            //Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            //executeQuery method is used for executing SELECT queries(READ)
            //executeUpdate method is used for executing INSERT, DELETE, UPDATE queries

            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                //System.out.println("Student ID: " + studentId);
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(studentId + ","+firstName+","+lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
