package edu.kh.oop.field.ex2;

import edu.kh.oop.field.ex1.FieldTest1;

public class FieldTest3 extends FieldTest1 {
	
	
	public void example3() {
		
		// FieldTest1 �ν��Ͻ� ���� == ��ü ����
		FieldTest1 f1 = new FieldTest1();
		
		System.out.println( f1.test1 ); // + public
		
		// System.out.println( f1.test2 ); // #
		// -> protected : ���� ��Ű��, ��Ӱ����϶���
		
		System.out.println(test2); // ���
		
		// System.out.println( f1.test3 ); // ~
		// -> (default) : ���� ��Ű���϶���
		
		// System.out.println( f1.test4 ); // -
		// -> private : ���� ��ü�϶���
	}
}
