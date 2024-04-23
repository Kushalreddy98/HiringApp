package org.hiringapp.model;

import java.util.Date;

public class Application {
    private int applicationId;
    private int jobId;
    private int userID;
    private String resume;
    private String coverLetter;
    private String status;
    private Date applicationDate;

    public Application(int applicationId, int jobId, int userID, String resume, String coverLetter, String status, Date applicationDate) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.userID = userID;
        this.resume = resume;
        this.coverLetter = coverLetter;
        this.status = status;
        this.applicationDate = applicationDate;
    }

    public Application(int jobId, int userID, String resume, String coverLetter, String status, Date applicationDate) {
        this.jobId = jobId;
        this.userID = userID;
        this.resume = resume;
        this.coverLetter = coverLetter;
        this.status = status;
        this.applicationDate = applicationDate;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", jobId=" + jobId +
                ", userID=" + userID +
                ", resume='" + resume + '\'' +
                ", coverLetter='" + coverLetter + '\'' +
                ", status='" + status + '\'' +
                ", applicationDate=" + applicationDate +
                '}';
    }
}
