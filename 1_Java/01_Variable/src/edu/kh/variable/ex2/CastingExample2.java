package edu.kh.variable.ex2;

public class CastingExample2 {
	
	public static void main(String[] args) {
		
		// ���� ����ȯ
		// - ���� ������ ū �ڷ����� ���� ������ ���� �ڷ�������
		// 	 ������ ��ȯ�ϴ� ��.
		// - ū �����͸� ������ �߶� ��ȯ�ϴ� �ڷ����� �־��ֱ� ������
		//	 ������ �ս��� �߻� �� �� �ִ�.
		
		int iNum = 290;
		byte bNum = (byte)iNum; // iNum�� byte�� ���� ����ȯ
		// byte�� ���� ������ -128 ~ 127
		// �� ū ���� 290�� ���� �Ǿ����Ƿ� ������ �ս��� �߻���.
		
		System.out.println("bNum : " + bNum);
		
		
		// ���� ����ȯ Ȱ�� 1�� - �Ҽ��� �Ʒ� ���� ó��
		double height = 169.5;
		int iNum2 = (int)height;
		
		System.out.println("iNum2 : " + iNum2);
		
		// ���� ����ȯ Ȱ�� 2�� - Ư�� ������ � ���ڸ� ��Ÿ������ Ȯ��
		// int -> char
		int iNum3 = 75;
		System.out.println((char)iNum3);
		
		char ch = 'a';
		System.out.println((char)(ch + 5));
		
		char ch2 = 'a' + 5;
		// ���� ����ȯ�� ��������� �̸� �����ϴ� Ư���� ���
		// -> char �ڷ��� ���� ����� ���ÿ� �ʱ�ȭ�� �ϴ� ���
		// 	  �ʱ�ȭ �Ǵ� ���� int �ڷ����̶� �ڵ����� char�� �νĵ�
		
		
		// ������ �����÷ο�
		// -> �ڵ� �� ���� �� ����� ���� ������ �ʰ��ϴ� ��� �߻�
		// -> �����Ϸ��� ������ �������� ����
		//	  ��ȹ, ���� �ܰ迡�� ������ �ؾ߸� �Ѵ�.
		
		int view1 = Integer.MAX_VALUE; // int �ִ밪
					// 2147483647
		System.out.println("view1 : " + (view1 + 1));
	}
}
