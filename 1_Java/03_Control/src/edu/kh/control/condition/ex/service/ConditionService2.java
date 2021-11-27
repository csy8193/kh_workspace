package edu.kh.control.condition.ex.service;

import java.util.Scanner;

public class ConditionService2 {
	
	// switch��
	// - �� �ϳ��� ���� ����� ���� ó�� �� �� ����ϴ� ���ǹ�
	// - ���� ������� ��ġ�ϴ� case���� �����.
	
//	switch(��) {
//	case �����1: �����ڵ�1; break;
//	case �����2: �����ڵ�2; break;
//	case �����3: �����ڵ�3; break;
//	...
//	default : case�� �������� ���� ����� �ڵ�;
//	}
	
	public void example1() {
		// Ű����� ������ �Է� �޾�
		// 3�� ��� : ������
		// 4�� ��� : �Ķ���
		// 5�� ��� : �����	���
		// ������ ��� : ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է� : ");
		int input = sc.nextInt();
		
		String color;
		
//		switch(input) {
//		case 3 : color = "������";	break;
//		case 4 : color = "�Ķ���";	break;
//		case 5 : color = "�����";	break;
//		default : color = "���";
//		}
		if (input == 3) {
			color = "������";
			
		}else if (input == 4) {
			color = "�Ķ���";
			
		}else if (input == 5) {
			color = "�����";
			
		}else {
			color = "���";
			
		}
		
		System.out.println(color);
		
	}
	
	public void example2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		String team;
		
		switch(input % 4) { // 0, 1, 2, 3
		case 1 : team = "�ѽ���";		break;
		case 2 : team = "�Ͻ���";		break;
		case 3 : team = "�߽���";		break;
		default  : team = "�����";
		}
		
		System.out.println(team);
	}
	
	public void example3() {
		
		// ��(��) �� �Է� �޾� �ش� ���� ������ ���
		// ��, 1~12���̰� �ƴ� ��� "�߸� �Է��ϼ̽��ϴ�" ���
		// (switch�� ���)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��(��) �Է� : ");
		int month = sc.nextInt();
		
		String result;
		
		switch(month) {
		case 3 : case 4 : case 5 : result = "��";		break;
		case 6 : case 7 : case 8 : result = "����";		break;
		case 9 : case 10 : case 11 : result = "����";		break;
		case 12 : case 1 : case 2 : result = "�ܿ�";		break;
		default : result = "�߸� �Է��ϼ̽��ϴ�";
		}
		
		System.out.println(result);
	}
	
	public void example4() {
		// ���� 2���� �����ڸ� �Է� �޾� �˸��� ����� ���
		
		// ���ȭ��)
		// ���� �Է�1 : 10
		// ���� �Է�2 : 20
		// ������ �Է� : +
		// ��� : 10 + 20 = 30
		
		// + �߰����� : ���� �Է�2�� 0�̰� �����ڰ� /(������)�� ���
		// 0���� ���� �� �����ϴ� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է�1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("���� �Է�1 : ");
		int num2 = sc.nextInt();
		
		System.out.print("������ �Է� : ");
		char op = sc.next().charAt(0);
			// ��ĳ�ʿ� nextChar() ��� ����� �������� ����.
			// * String���� Ư�� ��ġ�� �ִ� ���� �ϳ��� ��ȯ�ϴ� ���(�޼ҵ�)
			//	--> String.charAt(index);	(index == ��ġ)
		
			// �Է� ���� ���ڿ����� 0��° ��ġ�� �ִ� ���ڸ� ���� op ������ ����
		
		int result = 0;		// �� ���� ���� ��� ����� ����
		
		boolean flag = true; // ����� �������, ������ �����ϴ� ����
		
		switch(op) {
		case '+' : result = num1 + num2; break;
		case '-' : result = num1 - num2; break;
		case '*' : result = num1 * num2; break;
		case '/' : 
			if (num2 == 0) {
				System.out.println("0���� ���� �� �����ϴ�.");
				flag = false;
				
			}else {
				result = num1 / num2;

			}
			break;
		case '%' : result = num1 % num2; break;
		default : 
			System.out.println("�ش� �����ڴ� �������� �ʽ��ϴ�.");
			flag = false;
		}
		
//		if (!(num2 == 0 && op == '/')) {
//			System.out.printf("%d %c %d = %d\n", num1, op, num2, result);	
//		}
		if (flag) {
			System.out.printf("%d %c %d = %d\n", num1, op, num2, result);				
		}
	}
}
