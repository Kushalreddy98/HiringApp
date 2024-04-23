package org.hiringapp.dao;
import org.hiringapp.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CompanyDao {
    private Connection connection;

    public CompanyDao(Connection connection) {
        this.connection = connection;
    }

    public void addCompany(Company company) {
        String querry = "insert into companies (company_name, industry, location, website, contact_email)values(?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1, company.getCompanyName());
            statement.setString(2, company.getIndustry());
            statement.setString(3, company.getLocation());
            statement.setString(4, company.getWebsite());
            statement.setString(5, company.getContactEmail());
            Boolean result = statement.execute();
            System.out.println("Successfully added " + !result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Company getComapnyById(int companyId) {
        String querry = "select * from companies where company_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, companyId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Company(
                            resultSet.getInt("company_id"),
                            resultSet.getString("company_name"),
                            resultSet.getString("industry"),
                            resultSet.getString("location"),
                            resultSet.getString("website"),
                            resultSet.getString("contact_email")
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

    public void updateCompany(String industry, String location, String website, String email, int companyId ) {
        String querry = "update companies set industry = ?, location = ?, website = ?, contact_email=? where company_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1, industry);
            statement.setString(2, location);
            statement.setString(3, website);
            statement.setString(4, email);
            statement.setInt(5, companyId);
            Boolean result = statement.execute();
            System.out.println("Successfully Updated " + !result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(int companyId) {
        String querry = "delete from companies where company_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setInt(1, companyId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
