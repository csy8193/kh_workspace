package edu.kh.oop.field.ex1;

public class FieldTest1 {
	
	// Field : Ŭ�������� ��ü�� �Ӽ��� �����ϴ� �κ�
	// [����������] [�����] [�ڷ���] ������ [=�ʱⰪ];
	
	// ����������
	// public(+) : ���, ���� ������Ʈ ����
	// protected(#) : ���� ��Ű�� �Ǵ� �ٸ� ��Ű�� ������ ��� ����
	// (default)(~) : ���� ��Ű�� ����
	// private(-) : ������, ���� ��ü ����
	
	
	public 	  String test1 = "+";
	protected String test2 = "#";
	/*(default)*/String test3 = "~";
	private   String test4 = "-";
	
	
	public void example1() {
		System.out.println( test1 );
		System.out.println( test2 );
		System.out.println( test3 );
		System.out.println( test4 );
	}
}
