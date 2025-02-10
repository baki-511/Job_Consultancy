package com.consultancy.repository;

import com.consultancy.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

}
