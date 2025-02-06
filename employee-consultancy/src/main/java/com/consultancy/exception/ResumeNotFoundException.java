package com.consultancy.exception;

public class ResumeNotFoundException extends RuntimeException{
    public ResumeNotFoundException(Long resumeId) {
        super("Resume NOT Found With ID : " + resumeId);
    }
    
    public ResumeNotFoundException(String msg) {
        super(msg);
    }
}
