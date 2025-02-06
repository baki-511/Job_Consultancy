package com.consultancy.entity;

import jakarta.persistence.*;

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;
    private String fileName;
    private String fileType;
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] data;
    
    
    public Resume() {
    }
    
    public Resume(Long resumeId, String fileName, String fileType, byte[] data) {
        this.resumeId = resumeId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
    
    public Long getResumeId() {
        return resumeId;
    }
    
    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    public byte[] getData() {
        return data;
    }
    
    public void setData(byte[] data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Resume{" +
                "resumeId=" + resumeId +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
