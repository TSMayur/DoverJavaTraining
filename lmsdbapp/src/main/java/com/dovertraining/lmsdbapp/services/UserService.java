package com.dovertraining.lmsdbapp.services;

import java.sql.SQLException;

import com.dovertraining.lmsdbapp.dao.UserDao;
import com.dovertraining.lmsdbapp.dao.impl.UserDaoImpl;
import com.dovertraining.lmsdbapp.models.User;

public class UserService {
    private final UserDao userDao = new UserDaoImpl();

    public void createUser(User user) throws SQLException {
        userDao.save(user);
    }
}
