package com.consultancy.service;

import com.consultancy.dto.JobApplicationDto;
import com.consultancy.entity.JobApplication;
import com.consultancy.payload.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobApplicationService {
    JobApplication addJobApplication(JobApplicationDto jobApplicationDto, MultipartFile file);
    
    List<JobApplication> getAllJobApplication();
    
    JobApplication getJobApplicationById(Integer jobApplicationId);
    
    ApiResponse deleteJobApplicationById(Integer jobApplicationId);
    
    JobApplication updateJobApplication(JobApplicationDto jobApplicationDto, MultipartFile file);
}
