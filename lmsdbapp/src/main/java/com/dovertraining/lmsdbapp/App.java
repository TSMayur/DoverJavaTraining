package com.dovertraining.lmsdbapp;

import com.dovertraining.lmsdbapp.services.CompanyService;
import com.dovertraining.lmsdbapp.services.impl.CompanyServiceImpl;

public class App {
    public static void main(String[] args) {
        CompanyService companyService = new CompanyServiceImpl();

        try {
            System.out.println("All companies:");
            companyService.getAllCompanies().forEach(System.out::println);
            System.out.println("Company CMP00001: "
                    + companyService.getCompanyById("CMP00001"));
        } catch (Exception exception) {
            System.out.println("Database operation failed: " + exception.getMessage());
        }
    }
}
