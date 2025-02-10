package com.consultancy.dto;

import com.consultancy.entity.JobPost;

public class JobApplicationDto {
    private Integer jobApplicationId;
    private String applicantName;
    private String mobile;
    private String noticePeriod;
    private String currentSalary;
    private String expectedSalary;
    private String currentLocation;

    private JobPost jobPost;
    private byte[] data;
    
    public JobApplicationDto() {
    }
    
    public JobApplicationDto(Integer jobApplicationId, String applicantName, String mobile, String noticePeriod, String currentSalary, String expectedSalary, String currentLocation, JobPost jobPost, byte[] data) {
        this.jobApplicationId = jobApplicationId;
        this.applicantName = applicantName;
        this.mobile = mobile;
        this.noticePeriod = noticePeriod;
        this.currentSalary = currentSalary;
        this.expectedSalary = expectedSalary;
        this.currentLocation = currentLocation;
        this.jobPost = jobPost;
        this.data = data;
    }
    
    public JobApplicationDto(Integer jobApplicationId, String applicantName, String mobile, String noticePeriod, String currentSalary, String expectedSalary, String currentLocation, JobPost jobPost) {
        this.jobApplicationId = jobApplicationId;
        this.applicantName = applicantName;
        this.mobile = mobile;
        this.noticePeriod = noticePeriod;
        this.currentSalary = currentSalary;
        this.expectedSalary = expectedSalary;
        this.currentLocation = currentLocation;
        this.jobPost = jobPost;
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
    
    public byte[] getData() {
        return data;
    }
    
    public void setData(byte[] data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "JobApplicationDto{" +
                "jobApplicationId=" + jobApplicationId +
                ", applicantName='" + applicantName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", noticePeriod='" + noticePeriod + '\'' +
                ", currentSalary='" + currentSalary + '\'' +
                ", expectedSalary='" + expectedSalary + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                '}';
    }
}
