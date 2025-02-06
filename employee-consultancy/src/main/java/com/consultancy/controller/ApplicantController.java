package com.consultancy.controller;

import com.consultancy.dto.ApplicantDto;
import com.consultancy.entity.Applicant;
import com.consultancy.entity.Services;
import com.consultancy.service.ApplicantService;
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

@Controller
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    
    @GetMapping("/upload-cv")
    public String uploadCV(Model model) {
        model.addAttribute("applicant", new ApplicantDto());
        return "/pages/uploadCV";
    }
    
    @PostMapping("/applicant/save")
    public String saveApplicant(@ModelAttribute ApplicantDto applicantDto,
                                @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        Applicant applicant = applicantService.saveApplicant(applicantDto, file);
        if (applicant != null) {
            redirectAttributes.addFlashAttribute("message", "Application Sent Successfully!");
        }
        return "redirect:/upload-cv";
    }
    
    
    @GetMapping("/admin/resumes/all")
    public String allApplication(Model model) {
        return allApplications(model, 0, 10);
    }
    
    @GetMapping("/admin/resumes/all/{page}")
    public String allApplications(Model model, @PathVariable int page, int size) {
        
        List<Applicant> allApplicants = applicantService.getAllApplicants();
        
        // Pagination
        Pageable pageable = PageRequest.of(page, size);
        int total = allApplicants.size();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), total);
        List<Applicant> subList = allApplicants.subList(start, end);
        Page<Applicant> applicantPage = new PageImpl<>(subList, pageable, total);
        
        // Attributes
        model.addAttribute("resumes", applicantPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", applicantPage.getTotalPages());
        model.addAttribute("totalItems", applicantPage.getTotalElements());
        model.addAttribute("size", size);
        
        return "/admin/pages/resume/all-resumes";
    }
    
    
    
}
