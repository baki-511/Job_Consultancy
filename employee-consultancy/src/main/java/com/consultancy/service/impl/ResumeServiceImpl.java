package com.consultancy.service.impl;

import com.consultancy.entity.Resume;
import com.consultancy.exception.ResumeNotFoundException;
import com.consultancy.repository.ResumeRepository;
import com.consultancy.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ResumeServiceImpl implements ResumeService {
    
    @Autowired
    private ResumeRepository resumeRepository;
    
    @Override
    public Resume addResume(MultipartFile file) {
        try {
            Resume resume = new Resume();
            resume.setFileName(file.getOriginalFilename());
            resume.setFileType(file.getContentType());
            resume.setData(file.getBytes());
            return resumeRepository.save(resume);
        } catch (IOException e) {
            throw new RuntimeException("Failed to Store file " + file.getOriginalFilename() + ". Please Try Again!", e);
        }
    }
    
    @Override
    public Resume getResumeById(Long resumeId) {
        return resumeRepository.findById(resumeId)
                .orElseThrow(() -> new ResumeNotFoundException(resumeId));
    }
}
