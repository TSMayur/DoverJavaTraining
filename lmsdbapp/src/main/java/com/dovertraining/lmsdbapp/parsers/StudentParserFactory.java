package com.dovertraining.lmsdbapp.parsers;

import java.nio.file.Path;

public final class StudentParserFactory {
    private StudentParserFactory() {
    }

    public static StudentParser forFile(Path file) {
        String name = file.getFileName().toString().toLowerCase();
        if (name.endsWith(".csv")) return new CsvStudentParser();
        if (name.endsWith(".xml")) return new XmlStudentParser();
        if (name.endsWith(".json")) return new JsonStudentParser();
        throw new IllegalArgumentException("Use a CSV, XML, or JSON student file.");
    }
}
