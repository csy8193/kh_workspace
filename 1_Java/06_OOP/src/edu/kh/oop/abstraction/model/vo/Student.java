package edu.kh.oop.abstraction.model.vo;

public class Student {
	// Ŭ������? ��ü�� Ư��(�Ӽ�, ���)�� ���� ���Ǹ� �ۼ��� ��
	// == ��ü�� ����� ���� ���赵
	
	// *** �߻�ȭ : �������� �κ��� �����ϰ�, ���ʿ��� �κ��� ����
	
	// �Ӽ� == �� == ������
	// �л��� ���� �� �ִ� �Ӽ� : �б���, �г�, ��, ��ȣ, �̸�, ��
	public String schoolName;
	public int grade;
	public int room;
	public int number;
	public String name;
	// int money;
	
	// ��� == ���� == ����
	// �л��� �� �� �ִ� ��� : �����ϱ�, �������
	public void study() {
		System.out.println("���õ� ������ �մϴ�.");
	}
	
	public void listeningLessons() {
		System.out.println(grade + "�г��� ������ ����ϴ�.");
	}
	
	public void introduce() {
		System.out.printf("���� %s�� �ٴϴ� %d�г� %d�� %d�� %s �Դϴ�\n", 
				schoolName, grade, room, number, name);
	}
}
