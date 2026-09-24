package com.dovertraining.lmsdbapp.app;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudentSampleFilesApp {
    public static void main(String[] args) throws Exception {
        Path folder = Paths.get("C:", "dover_data");
        Files.createDirectories(folder);
        Files.write(folder.resolve("students.csv"), ("id,name,email,course\n"
                + "1,Ravi,ravi@example.com,Java\n2,Priya,priya@example.com,SQL\n3,Amit,amit@example.com,Spring\n")
                .getBytes(StandardCharsets.UTF_8));
        Files.write(folder.resolve("students.xml"), ("<students>\n"
                + "<student id=\"1\"><name>Ravi</name><email>ravi@example.com</email><course>Java</course></student>\n"
                + "<student id=\"2\"><name>Priya</name><email>priya@example.com</email><course>SQL</course></student>\n"
                + "<student id=\"3\"><name>Amit</name><email>amit@example.com</email><course>Spring</course></student>\n</students>\n")
                .getBytes(StandardCharsets.UTF_8));
        Files.write(folder.resolve("students.json"), ("[\n"
                + "{\"id\": 1, \"name\": \"Ravi\", \"email\": \"ravi@example.com\", \"course\": \"Java\"},\n"
                + "{\"id\": 2, \"name\": \"Priya\", \"email\": \"priya@example.com\", \"course\": \"SQL\"},\n"
                + "{\"id\": 3, \"name\": \"Amit\", \"email\": \"amit@example.com\", \"course\": \"Spring\"}\n]")
                .getBytes(StandardCharsets.UTF_8));
        System.out.println("Created students.csv, students.xml, and students.json in " + folder);
    }
}
