package com.consultancy.repository;

import com.consultancy.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicesRepository extends JpaRepository<Services, Long> {
    Optional<Services> findByTitle(String serviceTitle);
}
