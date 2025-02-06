package com.consultancy.service.impl;

import com.consultancy.entity.Info;
import com.consultancy.exception.InfoNotFoundException;
import com.consultancy.repository.InfoRepository;
import com.consultancy.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoRepository infoRepository;
    
    @Override
    public Info addInfo(Info info) {
        return infoRepository.save(info);
    }
    
    @Override
    public Info getInfoById(Integer infoId) {
        return infoRepository.findById(infoId)
                .orElseThrow(() -> new InfoNotFoundException(infoId));
    }
    
    @Override
    public Info updateInfo(Info info) {
        getInfoById(info.getInfoId());
        return infoRepository.save(info);
    }
}
