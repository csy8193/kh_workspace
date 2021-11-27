package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.Student;

public class AbstractionService {
	
	public void example1() {
		
		// �л� ��ü�� ���� �б���, �г�, ��, ��ȣ, �̸��� �Է��ϰ�
		// ��� + ��� ����
		
		Student std = new Student(); // ��ü ����
		// �������� std
		
		// -> Heap ������ Student ��ü�� ���� �����ϰ�
		//	  �� ��ü�� ���� �� �� �ֵ���
		//	  ��ü ���� �ּҸ� std ������ ����
		std.schoolName = "KH����б�";
		std.grade = 3;
		std.room = 5;
		std.number = 10;
		std.name = "ȫ�浿";
		
		// -> new Student() �������� �߻�ȭ�� ��ü�� �����
		//	  ��ü�� �Ӽ��� �����ؼ� ��üȭ��Ŵ
		// (�߻�ȭ <-> ��üȭ)
		
		System.out.println("�̸� : " + std.name);
		System.out.println("�г� : " + std.grade);
		
		// ���� KH����б��� �ٴϴ� 3�г� 5�� 10�� ȫ�浿 �Դϴ�.
		System.out.printf("���� %s�� �ٴϴ� %d�г� %d�� %d�� %s �Դϴ�\n", 
				std.schoolName, std.grade, std.room, std.number, std.name);
		
		
		
		// �� �ٸ� �л� ����
		Student std2 = new Student();
		
		std2.schoolName = "KH����б�";
		std2.grade = 1;
		std2.room = 2;
		std2.number = 3;
		std2.name = "�迵��";
		
		System.out.printf("���� %s�� �ٴϴ� %d�г� %d�� %d�� %s �Դϴ�\n", 
				std2.schoolName, std2.grade, std2.room, std2.number, std2.name);
		
		std.study();
		std2.study();
		
		std.listeningLessons();
		std2.listeningLessons();
		
		
		std.introduce();
		std2.introduce();
	}
}
