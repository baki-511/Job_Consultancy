package com.consultancy.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class ApplicantDto {
    private Long applicantId;
    private String fullName;
    private String mobile;
    private String email;
    private String currentLocation;
    private String industry;
    private Integer experience;
    private String currentSalary;
    private String noticePeriod;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] data;
    
    public ApplicantDto(Long applicantId, String fullName, String mobile, String email, String currentLocation,
                        String industry, Integer experience, String currentSalary, String noticePeriod, byte[] data) {
        this.applicantId = applicantId;
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.currentLocation = currentLocation;
        this.industry = industry;
        this.experience = experience;
        this.currentSalary = currentSalary;
        this.noticePeriod = noticePeriod;
        this.data = data;
    }
    
    public ApplicantDto() {
    }
    
    public Long getApplicantId() {
        return applicantId;
    }
    
    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public String getIndustry() {
        return industry;
    }
    
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    public Integer getExperience() {
        return experience;
    }
    
    public void setExperience(Integer experience) {
        this.experience = experience;
    }
    
    public String getCurrentSalary() {
        return currentSalary;
    }
    
    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }
    
    public String getNoticePeriod() {
        return noticePeriod;
    }
    
    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }
    
    public byte[] getData() {
        return data;
    }
    
    public void setData(byte[] data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "ApplicantDto{" +
                "fullName='" + fullName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", industry='" + industry + '\'' +
                ", experience=" + experience +
                ", currentSalary='" + currentSalary + '\'' +
                ", noticePeriod='" + noticePeriod + '\'' +
                '}';
    }
}
