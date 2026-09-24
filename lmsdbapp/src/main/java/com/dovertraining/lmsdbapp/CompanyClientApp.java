package com.dovertraining.lmsdbapp;

import com.dovertraining.lmsdbapp.dao.CompanyDao;
import com.dovertraining.lmsdbapp.dao.impl.CompanyDaoImpl;
import com.dovertraining.lmsdbapp.models.Company;
import com.dovertraining.lmsdbapp.services.CompanyService;
import com.dovertraining.lmsdbapp.services.impl.CompanyServiceImpl;

public class CompanyClientApp {
    public static void main(String[] args) {
        CompanyDao companyDao = new CompanyDaoImpl();
        CompanyService companyService = new CompanyServiceImpl();
        String companyId = "CMP00099";

        try {
            System.out.println("--- DAO: Find All Companies ---");
            companyDao.findAll().forEach(System.out::println);

            System.out.println("\n--- Service: Find Company by ID ---");
            System.out.println(companyService.getCompanyById("CMP00001"));

            Company company = new Company(companyId, "Demo Company", "Created from client app");

            System.out.println("\n--- Service: Save Company ---");
            System.out.println("Rows inserted: " + companyService.saveCompany(company));

            Company updatedCompany = new Company(companyId, "Updated Demo Company", "Updated from client app");
            System.out.println("\n--- Service: Update Company ---");
            System.out.println("Rows updated: " + companyService.updateCompany(updatedCompany));

            System.out.println("\n--- DAO: Find Newly Created Company ---");
            System.out.println(companyDao.findById(companyId));

            System.out.println("\n--- Service: Delete Company ---");
            System.out.println("Rows deleted: " + companyService.deleteCompany(companyId));
        } catch (Exception exception) {
            System.out.println("Company operation failed: " + exception.getMessage());
        }
    }
}
