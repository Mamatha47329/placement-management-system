package com.pms.controller;

import com.pms.entity.Company;
import com.pms.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public String companies(Model model) {

        model.addAttribute("companies",
                companyService.getAllCompanies());

        return "companies";
    }

    @GetMapping("/companies/add")
    public String addCompanyForm(Model model) {

        model.addAttribute("company",
                new Company());

        return "add-company";
    }

    @PostMapping("/companies/save")
    public String saveCompany(
            @ModelAttribute Company company) {

        companyService.saveCompany(company);

        return "redirect:/companies";
    }
}
