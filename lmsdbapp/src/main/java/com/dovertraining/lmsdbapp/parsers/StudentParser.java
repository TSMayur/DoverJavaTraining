package com.dovertraining.lmsdbapp.parsers;

import java.nio.file.Path;
import java.util.List;

import com.dovertraining.lmsdbapp.models.Student;

public interface StudentParser {
    List<Student> parse(Path file) throws Exception;
}
