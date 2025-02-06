package com.consultancy.service.impl;

import com.consultancy.entity.ContactUs;
import com.consultancy.exception.ContactUsNotFoundException;
import com.consultancy.payload.ApiResponse;
import com.consultancy.repository.ContactUsRepository;
import com.consultancy.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactUsService {
    @Autowired
    private ContactUsRepository contactUsRepository;
    
    @Override
    public ContactUs addContactUs(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }
    
    @Override
    public List<ContactUs> getAllContactUs() {
        return contactUsRepository.findAll();
    }
    
    @Override
    public ContactUs getContactUsById(Long contactUsId) {
        return contactUsRepository.findById(contactUsId)
                .orElseThrow(()->new ContactUsNotFoundException(contactUsId));
    }
    
    @Override
    public ApiResponse deleteContactUs(Long contactUsId) {
        ContactUs contactUsById = getContactUsById(contactUsId);
        contactUsRepository.delete(contactUsById);
        return new ApiResponse("Contact Us Deleted Successfully!", true);
    }
    
    @Override
    public ContactUs updateContactUs(ContactUs contactUs) {
        ContactUs contactUsById = getContactUsById(contactUs.getContactUsId());
        return addContactUs(contactUs);
    }
}
