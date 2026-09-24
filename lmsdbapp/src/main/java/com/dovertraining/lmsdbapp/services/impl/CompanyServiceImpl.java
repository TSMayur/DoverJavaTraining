package com.dovertraining.lmsdbapp.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.dovertraining.lmsdbapp.dao.CompanyDao;
import com.dovertraining.lmsdbapp.dao.impl.CompanyDaoImpl;
import com.dovertraining.lmsdbapp.models.Company;
import com.dovertraining.lmsdbapp.services.CompanyService;

public class CompanyServiceImpl implements CompanyService {
    private final CompanyDao companyDao = new CompanyDaoImpl();

    @Override
    public List<Company> getAllCompanies() throws SQLException {
        return companyDao.findAll();
    }

    @Override
    public Company getCompanyById(String companyId) throws SQLException {
        return companyDao.findById(companyId);
    }

    @Override
    public int saveCompany(Company company) throws SQLException {
        return companyDao.save(company);
    }

    @Override
    public int updateCompany(Company company) throws SQLException {
        return companyDao.update(company);
    }

    @Override
    public int deleteCompany(String companyId) throws SQLException {
        return companyDao.delete(companyId);
    }
}
