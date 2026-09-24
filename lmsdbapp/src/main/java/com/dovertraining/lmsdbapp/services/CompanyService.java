package com.dovertraining.lmsdbapp.services;

import java.sql.SQLException;
import java.util.List;

import com.dovertraining.lmsdbapp.models.Company;

public interface CompanyService {
    List<Company> getAllCompanies() throws SQLException;

    Company getCompanyById(String companyId) throws SQLException;

    int saveCompany(Company company) throws SQLException;

    int updateCompany(Company company) throws SQLException;

    int deleteCompany(String companyId) throws SQLException;
}
