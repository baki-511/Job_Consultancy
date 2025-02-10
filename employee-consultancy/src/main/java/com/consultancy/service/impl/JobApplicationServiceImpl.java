package com.consultancy.service.impl;

import com.consultancy.dto.JobApplicationDto;
import com.consultancy.entity.JobApplication;
import com.consultancy.entity.Resume;
import com.consultancy.exception.JobApplicationNotFoundException;
import com.consultancy.payload.ApiResponse;
import com.consultancy.repository.JobApplicationRepository;
import com.consultancy.service.JobApplicationService;
import com.consultancy.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    
    @Autowired
    private ResumeService resumeService;
    
    @Override
    public JobApplication addJobApplication(JobApplicationDto jobApplicationDto, MultipartFile file) {
        JobApplication jobApplication = toJobApplication(jobApplicationDto);
        Resume resume = resumeService.addResume(file);
        jobApplication.setResume(resume);
        return jobApplicationRepository.save(jobApplication);
    }
    
    @Override
    public List<JobApplication> getAllJobApplication() {
        return jobApplicationRepository.findAll();
    }
    
    @Override
    public JobApplication getJobApplicationById(Integer jobApplicationId) {
        return jobApplicationRepository.findById(jobApplicationId)
                .orElseThrow(()->new JobApplicationNotFoundException(jobApplicationId));
    }
    
    @Override
    public ApiResponse deleteJobApplicationById(Integer jobApplicationId) {
        JobApplication jobApplicationById = getJobApplicationById(jobApplicationId);
        jobApplicationRepository.delete(jobApplicationById);
        return new ApiResponse("Job Application Delted Successfully!", true);
    }
    
    @Override
    public JobApplication updateJobApplication(JobApplicationDto jobApplicationDto, MultipartFile file) {
        JobApplication jobApplicationById = getJobApplicationById(jobApplicationDto.getJobApplicationId());
        JobApplication jobApplication = toJobApplication(jobApplicationDto);
        if (file.isEmpty()) {
            jobApplication.setResume(jobApplicationById.getResume());
        } else {
            Resume resume = resumeService.addResume(file);
            jobApplication.setResume(resume);
        }
        return jobApplicationRepository.save(jobApplication);
    }
    
    private JobApplication toJobApplication(JobApplicationDto jobApplicationDto) {
        JobApplication application = new JobApplication();
        application.setJobApplicationId(jobApplicationDto.getJobApplicationId());
        application.setApplicantName(jobApplicationDto.getApplicantName());
        application.setMobile(jobApplicationDto.getMobile());
        application.setNoticePeriod(jobApplicationDto.getNoticePeriod());
        application.setCurrentSalary(jobApplicationDto.getCurrentSalary());
        application.setExpectedSalary(jobApplicationDto.getExpectedSalary());
        application.setCurrentLocation(jobApplicationDto.getCurrentLocation());
        application.setJobPost(jobApplicationDto.getJobPost());
        return application;
    }
}
