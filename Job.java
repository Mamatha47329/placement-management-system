package com.pms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String requiredBranch;

    private Double minimumCgpa;

    private LocalDate applicationDeadline;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Job() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredBranch() {
        return requiredBranch;
    }

    public void setRequiredBranch(String requiredBranch) {
        this.requiredBranch = requiredBranch;
    }

    public Double getMinimumCgpa() {
        return minimumCgpa;
    }

    public void setMinimumCgpa(Double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    public LocalDate getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(LocalDate applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
