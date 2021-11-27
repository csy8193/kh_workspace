package edu.kh.eh.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.eh.model.exception.DivideByTwoException;

public class ExeptionService {
	
	// ����(Exeption) : �ҽ� �ڵ��� �������� �ذ� ������ ����
	
	public void example1() {
		
		// 1. try - catch
		
		// try : ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 ���ο� �ۼ��ؼ� �õ��ϴ� �κ�
		
		// catch : try ���� �ȿ��� �߻��� ���ܸ� ��Ƽ� ó���ϴ� �κ�.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ������ �Է� �޾� ������ �� �� ���ϱ�");
		// �Է� 1 : 4
		// �Է� 2 : 2
		// 4 / 2 = 2
		
		System.out.print("�Է� 1 : ");
		int num1 = sc.nextInt();
		System.out.print("�Է� 2 : ");
		int num2 = sc.nextInt();
		
		/*try {
			
			System.out.printf("%d / %d = %d\n", num1, num2, num1/num2);
			
		}catch(ArithmeticException e) {
			// try �������� �߻��� ���� �� catch�� ���ܸ� �Ű������� �ۼ�
			System.out.println("0���� ���� �� �����ϴ�.");
			
			
			// ArithmeticException : ��� ����
			// -> 0���� �����⸦ �����ϴ� ��� ���� �߻���.
		}*/
		
		if(num2 ==0) {
			System.out.println("0���� ���� �� �����ϴ�");
		}else {
			System.out.printf("%d / %d = %d\n", num1, num2, num1/num2);
		}
		// -> try-catch ������ ������� �ʾƵ� ����ó���� ������ ��Ȳ
		
		// -> ArithmeticException ó�� if���� ���� ������ ���� �߻��� ������ �� �ִ� ���ܵ��� �ִ�.
		//    --> �� ����ó�� (try-catch)�� �� �ʿ䰡 ����.
		//    --> UncheckedException (�� ���� ó�� �������� Ȯ���� �ʿ� ����)
		
	}
	
	public void example2() {
		
		// ���� �ΰ��� �Է� �޾� �� ������ ���� ����ϴ� �޼ҵ�
		
		// ��, ������ �Է� �޴� �޼ҵ�� ������ �ۼ�
		int num1 = inputNumber(1);
		int num2 = inputNumber(2);
		
		System.out.printf("%d x %d = %d", num1, num2, num1*num2);
		
	}
	
	
	
	public int inputNumber(int i) {
						// i == ����
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		while(true) {
			
			System.out.print(i + "��° ���� �Է� : ");
			
			try {
				num = sc.nextInt(); // ���� ������ �Է� �޾� ���;� ������
									// �Ǽ� �Ǵ� �ٸ� �ڷ����� �Է����� ��
									// inputMismatchException �߻��Ѵ�.
				break;
			}catch (InputMismatchException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine(); // �Է� ���ۿ� �����ִ� �߸� �Էµ� ������ ���ͼ�
							   // �Է� ���۸� ������ �Ͽ� ���� �����Է� �� ������ �߻����� �ʵ��� ��.
				
			}
		}
		
		return num;
	}
	
	
	public void example3() {
		
		// finally : try-catch ���� �� �������� ������ �����ϴ� �ڵ带 �ۼ��ϴ� �κ�
		
		
		String str = null;
		// null : �ƹ��͵� �������� ����. (��� �ִ� X)
		str = "abc";
		try {
			System.out.println( str.length() );
			// NullPointerException : null ���� ����
			// -> ���� ������ �����ϴ� ��ü�� ������ �ǹ�
			
		}catch (NullPointerException e) {
			System.out.println("��ü�� �����ϰ� ���� �ʽ��ϴ�.");
			
		}finally {
			System.out.println("������ ����Ǵ� �ڵ�");
			
		}
	}
	
	
	public void example4() {
		// throw : ���� ���� �߻� ���� (���ܸ� ����)
		
		// throw new NullPointerException();
		// -> UnCheckedException : �ݵ�� ����ó�� �� �ʿ䰡 ����
		
		// throw new IOException();
		// -> CheckedException : �ݵ�� ����ó���� �ؾ���
		// - if������ �ذ� �Ұ�
		// - ���� ��Ȳ�� �߻��� �� �ִ� ��찡 ���� ��
		
		BufferedReader br = null;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		// Ű����� ���� ���ڿ� �Է� �ޱ����� ��ü ����
		// (Scanner ���� ������ ����ϴ� �Է� ���, �ӵ��� �� ����)
		
		System.out.print("���ڿ� �Է� : ");
		
		try {
			String str = br.readLine(); // �Էµ� ���ڿ��� ���� str�� ����
										// IOException�� �߻���ų ���ɼ��� �ִ�.
										// -> try-catch�� ó��
			System.out.println(str);
		}catch(IOException e) {
			System.out.println("���� �߻�");
		}
		
		
		// shift + f2 -> JAVA API ���� ���������� �˻�
	}
	
	public void example5() {
		
		// �� ������ �Է� �޾� ���� �� ���
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("�Է� 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("�Է� 2 : ");
			int num2 = sc.nextInt();
			
			System.out.printf("%d / %d = %d\n", num1, num2, num1/num2);
			
			
		}catch(InputMismatchException e) {
			System.out.println("������ �Է����ּ���.");
			
		}catch(ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
			
		}catch(Exception e) {
			// Exception : ��� ������ �ֻ��� �θ�
			
			// �Ű������� �������� ����Ǿ� �տ��� ó������ ���� ��� ���ܸ�
			// ó���� �� �ִ�.
			System.out.println("���� �𸣰����� ���ܰ� �߻���");
			
			e.printStackTrace();
			// -> � ���ܰ� �߻��߰�
			//	  �� ���ܰ� �߻��ϱ� ���� ȣ��� ��� �޼ҵ带 ������� ���
		}
		// ���� ó�� �� catch���� ������ �ۼ��� �� �ִ�.
		// try �������� ���� �߻� �� catch���� ������ �Ʒ��� ���ʴ�� ��������
		// �˸��� catch������ ó���ȴ�.
		
		// �߻��ϴ� ���ܿ� ���� ���������� ó�� �� �� �ִ�.
		
		// catch���� ���� �� �ۼ��ϴ� ���
		// ó���Ϸ��� ������ ��� ���踦 �ľ��Ͽ�
		// �θ� �Ʒ��ʿ��� ó���ϰ� �ؾ��Ѵ�.
	}
	
	public void example6() {
		// methodA, methodB ���� �߻��ϴ� ���ܸ� ��Ƽ� ó��
		
		try {
			methodA();
			
		}catch(IOException e) {
			System.out.println("���� ó����");
		}
		
		
	}
	
	public void methodA() throws IOException{
		
		methodB();
		
	}
	
	public void methodB() throws IOException{
		
		throw new IOException();
		// IOException ���� ���� �߻�
		
	}
	
	
	public void example7() {
		
		try {
			divide(10, 2);
		}catch(DivideByTwoException e) {
			System.out.println("2�� ���� �� �����ϴ�.");
			e.printStackTrace();
		}
		
	}
	
	public void divide(int num1, int num2) throws DivideByTwoException {
		
		if(num2 != 2) {
			System.out.println(num1/num2);
		}else {
			// num2�� 2�� ��� ���� ���� �߻�
			throw new DivideByTwoException("2�� ������");
		}
		
	}
}
