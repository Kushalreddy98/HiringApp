package org.hiringapp.model;

import java.util.Date;

public class JobPosting {
    private int jobId;
    private int companyId;
    private String jobTitle;
    private String jobDescreption;
    private int experienceRequired;
    private String location;
    private double salary;
    private Date postedDate;

    public JobPosting(int jobId, int companyId, String jobTitle, String jobDescreption, int experienceRequired, String location, double salary, Date postedDate) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.jobDescreption = jobDescreption;
        this.experienceRequired = experienceRequired;
        this.location = location;
        this.salary = salary;
        this.postedDate = postedDate;
    }

    public JobPosting(int companyId, String jobTitle, String jobDescreption, int experienceRequired, String location, double salary, Date postedDate) {
        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.jobDescreption = jobDescreption;
        this.experienceRequired = experienceRequired;
        this.location = location;
        this.salary = salary;
        this.postedDate = postedDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescreption() {
        return jobDescreption;
    }

    public void setJobDescreption(String jobDescreption) {
        this.jobDescreption = jobDescreption;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(int experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "jobId=" + jobId +
                ", companyId=" + companyId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescreption='" + jobDescreption + '\'' +
                ", experienceRequired=" + experienceRequired +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", postedDate=" + postedDate +
                '}';
    }
}
