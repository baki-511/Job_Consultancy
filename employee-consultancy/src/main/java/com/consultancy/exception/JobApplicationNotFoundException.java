package com.consultancy.exception;

public class JobApplicationNotFoundException extends RuntimeException{
    public JobApplicationNotFoundException(Integer applicantId) {
        super("Job Application NOT Found with ID : " + applicantId);
    }
    
    public JobApplicationNotFoundException(String msg) {
        super(msg);
    }
}
