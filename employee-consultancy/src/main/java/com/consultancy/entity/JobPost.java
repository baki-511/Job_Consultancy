package com.consultancy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;
    private String jobTitle;
    private String salary;
    private String location;
    private String employmentStatus;
    private String jobDescription;
    
    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobApplication> jobApplications;
    
    public JobPost() {
    }
    
    public JobPost(Integer jobId, String jobTitle, String salary, String location, String employmentStatus, String jobDescription) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.location = location;
        this.employmentStatus = employmentStatus;
        this.jobDescription = jobDescription;
    }
    
    public JobPost(Integer jobId, String jobTitle, String salary, String location, String employmentStatus, String jobDescription, List<JobApplication> jobApplications) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.location = location;
        this.employmentStatus = employmentStatus;
        this.jobDescription = jobDescription;
        this.jobApplications = jobApplications;
    }
    
    public Integer getJobId() {
        return jobId;
    }
    
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public String getSalary() {
        return salary;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getEmploymentStatus() {
        return employmentStatus;
    }
    
    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
    
    public String getJobDescription() {
        return jobDescription;
    }
    
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }
    
    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
    
    @Override
    public String toString() {
        return "JobPost{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary='" + salary + '\'' +
                ", location='" + location + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobApplications=" + jobApplications +
                '}';
    }
}
