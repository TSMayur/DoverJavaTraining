package com.dovertraining.lmsdbapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dovertraining.lmsdbapp.dao.UserDao;
import com.dovertraining.lmsdbapp.models.User;
import com.dovertraining.lmsdbapp.utils.DatabaseConnection;

public class UserDaoImpl implements UserDao {
    private static final String INSERT_USER = "INSERT INTO `user` "
            + "(user_id, first_id, last_name, role_id, company_id) VALUES (?, ?, ?, ?, ?)";

    @Override
    public void save(User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER)) {

            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getRoleId());
            statement.setString(5, user.getCompanyId());
            statement.executeUpdate();
        }
    }
}
