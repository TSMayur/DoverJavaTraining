package com.dovertraining.lmsdbapp.parsers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.dovertraining.lmsdbapp.models.Student;

public class CsvStudentParser implements StudentParser {
    @Override
    public List<Student> parse(Path file) throws Exception {
        List<String> lines = Files.readAllLines(file);
        List<Student> students = new ArrayList<Student>();
        for (int i = 1; i < lines.size(); i++) {
            String[] value = lines.get(i).split(",", -1);
            students.add(new Student(Integer.parseInt(value[0]), value[1], value[2], value[3]));
        }
        return students;
    }
}
