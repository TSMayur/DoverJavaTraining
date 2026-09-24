package com.dovertraining.lmsdbapp.parsers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.dovertraining.lmsdbapp.models.Student;

public class XmlStudentParser implements StudentParser {
    @Override
    public List<Student> parse(Path file) throws Exception {
        NodeList nodes = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(file.toFile()).getElementsByTagName("student");
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Element student = (Element) nodes.item(i);
            students.add(new Student(Integer.parseInt(student.getAttribute("id")),
                    text(student, "name"), text(student, "email"), text(student, "course")));
        }
        return students;
    }

    private String text(Element element, String tag) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }
}
