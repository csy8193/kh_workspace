package edu.kh.variable.ex3;

import java.util.Scanner;

public class ScannerExample2 {
	public static void main(String[] args) {
		
		// ��ĳ�� ����
		Scanner sc = new Scanner(System.in);
		
		// ���� 2���� �Է� �޾� ���� ������ ������ ��
		// +, -, *, / �� ������� ���
		System.out.print("���� �Է�1 : ");
		int in1 = sc.nextInt();
		
		System.out.print("���� �Է�2 : ");
		int in2 = sc.nextInt();
		// ctrl + alt + ����Ű ��/�Ʒ� : �� �� ����
		
		System.out.println(); // ���ڿ��� ������� �ʰ� �ٸ� �ٲ�
		
		System.out.println("���");
		
		System.out.printf("%d + %d = %d\n", in1, in2, in1+in2);
		System.out.printf("%d - %d = %d\n", in1, in2, in1-in2);
		System.out.printf("%d * %d = %d\n", in1, in2, in1*in2);
		System.out.printf("%d / %d = %d", in1, in2, in1/in2);

	}
}
