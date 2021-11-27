package edu.kh.variable.ex3;

public class PrintExample {
	
	public static void main(String[] args) {
		
		double dNum1 = 3.14;
		
		System.out.print("�ȳ��ϼ���");
		System.out.println(123);
		System.out.println(dNum1);
		
		// �ȳ��ϼ���123
		
		int iNum1 = 5;
		int iNum2 = 20;
		
		// �� ������ ���� ������ ���� ����Ͻÿ�.
		// 5 + 20 = 25
		
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1+iNum2) );
		
		// printf�� �̿��Ͽ� ����ϱ�
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1+iNum2);
		// printf -> f = format
		
		// System.out.printf("���� + ���ڿ�", ��);
		System.out.printf("%d x %d = %2d\n", 5, 1, 5*1);
		System.out.printf("%d x %d = %2d\n", 5, 2, 5*2);
		
		// %2d : ��µ� ������ 2ĭ�� Ȯ���ϰ� ������ ���ķ� 10���� ���
		// %-2d : ��µ� ������ 2ĭ�� Ȯ���ϰ� ���� ���ķ� 10���� ���
		
		
		// �Ҽ��� �Ʒ� ��°�ڸ����� ǥ���ϱ�
		System.out.println( 10 / 3.0 );
		
		// �Ҽ��� �Ʒ� ��°�ڸ����� ǥ��
		System.out.printf("%.2f\n", 10 / 3.0);
		
		// escape ����
		
		System.out.print("Hello\n");
		System.out.print("\tWorld");
		System.out.println(" \"apple\" "); // "apple"
		// -> ���ڿ� ���ͷ� ǥ��� : "" ���� �ۼ�
		// \" : ��ȣ�� �ƴ� ���� �״���� �ֵ���ǥ
		
		System.out.println("abc\\def"); //	abc\def
		//	\\ : "\" ���� �״�� ���
		
	}
}
