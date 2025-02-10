package com.consultancy.repository;

import com.consultancy.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

}
