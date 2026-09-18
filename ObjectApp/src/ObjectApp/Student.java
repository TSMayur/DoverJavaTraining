package ObjectApp;

public class Student{
	
private int rollNo;
private String name;
private int grade;
private String school;

public Student() {
	System.out.println("constructor called");
}
public Student(int rollNo) {
	this.rollNo=rollNo;
}
public Student(int rollNo,String name,int grade) {
	this.rollNo=rollNo;
	this.name=name;
	this.grade=grade;
}
public Student(int rollNo,String name) {
	this.rollNo=rollNo;
	this.name=name;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
@Override
public String toString() {
	return "Student [rollNo=" + rollNo + ", name=" + name + ", grade=" + grade + ", school=" + school + "]";
}


}