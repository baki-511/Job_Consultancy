package com.consultancy.service;

import com.consultancy.entity.Info;

public interface InfoService {
    Info addInfo(Info info);
    
    Info getInfoById(Integer infoId);
    
    Info updateInfo(Info info);
}
