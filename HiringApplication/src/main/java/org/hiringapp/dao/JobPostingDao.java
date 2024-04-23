package org.hiringapp.dao;
import org.hiringapp.model.JobPosting;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class JobPostingDao {
    private Connection connection;

    public JobPostingDao(Connection connection) {
        this.connection = connection;
    }

    public void addJobPosting(JobPosting jobPosting) {
        String querry = "INSERT INTO job_postings (company_id, job_title, job_description, experience_required, location, salary, posted_date)values(?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, jobPosting.getCompanyId());
            statement.setString(2, jobPosting.getJobTitle());
            statement.setString(3, jobPosting.getJobDescreption());
            statement.setInt(4, jobPosting.getExperienceRequired());
            statement.setString(5, jobPosting.getLocation());
            statement.setDouble(6, jobPosting.getSalary());
            statement.setDate(7, new java.sql.Date(jobPosting.getPostedDate().getTime()));

            Boolean result = statement.execute();
            System.out.println("Succufully Added " + !result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<JobPosting> getAllJobs() {
        List<JobPosting> jobPostings = new ArrayList<>();
        String querry = "Select * from job_postings";
        try (PreparedStatement statement = connection.prepareStatement(querry);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                JobPosting jobPosting = new JobPosting(
                        resultSet.getInt("job_id"),
                        resultSet.getInt("company_id"),
                        resultSet.getString("job_title"),
                        resultSet.getString("job_description"),
                        resultSet.getInt("experience_required"),
                        resultSet.getString("location"),
                        resultSet.getDouble("salary"),
                        resultSet.getDate("posted_date")
                );
                jobPostings.add(jobPosting);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobPostings;
    }

    public List<JobPosting> getJobPostingByCompanyId(int companyId) {
        List<JobPosting> jobPostings = new ArrayList<>();
        String querry = "Select * from job_postings where company_id= ? ";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, companyId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    JobPosting jobPosting = new JobPosting(
                            resultSet.getInt("job_id"),
                            resultSet.getInt("company_id"),
                            resultSet.getString("job_title"),
                            resultSet.getString("job_description"),
                            resultSet.getInt("experience_required"),
                            resultSet.getString("location"),
                            resultSet.getDouble("salary"),
                            resultSet.getDate("posted_date")


                    );
                    jobPostings.add(jobPosting);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobPostings;
    }

    public List<JobPosting> getJobPostingByJobTitle(String jobTitle) {
        List<JobPosting> jobPostings = new ArrayList<>();
        String querry = "Select * from job_postings where job_title= ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1, jobTitle);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    JobPosting jobPosting = new JobPosting(
                            resultSet.getInt("job_id"),
                            resultSet.getInt("company_id"),
                            resultSet.getString("job_title"),
                            resultSet.getString("job_description"),
                            resultSet.getInt("experience_required"),
                            resultSet.getString("location"),
                            resultSet.getDouble("salary"),
                            resultSet.getDate("posted_date")


                    );
                    jobPostings.add(jobPosting);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobPostings;
    }

    public void deleteJobPosting(int jobId) {
        String querry = "Delete from job_postings where job_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, jobId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
