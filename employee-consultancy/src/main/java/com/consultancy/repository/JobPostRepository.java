package com.consultancy.repository;

import com.consultancy.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
    
    public Optional<JobPost> findByJobTitle(String jobTitle);

}
