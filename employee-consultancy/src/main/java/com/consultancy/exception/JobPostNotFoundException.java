package com.consultancy.exception;

public class JobPostNotFoundException extends RuntimeException{
    public JobPostNotFoundException(Integer applicantId) {
        super("Job Post NOT Found with ID : " + applicantId);
    }
    
    public JobPostNotFoundException(String msg) {
        super(msg);
    }
}
