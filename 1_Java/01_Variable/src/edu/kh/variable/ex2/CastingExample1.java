package edu.kh.variable.ex2;

public class CastingExample1 {
	
	public static void main(String[] args) {
		
		// ����ȯ : ���� ������ �ٸ� �ڷ������� ������ ����Ǵ� ���
		// 		  ���� ������ ���߱����� �ڷ����� ��ȯ�ϴ� ��
		
		// �ڵ� ����ȯ
		// - ���� ������ ���� �ڷ����� ���� ������ ū �ڷ��� ���� ��
		//	 �����Ϸ��� �ڵ�����
		//	 ���� ������ ���� �ڷ����� 
		//	 ū �ڷ������� ��ȯ��Ű�� ��
		
		int a = 12;
		double d = 3.3;
		double result = a + d;
		
		// 12(int) + 3.3(double)
		// 12.0(double) + 3.3(double)
		// = 15.3(double)
		System.out.println("result : " + result);
		
		// int -> long �ڵ�����ȯ
		int iNum2 = 2147483647; // int �ִ밪
		long lNum2 = 10000000000l; // 100��
		
		long result2 = iNum2 + lNum2;
		System.out.println("resutl2 : " + result2);
		
		// float(4byte) -> double(8byte)
		float fNum3 = 1.23456f;
		double dNum3 = fNum3;
		// 1.23456f(float) -> 1.23456(double)
		
		// -> ���� ���굵 �����̱� ������ �ڷ����� ���ƾ� �Ѵ�

		
		// long(8byte) -> float(4byte)
		// float�� long ���� ũ��� ������
		// ���� ǥ���ϴ� ������ �ξ� ũ�� == �ڵ� ����ȯ ����
		long lNum4 = Long.MAX_VALUE; // long�� �ִ밪
		float fNum4 = lNum4;
		System.out.println("fNum4 : " + fNum4);
		
		
		// char(2byte) -> int(4byte)
		char ch5 = '��';
		int iNum5 = ch5;
		// ������ char�� ������ int�� �ڵ�����ȯ�� ������ ����?
		// -> ������ char�� �����δ� �ƽ�Ű�ڵ�, �����ڵ尰�� ǥ�� �ۼ���
		// 	  10���� ���ڿ� ���� ���� ����� ����ϴ� �ڷ����̴�.
		// ��� : char�� �ᱹ���� �������̴�
		
		System.out.println("iNum5 : " + iNum5);
		
	}
}
