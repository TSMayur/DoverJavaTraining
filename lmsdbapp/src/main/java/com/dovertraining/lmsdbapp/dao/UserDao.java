package com.dovertraining.lmsdbapp.dao;

import java.sql.SQLException;

import com.dovertraining.lmsdbapp.models.User;

public interface UserDao {
    void save(User user) throws SQLException;
}
