package com.consultancy.entity;

import jakarta.persistence.*;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobApplicationId;
    private String applicantName;
    private String mobile;
    private String email;
    private Double experience;
    private String noticePeriod;
    private String currentSalary;
    private String expectedSalary;
    private String currentLocation;
    
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPost jobPost;
    
    @OneToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
    
    public JobApplication() {
    }
    
    public JobApplication(Integer jobApplicationId, String applicantName, String mobile, String noticePeriod,
                          String currentSalary, String expectedSalary, String currentLocation, JobPost jobPost) {
        this.jobApplicationId = jobApplicationId;
        this.applicantName = applicantName;
        this.mobile = mobile;
        this.noticePeriod = noticePeriod;
        this.currentSalary = currentSalary;
        this.expectedSalary = expectedSalary;
        this.currentLocation = currentLocation;
        this.jobPost = jobPost;
    }
    
    public JobApplication(Integer jobApplicationId, String applicantName, String mobile, String email, Double experience, String noticePeriod, String currentSalary, String expectedSalary, String currentLocation, JobPost jobPost, Resume resume) {
        this.jobApplicationId = jobApplicationId;
        this.applicantName = applicantName;
        this.mobile = mobile;
        this.email = email;
        this.experience = experience;
        this.noticePeriod = noticePeriod;
        this.currentSalary = currentSalary;
        this.expectedSalary = expectedSalary;
        this.currentLocation = currentLocation;
        this.jobPost = jobPost;
        this.resume = resume;
    }
    
    public JobApplication(Integer jobApplicationId, String applicantName, String mobile, String noticePeriod,
                          String currentSalary, String expectedSalary, String currentLocation, JobPost jobPost,
                          Resume resume) {
        this.jobApplicationId = jobApplicationId;
        this.applicantName = applicantName;
        this.mobile = mobile;
        this.noticePeriod = noticePeriod;
        this.currentSalary = currentSalary;
        this.expectedSalary = expectedSalary;
        this.currentLocation = currentLocation;
        this.jobPost = jobPost;
        this.resume = resume;
    }
    
    public Integer getJobApplicationId() {
        return jobApplicationId;
    }
    
    public void setJobApplicationId(Integer jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }
    
    public String getApplicantName() {
        return applicantName;
    }
    
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getNoticePeriod() {
        return noticePeriod;
    }
    
    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }
    
    public String getCurrentSalary() {
        return currentSalary;
    }
    
    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }
    
    public String getExpectedSalary() {
        return expectedSalary;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Double getExperience() {
        return experience;
    }
    
    public void setExperience(Double experience) {
        this.experience = experience;
    }
    
    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }
    
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public JobPost getJobPost() {
        return jobPost;
    }
    
    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
    
    public Resume getResume() {
        return resume;
    }
    
    public void setResume(Resume resume) {
        this.resume = resume;
    }
    
    @Override
    public String toString() {
        return "JobApplication{" +
                "jobApplicationId=" + jobApplicationId +
                ", applicantName='" + applicantName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", experience=" + experience +
                ", noticePeriod='" + noticePeriod + '\'' +
                ", currentSalary='" + currentSalary + '\'' +
                ", expectedSalary='" + expectedSalary + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                '}';
    }
}
