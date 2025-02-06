package com.consultancy.service;

import com.consultancy.dto.ApplicantDto;
import com.consultancy.entity.Applicant;
import com.consultancy.payload.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ApplicantService {
    Applicant saveApplicant(ApplicantDto applicantDto, MultipartFile file);
    
    Applicant getApplicantById(Long applicantId);
    
    List<Applicant> getAllApplicants();
    
    ApiResponse deleteApplicant(Long applicantId);
    
    Applicant updateApplicant(ApplicantDto applicantDto, MultipartFile file);
}
