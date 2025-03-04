package com.consultancy.exception;

public class ServiceNotFoundException extends RuntimeException{
    public ServiceNotFoundException(Long serviceId) {
        super("Service NOT Found With ID : " + serviceId);
    }
    
    public ServiceNotFoundException(String msg) {
        super(msg);
    }
}
