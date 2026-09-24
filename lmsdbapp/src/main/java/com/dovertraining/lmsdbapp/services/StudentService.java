package com.dovertraining.lmsdbapp.services;

import java.sql.SQLException;
import java.util.List;

import com.dovertraining.lmsdbapp.models.Student;

public interface StudentService {
    int importStudents(List<Student> students) throws SQLException;
}
