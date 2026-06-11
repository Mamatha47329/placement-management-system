package com.pms.controller;

import com.pms.entity.Job;
import com.pms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public String jobs(Model model) {

        model.addAttribute("jobs",
                jobService.getAllJobs());

        return "jobs";
    }

    @GetMapping("/jobs/add")
    public String addJob(Model model) {

        model.addAttribute("job",
                new Job());

        return "add-job";
    }

    @PostMapping("/jobs/save")
    public String saveJob(
            @ModelAttribute Job job) {

        jobService.saveJob(job);

        return "redirect:/jobs";
    }
}
