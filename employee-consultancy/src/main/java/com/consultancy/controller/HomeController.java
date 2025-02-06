package com.consultancy.controller;

import com.consultancy.entity.Resume;
import com.consultancy.service.ResumeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    private ResumeService resumeService;
    
    @GetMapping({"/", "/home"})
    public String home() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/career")
    public String career() {
        return "/pages/career";
    }
    
    @GetMapping("/upload-cv")
    public String uploadCV() {
        return "/pages/uploadCV";
    }
    
//    @GetMapping("/download/{id}")
//    public String downloadFile(@PathVariable Long resumeId, HttpServletResponse response) throws IOException {
//        Resume resumeById = resumeService.getResumeById(resumeId);
//
//        response.setContentType(resumeById.getFileType());
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + resumeById.getFileName() + "\"");
//        response.getOutputStream().write(resumeById.getData());
//        response.getOutputStream().flush();
//
//        return "redirect:/home";
//    }
    
    @GetMapping("/test2")
    public String test2() {
        return "redirect:/home";
    }

    
//    @GetMapping("/contact")
//    public String contactUs() {
//        return "/pages/contact";
//    }
}
