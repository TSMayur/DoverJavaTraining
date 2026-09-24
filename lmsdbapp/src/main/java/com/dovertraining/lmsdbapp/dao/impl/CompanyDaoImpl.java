package com.dovertraining.lmsdbapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dovertraining.lmsdbapp.dao.CompanyDao;
import com.dovertraining.lmsdbapp.models.Company;
import com.dovertraining.lmsdbapp.utils.DatabaseConnection;

public class CompanyDaoImpl implements CompanyDao {
    private static final String INSERT = "INSERT INTO company "
            + "(company_id, company_name, description) VALUES (?, ?, ?)";
    private static final String FIND_ALL = "SELECT company_id, company_name, description FROM company";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE company_id = ?";
    private static final String UPDATE = "UPDATE company SET company_name = ?, description = ? WHERE company_id = ?";
    private static final String DELETE = "DELETE FROM company WHERE company_id = ?";

    @Override
    public List<Company> findAll() throws SQLException {
        List<Company> companies = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                companies.add(mapCompany(resultSet));
            }
        }
        return companies;
    }

    @Override
    public Company findById(String companyId) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {

            statement.setString(1, companyId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? mapCompany(resultSet) : null;
            }
        }
    }

    @Override
    public int save(Company company) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, company.getCompanyId());
            statement.setString(2, company.getCompanyName());
            statement.setString(3, company.getDescription());
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(Company company) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, company.getCompanyName());
            statement.setString(2, company.getDescription());
            statement.setString(3, company.getCompanyId());
            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(String companyId) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setString(1, companyId);
            return statement.executeUpdate();
        }
    }

    private Company mapCompany(ResultSet resultSet) throws SQLException {
        return new Company(
                resultSet.getString("company_id"),
                resultSet.getString("company_name"),
                resultSet.getString("description"));
    }
}
