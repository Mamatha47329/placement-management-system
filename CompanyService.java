package com.pms.service;

import com.pms.entity.Company;
import com.pms.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {

        return companyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Company not found"));
    }

    public Company updateCompany(Long id,
                                 Company updatedCompany) {

        Company company = getCompanyById(id);

        company.setCompanyName(
                updatedCompany.getCompanyName());
        company.setLocation(
                updatedCompany.getLocation());
        company.setEligibilityCgpa(
                updatedCompany.getEligibilityCgpa());
        company.setPackageOffered(
                updatedCompany.getPackageOffered());
        company.setDescription(
                updatedCompany.getDescription());

        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
