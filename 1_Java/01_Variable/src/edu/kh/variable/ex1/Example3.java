package edu.kh.variable.ex1;

public class Example3 {
	
	public static void main(String[] args) {

		// ctrl + d : �� �� ����
		// ctrl + / : �� �� �ּ�
		// ��� ���� -> ctrl + / : ��� ������ ���� �ּ�
		// ��� ���� -> ctrl + shift + / : ��� ��ŭ ���� �ּ�
		
		// ���ڿ��� �ٸ� �ڷ���
		String str = "Hello";
		String str2 = "World";
		
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(str + str2); // HelloWorld
		// ���ڿ� + ���ڿ� = �� ���ڿ� �̾�����
		
		System.out.println(num1 + num2); // 30
		// ���� + ���� = �� ������ ��
		
		// ��� : �������� �ڷ����� ���� + ��ȣ�� ������ �޶�����
		// 1)��, 2)�̾��
		
		
		// ���ڿ� + ���� = �̾��
		System.out.println(str + num1);
		
		// ���� + ���ڿ� = �̾��
		System.out.println(num1 + str);
		
		// ���ڿ� + ���� + ���� = �̾��
		System.out.println(str + (num1+ num2));
		
		// ���� + ���� + ���ڿ� = �������� ���ϰ� ���ڿ��� �̾����.
		// -> + ������ �����Ǿ� �ִ� ��� �տ��� ���� ������� ������ �����.
		System.out.println(num1 + num2 + str);
		
		// ���� + ���ڿ� + ����
		System.out.println(num2 + str2 + num1);
		
		
		// �߰� ��� : ���ڿ� + �ٸ� �ڷ��� -> �̾��, �������� ��
		
		
	}

}
