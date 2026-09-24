package com.dovertraining.lmsdbapp.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.dovertraining.lmsdbapp.dao.StudentDao;
import com.dovertraining.lmsdbapp.dao.impl.StudentDaoImpl;
import com.dovertraining.lmsdbapp.models.Student;
import com.dovertraining.lmsdbapp.services.StudentService;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public int importStudents(List<Student> students) throws SQLException {
        return studentDao.saveAll(students);
    }
}
