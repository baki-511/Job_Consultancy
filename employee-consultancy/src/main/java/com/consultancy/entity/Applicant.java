package com.consultancy.entity;

import jakarta.persistence.*;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;
    private String fullName;
    private String mobile;
    private String email;
    private String currentLocation;
    private String industry;
    private Double experience;
    private String currentSalary;
    private String noticePeriod;
    
    @OneToOne
    private Resume resume;
    
    
    public Applicant() {
    }
    
    public Applicant(Long applicantId, String fullName, String mobile, String email, String currentLocation,
                     String industry, Double experience, String currentSalary, String noticePeriod, Resume resume) {
        this.applicantId = applicantId;
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.currentLocation = currentLocation;
        this.industry = industry;
        this.experience = experience;
        this.currentSalary = currentSalary;
        this.noticePeriod = noticePeriod;
        this.resume = resume;
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
    
    public Double getExperience() {
        return experience;
    }
    
    public void setExperience(Double experience) {
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
    
    public Resume getResume() {
        return resume;
    }
    
    public void setResume(Resume resume) {
        this.resume = resume;
    }
    
    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", fullName='" + fullName + '\'' +
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
