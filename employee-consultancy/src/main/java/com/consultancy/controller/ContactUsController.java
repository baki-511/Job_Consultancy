package com.consultancy.controller;

import com.consultancy.entity.ContactUs;
import com.consultancy.service.ContactUsService;
import com.consultancy.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/contact")
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;
    
    @Autowired
    private ServicesService servicesService;
    
    @GetMapping("/contact")
    public String contactUs(Model model) {
        model.addAttribute("services", servicesService.getAllServices());
        return "/pages/contact";
    }
   
    @PostMapping("/contact/save")
    public String saveContact(@ModelAttribute ContactUs contactUs, RedirectAttributes redirectAttributes) {
        ContactUs savedContactUs = contactUsService.addContactUs(contactUs);
        if (savedContactUs != null) {
            redirectAttributes.addFlashAttribute("message", "Message Sent Successfully!");
        }
        return "redirect:/contact";
    }
}
