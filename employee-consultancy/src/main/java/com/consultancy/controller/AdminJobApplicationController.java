package com.consultancy.controller;

import com.consultancy.entity.JobApplication;
import com.consultancy.entity.Services;
import com.consultancy.service.JobApplicationService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminJobApplicationController {
    @Autowired
    private JobApplicationService jobApplicationService;
    
    
    @GetMapping("/job-apps/all")
    public String allJobApps(Model model) {
        return allJobApplications(model, 0, 10);
    }
    
    @GetMapping("/job-apps/all/{page}")
    public String allJobApplications(Model model, @PathVariable int page, int size) {
        
        List<JobApplication> allJobsApp = jobApplicationService.getAllJobApplication();
        
        // Pagination
        Pageable pageable = PageRequest.of(page, size);
        int total = allJobsApp.size();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), total);
        List<JobApplication> subList = allJobsApp.subList(start, end);
        Page<JobApplication> jobAppPage = new PageImpl<>(subList, pageable, total);
        
        // Attributes
        model.addAttribute("jobApps", jobAppPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", jobAppPage.getTotalPages());
        model.addAttribute("totalItems", jobAppPage.getTotalElements());
        model.addAttribute("size", size);
        
        return "/admin/pages/jobApplication/all-job-application";
    }
    
}
