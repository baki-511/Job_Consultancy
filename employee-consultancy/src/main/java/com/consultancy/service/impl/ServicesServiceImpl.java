package com.consultancy.service.impl;

import com.consultancy.entity.Services;
import com.consultancy.exception.ServiceNotFoundException;
import com.consultancy.payload.ApiResponse;
import com.consultancy.repository.ServicesRepository;
import com.consultancy.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;
    
    @Override
    public Services addService(Services services, MultipartFile file) {
        String image = getImageToString(file);
        services.setImage(image);
        return servicesRepository.save(services);
    }
    
    @Override
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }
    
    @Override
    public Services getServiceById(Long serviceId) {
        return servicesRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceNotFoundException(serviceId));
    }
    
    @Override
    public Services getServiceByTitle(String serviceTitle) {
        return servicesRepository.findByTitle(serviceTitle)
                .orElseThrow(() -> new ServiceNotFoundException("Service NOT Found with Title : " + serviceTitle));
    }
    
    @Override
    public ApiResponse deleteServiceById(Long serviceId) {
        Services serviceById = getServiceById(serviceId);
        servicesRepository.delete(serviceById);
        return new ApiResponse("Service Deleted Successfully! ", true);
    }
    
    @Override
    public Services updateService(Services services, MultipartFile file) {
        Services serviceById = getServiceById(services.getServiceId());
        if (file.isEmpty()) {
            services.setImage(serviceById.getImage());
        }else{
            String image = getImageToString(file);
            services.setImage(image);
        }
        return servicesRepository.save(services);
    }
    
    private String getImageToString(MultipartFile file) {
        String image = "";
        try {
            image = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
