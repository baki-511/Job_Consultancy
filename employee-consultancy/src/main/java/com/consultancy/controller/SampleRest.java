package com.consultancy.controller;

import com.consultancy.entity.Resume;
import com.consultancy.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin")
public class SampleRest {
    @Autowired
    private ResumeService resumeService;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        Resume resume = resumeService.addResume(file);
        return new ResponseEntity<>("File Uploaded Successfully : " + file.getOriginalFilename(), HttpStatus.OK);
    }
    
    @GetMapping("/resume/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Resume fileEntity = resumeService.getResumeById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .body(fileEntity.getData());
    }
    
    
}
