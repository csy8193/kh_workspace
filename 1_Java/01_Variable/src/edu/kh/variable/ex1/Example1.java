package edu.kh.variable.ex1;
// ���� class�� �ش� ��Ű�� �ȿ� ������ ���

public class Example1 {
	
	public static void main(String[] args) {
	//	���� �޼ҵ� : �ڹ� ���α׷��� ���� ��ų �� �ʿ�
		System.out.println(2 * 3.141592653589793 * 5);
		System.out.println(3.141592653589793 * 5 * 5);
		System.out.println(3.141592653589793 * 5 * 5 * 20);
		System.out.println(4 * 3.141592653589793 * 5 * 5);
		
		//	Run ����Ű : ctrl + f11
		
		System.out.println("-----------------------");
		
		// ������ �����Ͽ� ���
		double pi = 3.141592653589793; // ������
		int r = 5; // ������
		int h = 20; // ����
		
		System.out.println(2 * pi * r); // ���� �ѷ�
		System.out.println(pi * r * r); // ���� ����
		System.out.println(pi * r * r * h); // ������� ����
		System.out.println(4 * pi * r * r); // ���� �ѳ���
		
		// ������ ����
		// 1. �������� ��������. (������ ����)
		// 2. ������ �����ϴ�.
		// 3. �ڵ� ���̰� ª������. (�ڵ差 ����)
		// 4. ���������� ����
	}
}
