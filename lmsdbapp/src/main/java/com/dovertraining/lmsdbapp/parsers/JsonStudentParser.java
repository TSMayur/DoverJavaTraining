package com.dovertraining.lmsdbapp.parsers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dovertraining.lmsdbapp.models.Student;

public class JsonStudentParser implements StudentParser {
    private static final Pattern STUDENT = Pattern.compile(
            "\\{\\s*\\\"id\\\"\\s*:\\s*(\\d+),\\s*\\\"name\\\"\\s*:\\s*\\\"([^\\\"]+)\\\",\\s*"
            + "\\\"email\\\"\\s*:\\s*\\\"([^\\\"]+)\\\",\\s*\\\"course\\\"\\s*:\\s*\\\"([^\\\"]+)\\\"\\s*}");

    @Override
    public List<Student> parse(Path file) throws Exception {
        String json = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        Matcher matcher = STUDENT.matcher(json);
        List<Student> students = new ArrayList<Student>();
        while (matcher.find()) {
            students.add(new Student(Integer.parseInt(matcher.group(1)), matcher.group(2), matcher.group(3), matcher.group(4)));
        }
        return students;
    }
}
