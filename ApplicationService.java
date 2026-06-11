package com.pms.service;

import com.pms.entity.Application;
import com.pms.entity.Job;
import com.pms.entity.Student;
import com.pms.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application applyForJob(
            Student student,
            Job job) {

        if (student.getCgpa()
                < job.getMinimumCgpa()) {

            throw new RuntimeException(
                    "CGPA criteria not satisfied");
        }

        if (!student.getBranch()
                .equalsIgnoreCase(
                        job.getRequiredBranch())) {

            throw new RuntimeException(
                    "Branch not eligible");
        }

        Application application =
                new Application();

        application.setStudent(student);
        application.setJob(job);
        application.setApplicationDate(
                LocalDate.now());

        application.setStatus("PENDING");

        return applicationRepository.save(
                application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application updateStatus(
            Long applicationId,
            String status) {

        Application application =
                applicationRepository
                        .findById(applicationId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Application not found"));

        application.setStatus(status);

        return applicationRepository.save(
                application);
    }
}
