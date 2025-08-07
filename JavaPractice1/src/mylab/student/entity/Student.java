package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student(String studentId,String name,String major,int grade) throws InvalidGradeException{
		setStudentId(studentId);
		setName(name);
		setMajor(major);
		setGrade(grade);

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) throws InvalidGradeException{
		if(grade > 4 || grade < 1) {
			throw new InvalidGradeException("�г��� 1~4 ���̿��� �մϴ�.");
		}
		this.grade = grade;
	}

}
