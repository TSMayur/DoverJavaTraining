package com.dovertraining.lmsdbapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dovertraining.lmsdbapp.dao.StudentDao;
import com.dovertraining.lmsdbapp.models.Student;
import com.dovertraining.lmsdbapp.utils.DatabaseConnection;

public class StudentDaoImpl implements StudentDao {
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS students ("
            + "student_id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100), course VARCHAR(100))";
    private static final String INSERT = "INSERT INTO students (student_id, name, email, course) VALUES (?, ?, ?, ?) "
            + "ON DUPLICATE KEY UPDATE name=VALUES(name), email=VALUES(email), course=VALUES(course)";

    @Override
    public int saveAll(List<Student> students) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement create = connection.prepareStatement(CREATE_TABLE);
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            create.execute();
            for (Student student : students) {
                statement.setInt(1, student.getId());
                statement.setString(2, student.getName());
                statement.setString(3, student.getEmail());
                statement.setString(4, student.getCourse());
                statement.addBatch();
            }
            return statement.executeBatch().length;
        }
    }
}
