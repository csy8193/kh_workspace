package edu.kh.eh.model.exception;

public class DivideByTwoException extends Exception {
	
	// ����� ���� ���ܸ� ����� ���
	// -�ƹ� Exception Ŭ������ ��� ������ �ȴ�!
	
	// 1) UnCheckedException�̰� ������
	//	-> RuntimeException �Ǵ� �� �ļ� Ŭ����
	
	// 2) CheckedException�̰� ������
	//	-> RuntimeException ������ ������
	
	
	// ���ܰ� �߻��ߴ�
	// == new ����Ŭ����() �� ����Ǿ� ���� ��ü�� �����Ǿ���.
	// -> ��ü ������ ���ؼ��� �����ڰ� �־�� �Ѵ�.
	// --> ����� ���� ���ܿ��� �����ڸ� �ۼ��ؾ� �Ѵ�.
	
	
	public DivideByTwoException() {
		super("2�� ���� �� �����ϴ�.");	// ���� �߻��� �ۼ��Ǵ� ����
		
	}
	
	public DivideByTwoException(String message) {
		super(message); // ����Ϸ��� ���� ������ �Ű������� ���� ������ ����
		
	}
	
	
}
