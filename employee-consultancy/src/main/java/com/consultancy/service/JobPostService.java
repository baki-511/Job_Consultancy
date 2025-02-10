package com.consultancy.service;

import com.consultancy.entity.JobPost;
import com.consultancy.payload.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobPostService {
    JobPost addJobPost(JobPost jobPost);
    
    List<JobPost> getAllJobPost();
    
    JobPost getJobPostById(Integer jobPostId);
    
    ApiResponse deleteJobPostById(Integer jobPostId);
    
    JobPost updateJobPost(JobPost jobPosts);
}
