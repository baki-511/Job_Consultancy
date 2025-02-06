package com.consultancy.exception;

public class ApplicantNotFoundException extends RuntimeException{
    public ApplicantNotFoundException(Long applicantId) {
        super("Applicant NOT Found with ID : " + applicantId);
    }
    
    public ApplicantNotFoundException(String msg) {
        super(msg);
    }
}
