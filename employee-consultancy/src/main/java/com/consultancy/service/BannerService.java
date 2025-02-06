package com.consultancy.service;

import com.consultancy.entity.Banner;
import com.consultancy.payload.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    Banner addBanner(Banner blog, MultipartFile file);
    
    List<Banner> getAllBanner();
    
    Banner getBannerById(Integer bannerId);
    
    ApiResponse deleteBannerById(Integer bannerId);
    
    Banner updateBanner(Banner banner, MultipartFile file);
}
