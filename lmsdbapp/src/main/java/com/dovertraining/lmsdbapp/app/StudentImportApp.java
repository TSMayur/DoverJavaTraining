package com.dovertraining.lmsdbapp.app;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.dovertraining.lmsdbapp.models.Student;
import com.dovertraining.lmsdbapp.parsers.StudentParser;
import com.dovertraining.lmsdbapp.parsers.StudentParserFactory;
import com.dovertraining.lmsdbapp.services.StudentService;
import com.dovertraining.lmsdbapp.services.impl.StudentServiceImpl;

public class StudentImportApp {
    public static void main(String[] args) {
        Path file = args.length > 0 ? Paths.get(args[0]) : Paths.get("C:", "dover_data", "students.csv");

        try {
            StudentParser parser = StudentParserFactory.forFile(file);
            List<Student> students = parser.parse(file);
            StudentService service = new StudentServiceImpl();
            System.out.println("Rows imported: " + service.importStudents(students));
            students.forEach(System.out::println);
        } catch (Exception exception) {
            System.out.println("Student import failed: " + exception.getMessage());
        }
    }
}
