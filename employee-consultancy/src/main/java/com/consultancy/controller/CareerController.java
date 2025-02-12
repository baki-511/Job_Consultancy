package com.consultancy.controller;

import com.consultancy.dto.JobApplicationDto;
import com.consultancy.entity.JobApplication;
import com.consultancy.entity.JobPost;
import com.consultancy.payload.ApiResponse;
import com.consultancy.service.JobApplicationService;
import com.consultancy.service.JobPostService;
import com.consultancy.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CareerController {
    @Autowired
    private ResumeService resumeService;
    
    @Autowired
    private JobApplicationService jobApplicationService;
    
    @Autowired
    private JobPostService jobPostService;
    
    
    @GetMapping("/career")
    public String career(Model model, @RequestParam("jobType") String jobType) {
        List<JobPost> allJobPost = jobPostService.getAllJobPost();
        if (jobType.equals("Full Time")) {
            List<JobPost> jobPosts = allJobPost.stream()
                    .filter(f -> f.getEmploymentStatus().equals(jobType))
                    .toList();
             model.addAttribute("jobPosts", jobPosts);
        } else if (jobType.equals("Part Time")) {
            List<JobPost> jobPosts = allJobPost.stream()
                    .filter(f -> f.getEmploymentStatus().equals(jobType))
                    .toList();
             model.addAttribute("jobPosts", jobPosts);
        } else {
            model.addAttribute("jobPosts", allJobPost);
        }
        return "/pages/career";
    }
    
    @GetMapping("/career/job")
    public String jobPost(@RequestParam("jobPost") String jobPost, Model model) {
        model.addAttribute("jobName", jobPost);
        return "/pages/jobForm";
        
    }
    
    @PostMapping("/career/job-post/save")
    public String saveApplicantResume(@ModelAttribute JobApplicationDto applicantDto,
                                      @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        JobApplication applicant = jobApplicationService.addJobApplication(applicantDto, file);
        if (applicant != null) {
            redirectAttributes.addFlashAttribute("message", "Submitted Successfully!");
        }
        
        return "redirect:/career?jobType=All";
    }
    
    @GetMapping("/admin/job-post/add")
    public String addJob() {
        return "/admin/pages/jobPost/add-jobPost";
    }
    
    @PostMapping("/admin/job-post/save")
    public String addJob(@ModelAttribute JobPost jobPost, RedirectAttributes redirectAttributes) {
        JobPost savedJobPost = jobPostService.addJobPost(jobPost);
        if (savedJobPost != null) {
            redirectAttributes.addFlashAttribute("message", "Added New Job Post");
        }
        
        return "redirect:/admin/job-post/all";
    }
    
    @GetMapping("/admin/job-post/all")
    public String allJobs(Model model) {
        return allJobPosts(model, 0, 10);
    }
    
    @GetMapping("/admin/job-post/all/{page}")
    public String allJobPosts(Model model, @PathVariable int page, int size) {
        List<JobPost> allJobApplications = jobPostService.getAllJobPost();
        
        // Pagination
        Pageable pageable = PageRequest.of(page, size);
        int total = allJobApplications.size();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), total);
        List<JobPost> subList = allJobApplications.subList(start, end);
        Page<JobPost> jobPostPage = new PageImpl<>(subList, pageable, total);
        
        // Attributes
        model.addAttribute("jobPosts", jobPostPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", jobPostPage.getTotalPages());
        model.addAttribute("totalItems", jobPostPage.getTotalElements());
        model.addAttribute("size", size);
        
        return "/admin/pages/jobPost/all-jobPosts";
    }
    
    @GetMapping("/job-post/delete/{jobId}")
    public String deleteJobApplication(@PathVariable Integer jobId, RedirectAttributes redirectAttributes) {
        ApiResponse apiResponse = jobApplicationService.deleteJobApplicationById(jobId);
        if (apiResponse != null) {
            redirectAttributes.addFlashAttribute("message", "Deleted Successfully!");
        }
        return "redirect:/admin/job-post/all";
    }
    
}
