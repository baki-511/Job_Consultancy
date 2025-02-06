package com.consultancy.service;

import com.consultancy.entity.Resume;
import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {
    Resume addResume(MultipartFile file);
    Resume getResumeById(Long resumeId);
}
