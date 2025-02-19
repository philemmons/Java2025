package com.philemmons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JavaTutDatabase {

    public static void main(String[] args) throws Exception {
        Connection con;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://  ";
            String user = "";
            String pw = "";
            
            con = DriverManager.getConnection(url, user, pw);

            Statement s = con.createStatement();

            String query = "INSERT INTO student " +
                            "(fname, lname, street, student_id) "+
                            "VALUE "+
                            "('Shelly', 'Mary', 'Frank Castle', NULL)";

            s.execute(query);

            query = "SELECT * FROM student";

            ResultSet result = s.executeQuery(query);

            while (result.next()) {
                System.out.println(result.getString("fname"));
                System.out.println(result.getString("lname"));
                System.out.println(result.getString("street"));

            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
