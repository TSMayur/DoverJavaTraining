package com.dovertraining.lmsdbapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.dovertraining.lmsdbapp.models.Student;

public interface StudentDao {
    int saveAll(List<Student> students) throws SQLException;
}
