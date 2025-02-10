package com.consultancy.service.impl;

import com.consultancy.entity.JobPost;
import com.consultancy.exception.JobPostNotFoundException;
import com.consultancy.payload.ApiResponse;
import com.consultancy.repository.JobPostRepository;
import com.consultancy.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobPostServiceImpl implements JobPostService {
    @Autowired
    private JobPostRepository jobPostRepository;
    
    @Override
    public JobPost addJobPost(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }
    
    @Override
    public List<JobPost> getAllJobPost() {
        return jobPostRepository.findAll();
    }
    
    @Override
    public JobPost getJobPostById(Integer jobPostId) {
        return jobPostRepository.findById(jobPostId)
                .orElseThrow(()->new JobPostNotFoundException(jobPostId));
    }
    
    @Override
    public ApiResponse deleteJobPostById(Integer jobPostId) {
        JobPost jobPostById = getJobPostById(jobPostId);
        jobPostRepository.delete(jobPostById);
        return new ApiResponse("Job Post Successfully Deleted!", true);
    }
    
    @Override
    public JobPost updateJobPost(JobPost jobPosts) {
        JobPost jobPostById = getJobPostById(jobPosts.getJobId());
        return jobPostRepository.save(jobPosts);
    }
}
