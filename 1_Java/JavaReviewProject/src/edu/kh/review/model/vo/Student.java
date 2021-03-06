package edu.kh.review.model.vo;

public class Student {
	
	private String studentId;
	private String studentName;
	private int studentGrade;
	private int studentClass;
	private char studentSex;
	
	public Student() {
		super();
	}
	
	public Student(String studentId, String studentName, int studentGrade, int studentClass, char studentSex) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentGrade = studentGrade;
		this.studentClass = studentClass;
		this.studentSex = studentSex;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	};
	
	public int getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}

	public char getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(char studentSex) {
		this.studentSex = studentSex;
	}

	@Override
	public String toString() {
		return studentId + " / " + studentName +" / "
	+studentGrade + " / " +studentClass + " / " + studentSex;
	}
	
}
