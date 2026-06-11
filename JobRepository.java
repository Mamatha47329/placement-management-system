package com.pms.repository;

import com.pms.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByRequiredBranch(String requiredBranch);

}
