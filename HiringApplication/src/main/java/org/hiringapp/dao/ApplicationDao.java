package org.hiringapp.dao;
import org.hiringapp.model.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ApplicationDao {
    private Connection connection;

    public ApplicationDao(Connection connection) {
        this.connection = connection;
    }

    public void addApplication(Application application) {
        String querry = "insert into applications(job_id,user_id,resume,cover_letter,status,application_date) values (?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, application.getJobId());
            statement.setInt(2, application.getUserID());
            statement.setString(3, application.getResume());
            statement.setString(4, application.getCoverLetter());
            statement.setString(5, application.getStatus());
            statement.setDate(6, new java.sql.Date(application.getApplicationDate().getTime()));
            Boolean result = statement.execute();
            System.out.println("Successfully Added : " +!result );


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Application> getAllApplication() {
        List<Application> applications = new ArrayList<>();
        String querry = "Select * from applications";
        try (PreparedStatement statement = connection.prepareStatement(querry);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Application application = new Application(
                        resultSet.getInt("application_id"),
                        resultSet.getInt("job_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("resume"),
                        resultSet.getString("cover_letter"),
                        resultSet.getString("status"),
                        resultSet.getDate("application_date")
                );
                applications.add(application);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    public List<Application> getApplicationsByUserId(int userId) {
        List<Application> applications = new ArrayList<>();
        String querry = "Select * from applications where user_id = ? ";
        try(PreparedStatement statement = connection.prepareStatement(querry)){
            statement.setInt(1,userId);
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    Application application = new Application(
                            resultSet.getInt("application_id"),
                            resultSet.getInt("job_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("resume"),
                            resultSet.getString("cover_letter"),
                            resultSet.getString("status"),
                            resultSet.getDate("application_date")
                    );
                    applications.add(application);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return applications;
    }

    public void updateApplicationStatus(String status, int applicationId){
        String querry = "update applications set status = ? where application_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)){
            statement.setString(1,status);
            statement.setInt(2,applicationId);
            Boolean re  = statement.execute();
            System.out.println("Successfully Updated : " +!re);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteApplication(int applicationId){
        String querry = "Delete from applications where application_id = ?";
        try(PreparedStatement statement =connection.prepareStatement(querry)){
            statement.setInt(1,applicationId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
