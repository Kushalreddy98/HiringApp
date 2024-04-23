package org.hiringapp.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiringDatabase {
    static Connection connection;
    public static Connection openconnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hiring", "root", "root");
            System.out.println("Connected Database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
