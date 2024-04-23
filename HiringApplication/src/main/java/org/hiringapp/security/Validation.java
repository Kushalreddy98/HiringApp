package org.hiringapp.security;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validation {
    private Connection connection;

    public Validation(Connection connection) {
        this.connection = connection;
    }

    public Boolean validateUser(String username, String password) {
        String querry = "select * from users where username= ? and password = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
