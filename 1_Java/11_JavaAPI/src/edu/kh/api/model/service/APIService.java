package edu.kh.api.model.service;

public class APIService {
	
	// Wrapper Ŭ����
	// - �⺻ �ڷ����� ��üȭ �����ִ� Ŭ����
	
	// �� ����ϴ°�?
	// 1) �⺻ �ڷ����� ���õ� Ư�� ��, ����� �����ϱ� ���Ͽ�
	
	// 2) �⺻ �ڷ����� �ٷ� �� ���� ��쿡 ����ϱ� ���Ͽ�
	//	  ex) �Ű������� Object�� ���, Collection�� ����ϱ� ���Ͽ� (Collection�� ��ü�� �����)
	
	
	/* Wrapper Ŭ������ java.lang ��Ű���� ����
	 * 
	 * 
	 * �⺻�ڷ���		Wrapper Class
	 * byte			Byte
	 * short		Short
	 * int			Integer
	 * long			Long
	 * float		Float
	 * double		Double
	 * boolean		Boolean
	 * char			Character
	 * 
	 * �⺻ �ڷ��� -> ��ü : ����(Boxing)
	 * ��ü -> �⺻ �ڷ��� : ���� Ǯ��(UnBoxing)
	 * 
	 *  * Wrapper Ŭ�������� ���� ���Ǵ� �ʵ�, �޼ҵ�� ��� static���� ����Ǿ� �ִ�!
	 *    -> ��ü ������ ���ص� Ŭ������.�ʵ� �������� ����� �� �ִ�.		
	 * 
	 * 
	 * */
	
	public void example1() {
		
		// Integer Wrapper Ŭ���� ���캸��
		System.out.println(  Integer.MAX_VALUE  ); // int �ִ밪
		System.out.println(  Integer.MIN_VALUE  ); // int �ּҰ�
		System.out.println(  Integer.BYTES      ); // int�� ����Ʈ ũ�� : 4
		System.out.println(  Integer.SIZE       ); // int�� ��Ʈ ũ�� : 32
		System.out.println(  Integer.TYPE       ); // � �⺻ �ڷ����� ������ ���ΰ� : int 
		
		// -> ��� Wrapper Ŭ�������� ������
	}
	
	
	public void example2() {
		
		// ���ڿ��� �Ǿ��ִ� ���ڸ� ���� �ڷ������� �����ϱ�
		
		// ex) "123" -> 123
		
		String str1 = "12345";
		
		System.out.println( str1 + 5 ); // 123455
		
		
		int num1 = Integer.parseInt(str1);
		// -> str1 ���ڿ��� int�����θ� �̷�����ִ��� �м��Ͽ�
		//	  int�θ� �̷���� �ִ� ��� int �ڷ������� ����ȯ�Ͽ� ��ȯ
		
		// parse : �м��ϴ�
		// parsing : ���� �м�, �������� ���� ��ü�� �ٲٴ� ��
		
		System.out.println( num1 + 5);
		
		
		
		// �ٸ� WrapperŬ������ parseXXX ����
		byte b = Byte.parseByte("1");
		short s = Short.parseShort("2");
		int i = Integer.parseInt("3");
		long l = Long.parseLong("4");
		float f = Float.parseFloat("0.1");
		double d = Double.parseDouble("0.2");
		boolean bool = Boolean.parseBoolean("true");
		
		// Character.parseCharacter()�� �������� ����!!
		// ��? ���ڿ��� ���ڷ� �ٲ� �� ���� ������....
		// -> ��� chatAt(index)�� �̿��Ͽ� ���ϴ� ���ڸ� �̾ƿ� �� �ִ�.
	}
	
	public void example3() {
		
		// Boxing
		Integer i1 = new Integer(100); // 100 �̶�� int�� Integer�� ����
		
		
		
		// UnBoxing
		int num1 = i1.intValue(); // i1 ��ü�� �ִ� int���� ��ȯ
		
		// * �������� Boxing / UnBoxing ����� �ڹٿ��� ��õ���� ����.
		// -> JDK 1.9 ���� ���� ���� ���� �ڵ�� ��ϵ�
		// --> �ڵ����� �����ϰ� Ǫ�� ���� �����ϰ� �ϴ� ����� ��Ÿ��!
		
		// AutoBoxing
		Integer i2 = 200; // Integer�ڷ��� = int�ڷ��� 
		
		// AutoUnBoxing
		int num2 = i2 + 100;
		// i2�� Integer������ int���� ������ ���� �ڵ����� ������ ������.
	}
}
