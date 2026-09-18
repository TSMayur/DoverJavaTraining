package ObjectApp;

public class ClientProgram {

    public static void main(String[] args) {

        Student student = new Student();

        student.setRollNo(10);
        student.setName("Arjun");
        student.setGrade(10);
        student.setSchool("ABC School");
        

        System.out.println("Roll No: " + student.getRollNo());
        System.out.println("Name: " + student.getName());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("School: " + student.getSchool());
        
        System.out.println("School: " + student.toString());
        System.out.println(student);
    }
}