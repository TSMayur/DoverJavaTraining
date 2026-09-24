package com.dovertraining.lmsdbapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.dovertraining.lmsdbapp.models.Company;

public interface CompanyDao {
    List<Company> findAll() throws SQLException;

    Company findById(String companyId) throws SQLException;

    int save(Company company) throws SQLException;

    int update(Company company) throws SQLException;

    int delete(String companyId) throws SQLException;
}
