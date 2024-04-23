package org.hiringapp.main;

import org.hiringapp.dao.JobPostingDao;
import org.hiringapp.dao.UserDao;
import org.hiringapp.model.JobPosting;
import org.hiringapp.model.User;
import org.hiringapp.security.Validation;
import org.hiringapp.util.HiringDatabase;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
public class JobPortalMain {
    static Scanner scanner = new Scanner(System.in);
    static Connection connection = HiringDatabase.openconnection();
    static UserDao userDao = new UserDao(connection);
    static JobPostingDao jobPostingDao = new JobPostingDao(connection);
    static Validation validation = new Validation(connection);

    public static void main(String[] args) {
        System.out.println("Are you a Job seeker or an Employer? ('Enter job seeker or an employer')");
        String userChoice = scanner.nextLine().toLowerCase();
        if (userChoice.equals("job seeker")) {
            System.out.println("Welcome Job Seeker!!!");
            System.out.println("1. Register / Create account");
            System.out.println("2. Login");
            int seekerChoice = scanner.nextInt();
            switch (seekerChoice) {
                case 1:
                    System.out.println("Enter Your Username");
                    String username = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter your Email");
                    String email = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Your Password");
                    String password = scanner.next();
                    scanner.nextLine();
                    User user = new User(username, password, email, userChoice);
                    if (user != null) {
                        userDao.addUser(user);
                        System.out.println("User registered Successfully!");
                        break;
                    } else {
                        System.out.println("Failed to register user. Please try again.");
                    }
                case 2:
                    System.out.println("Enter Your Username");
                    String valUser = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Your Password");
                    String valPassword = scanner.next();
                    scanner.nextLine();
                    if (validation.validateUser(valUser, valPassword)) {
                        System.out.println("Successfully logged in");
                        System.out.println("1. Search for jobs");
                        System.out.println("2. Apply for Jobs");
                        System.out.println("3. View Applications and Status");
                        System.out.println("4. Withdraw Application");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter the Title you want to search");
                                String jobTitle = scanner.next();
                                scanner.nextLine();
                                List<JobPosting> jobPosting = jobPostingDao.getJobPostingByJobTitle(jobTitle);
                                    for (JobPosting jobByTitle:jobPosting) {
                                        System.out.println(jobByTitle + " ");
                                    }
                                if (jobPosting.isEmpty())
                                    System.out.println("No Job Found By specified Title");


                        }

                    } else {
                        System.out.println("Invalid Credentials");
                    }

            }
        }
    }
}
