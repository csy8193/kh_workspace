package edu.kh.variable.ex3;

// import : �ܺ� Ŭ������ ���ͼ� �ش� Ŭ���� ���ο��� ��� �����ϰ� ��.
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		
		// ��ĳ�� ����
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� : ");
		
		// ��ĳ�ʸ� ���ؼ� �Է¹��� ���ڿ��� input ������ ����
//		String input = sc.next();
//		String input2 = sc.next();
//		
//		System.out.println("�Է� ���� ���ڿ� : " + input);
//		System.out.println("�Է� ���� ���ڿ�2 : " + input2);
		
		String input3 = sc.nextLine(); // ���� ���� �� �� �Է� �ޱ�
		
		System.out.println("�Է� ���� ���ڿ�3 : " + input3);

	}
}
