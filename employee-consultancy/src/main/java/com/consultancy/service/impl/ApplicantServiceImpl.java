package com.consultancy.service.impl;

import com.consultancy.dto.ApplicantDto;
import com.consultancy.entity.Applicant;
import com.consultancy.entity.Resume;
import com.consultancy.exception.ApplicantNotFoundException;
import com.consultancy.payload.ApiResponse;
import com.consultancy.repository.ApplicantRepository;
import com.consultancy.service.ApplicantService;
import com.consultancy.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;
    
    @Autowired
    private ResumeService resumeService;
    
    @Override
    public Applicant saveApplicant(ApplicantDto applicantDto, MultipartFile file) {
        Applicant applicant = toApplicant(applicantDto);
        Resume resume = resumeService.addResume(file);
        applicant.setResume(resume);
        return applicantRepository.save(applicant);
    }
    
    @Override
    public Applicant getApplicantById(Long applicantId) {
        return applicantRepository.findById(applicantId)
                .orElseThrow(()->new ApplicantNotFoundException(applicantId));
    }
    
    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }
    
    @Override
    public ApiResponse deleteApplicant(Long applicantId) {
        Applicant applicantById = getApplicantById(applicantId);
        applicantRepository.delete(applicantById);
        return new ApiResponse("Applicant Deleted Successfully!", true);
    }
    
    @Override
    public Applicant updateApplicant(ApplicantDto applicantDto, MultipartFile file) {
        Applicant applicantById = getApplicantById(applicantDto.getApplicantId());
        Applicant applicant = toApplicant(applicantDto);
        if (file.isEmpty()) {
            applicant.setResume(applicantById.getResume());
        }else{
            Resume resume = resumeService.addResume(file);
            applicant.setResume(resume);
        }
        return applicantRepository.save(applicant);
    }
    
    private Applicant toApplicant(ApplicantDto applicantDto) {
        Applicant applicant = new Applicant();
        applicant.setFullName(applicantDto.getFullName());
        applicant.setMobile(applicantDto.getMobile());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setCurrentLocation(applicantDto.getCurrentLocation());
        applicant.setIndustry(applicantDto.getIndustry());
        applicant.setExperience(applicantDto.getExperience());
        applicant.setCurrentSalary(applicantDto.getCurrentSalary());
        applicant.setNoticePeriod(applicantDto.getNoticePeriod());
        return applicant;
    }
}
