package com.consultancy.exception;

public class ContactUsNotFoundException extends RuntimeException{
    public ContactUsNotFoundException(Long contactUsId) {
        super("Contact Us NOT Found with ID : " + contactUsId);
    }
}
