package com.consultancy.service;

import com.consultancy.entity.Testimonial;
import com.consultancy.payload.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TestimonialService {
    Testimonial addTestimonial(Testimonial testimonial, MultipartFile file);
    
    List<Testimonial> getAllTestimonial();
    
    Testimonial getTestimonialById(Long testimonialId);
    
    ApiResponse deleteTestimonialById(Long testimonialId);
    
    Testimonial updateTestimonial(Testimonial testimonial, MultipartFile file);
}
