package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ο� �� : ");
		int input = sc.nextInt();
		System.out.print("���� ���� : ");
		int input2 = sc.nextInt();
		
		System.out.printf("1�δ� ���� ���� : %d\n", input2/input);
		System.out.printf("���� ���� ���� : %d", input2%input);
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String input = sc.next();
		System.out.print("�г� : ");
		int input2 = sc.nextInt();
		System.out.print("�� : ");
		int input3 = sc.nextInt();
		System.out.print("��ȣ : ");
		int input4 = sc.nextInt();
		System.out.print("���� : ");
		double input5 = sc.nextDouble();
		
		System.out.printf("%d�г� %d�� %d�� %s�� ������ %.2f�̴�.", input2, input3, input4, input, input5);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int input = sc.nextInt();
		System.out.print("���� : ");
		int input2 = sc.nextInt();
		System.out.print("���� : ");
		int input3 = sc.nextInt();
		
		int sum = input+input2+input3;
		System.out.printf("�հ� : %d\n", sum);
		System.out.printf("��� : %.1f", (double)(sum/3.0));
		
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է�1 : ");
		int input = sc.nextInt();
		System.out.print("�Է�2 : ");
		int input2 = sc.nextInt();
		System.out.print("�Է�3 : ");
		int input3 = sc.nextInt();
		
		String result = input == input2 && input2 == input3 ? "true" : "false";
		
		System.out.println(result);
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int input = sc.nextInt();
		
		String result = input <= 13 ? "���" : (input > 13 && input <= 19 ? "û�ҳ�" : "����");
		
		System.out.println(result);
		
		
	}
}
