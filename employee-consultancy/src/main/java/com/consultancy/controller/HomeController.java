package com.consultancy.controller;

import com.consultancy.entity.Resume;
import com.consultancy.service.BannerService;
import com.consultancy.service.ResumeService;
import com.consultancy.service.TestimonialService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private TestimonialService testimonialService;
    
    @Autowired
    private BannerService bannerService;
    
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("testimonials", testimonialService.getAllTestimonial());
        model.addAttribute("banners", bannerService.getAllBanner());
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("testimonials", testimonialService.getAllTestimonial());
        return "/pages/about";
    }
    
    @GetMapping("/service")
    public String service() {
        return "/pages/service";
    }
    
    @GetMapping("/test3")
    public String test3() {
        return "/pages/jobForm";
    }
    @GetMapping("/test2")
    public String test2() {
        return "redirect:/home";
    }
    
    @GetMapping("/boot")
    public String bootTest1() {
        return "/pages/bootstrap1";
    }
    
//    @GetMapping("/contact")
//    public String contactUs() {
//        return "/pages/contact";
//    }
}
