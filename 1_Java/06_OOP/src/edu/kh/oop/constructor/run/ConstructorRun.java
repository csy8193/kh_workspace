package edu.kh.oop.constructor.run;

import edu.kh.oop.constructor.model.service.ConstructorService;

public class ConstructorRun {
	
	public static void main(String[] args) {
		
		ConstructorService service = new ConstructorService();
		
		// ConstructorService�� �⺻ �����ڸ� �ۼ����� �ʾ�����
		// ���� ���� ����� �� �ִ�!
		// ��? �����Ϸ��� �⺻ �����ڸ� �ڵ����� �߰� ���ִϱ�!
		service.example1();
	}
}
