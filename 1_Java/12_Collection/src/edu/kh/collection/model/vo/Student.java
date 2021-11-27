package edu.kh.collection.model.vo;

import java.util.Objects;

public class Student extends Person{
	// class��? ��ü�� ����� ���� ���赵 �ʵ�, �޼ҵ�(+������)�� �̷����
	
	// ���� ������
	// + public : ���� ������Ʈ ���� ��𼭵�
	// # protected : ���� ��Ű�� + ��� ����
	// ~ (default) : ���� ��Ű��
	// - private : ���� ��ü �������� ���� ����
	
	private String name;
	private int age;
	private int grade;
	// -> ĸ��ȭ ��Ģ�� ���ؼ� private���� ����
	
	// ������ : ��ü ���� �� ȣ��Ǵ� ������ �޼ҵ�
	//		   ��ü ���� + �ʱ�ȭ �뵵�� ���
	
	public Student() {	} // �⺻ ������
	
	// �Ű� ���� �ִ� ������
	// �Ű� ���� : ���� ���� ���� �����ϴ� ����
	public Student(String name, int age, int grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		
		// this ���� ���� : ���� ��ü�� �����ּҸ� �����ϴ� ���� ����
		// == ��ü �ڽ��� ������.
		
	}
	
	public Student(char gender, double height, String name, int age, int grade) {
		super(gender, height);
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	// getter / setter : ĸ��ȭ�� ���� ���� ������ ���ܵ� �ʵ忡 ���� ���� ���� ���
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}
	
	
	// �����ε� : ���� �̸��� �޼ҵ带 ���� �� �ۼ��ϴ� ���
	// �������̵� : ��� ���� �޼ҵ带 �ڽ� Ŭ�������� ������
	
	// toString() : Object Ŭ������ �޼ҵ�� �ʵ� ������ �ϳ��� ���ڿ��� ��ȯ�ϴ� �뵵��
	//				�������̵� �Ͽ� ����ϴ� �޼ҵ�
	@Override
	public String toString() {
		return name + " / " + age + " / " + grade + " / " + super.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, grade, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && grade == other.grade && Objects.equals(name, other.name);
	}
	
	// alt + [ shift ] + s -> generate hashcode and equals...
	
	
	// Object.equals() �޼ҵ�
	// -> ��� �޾� �������̵� �ϴ� �뵵�� �޼ҵ�
	// -> �� ��ü�� ���� ���� ���� ������ �ִ��� ���ϴ� �ڵ�� �������̵�
	// --> ���� ��ü�� �Ű������� ���� ��ü�� �ʵ� ���� ��� ������
	//	   ���� ��ü(true)��� ����� ��ȯ�ϵ��� �������̵� �ؾߵȴ�
	
//	@Override
//	public boolean equals(Object obj) {
//							// Student
//		
//		
//		// �Ű������� ���� ���� ��ü �ٿ� ĳ����
//		Student other = (Student)obj;
//		
//		return this.name.equals(other.name) && 
//				this.age == other.age		&&
//				this.grade == other.grade;
//		
//		
//	}
//	
//	
//	// Object.hashCode()
//	// -> ������ ��ü( equals() ����� true�� �� ��ü )��
//	//	  ������ hashCode() ���� ��ȯ�ؾ� �Ѵ�.
//	
//	// == equals()�� �������̵� �ϴ� ��� hashCode()�� �������̵� �ؾߵǸ�
//	//    equals()�� true�� �� ��ü�� hashCode()�� ���� ���� ������ �Ѵ�.
//	
//	// ex) �̸�, ����, �ܸ� ���� �ֵ��̴� ���� ���� ��ƾ� �ȴ�.
//	
//	@Override
//	public int hashCode() {
//		// ���� ���� ��ü�� hashCode���� ���ƾ� �ȴ�
//		// ==> ���� �̿��ؼ� hashCode�� ����� �����ϴ�
//		
//		final int PRIME = 31; // 31�̶�� �Ҽ��� ���� �ӵ��� ����
//		
//		int result = 1; // ��� ���� ����
//		
//		result = result * PRIME + (name == null ? 0 : name.hashCode());
//		
//		result = result * PRIME + age;
//		
//		result = result * PRIME + grade;
//		
//		return result;
//	}
	
	
	
	
}
