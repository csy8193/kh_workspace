package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;
import edu.kh.poly.ex2.model.vo.Dog;

public class ExampleService {
	public void example1() {
		// 1) �߻�Ŭ������ �̿��� ��ü ����
		
//		Animal animal = new Animal();
		// Cannot instantiate the type Animal
		// -> ��üȭ �Ұ���. ��? �߻� Ŭ�����̱� ������
		
		
		// 2) �߻� Ŭ������ ��� �޾� ������ �Ϲ� Ŭ���� ��ü ����
		Dog dog = new Dog("��������", "���", 100);
		dog.hunt();
		
		
		// 3) �߻� Ŭ������ �θ� Ÿ�� ���� ������ ����� �� �ִ�.
		Animal animal = new Dog("��������", "���", 50); // ������ ��ĳ���� ����
		
		animal.hunt(); // ���� ���ε� : �̿ϼ� �޼ҵ�� �����
					   // ���� ���ε� : �������̵��� Dog�� hunt()�� �����
	}
	
	public void example2() {
		
		Marker[] arr = new Marker[3];
		
		arr[0] = new MyCalculator();
		arr[1] = new NewCalculator();
		arr[2] = new Test();
	}
}
