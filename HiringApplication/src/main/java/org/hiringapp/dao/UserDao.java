package org.hiringapp.dao;
import org.hiringapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(User user) {
        String querry = "Insert into users (username, password, email, role) values (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getRole());
            int result = statement.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUserByUsername(String username) {
        String querry = "Select * from users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("user_id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getString("role")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(int userId, String password, String email) {
        String querry = "update users set password = ?, email = ? where user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1, password);
            statement.setString(2, email);
            statement.setInt(3, userId);
            Boolean result = statement.execute();
            System.out.println("Successfylly Updated " + !result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUSer(int userId) {
        String querry = "DELETE from users where user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, userId);
            Boolean result = statement.execute();
            System.out.println("Successfylly Deleted " + !result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
