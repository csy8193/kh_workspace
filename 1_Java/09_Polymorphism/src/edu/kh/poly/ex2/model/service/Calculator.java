package edu.kh.poly.ex2.model.service;

public interface Calculator {
	// �������̽�
	// - ����� �ʵ�� �߻� �޼ҵ常�� �ۼ��� �� �ִ�
	//	 �߻�Ŭ������ ����ü
	
	// �������̽� ��� ����
	// 1. �ϰ��� �������̽�(�۾�ȯ��)�� ����
	//	-> implements ������ �̿��� �������̽� ����� ����
	//	   ��� ���� ��� Ŭ�������� ������ �޼ҵ带 ���������� �������̵� �ϰ� ��.
	//	   == ��� ���� �ڽ� Ŭ������ �ϰ��� ����
	
	// 2. Ŭ�������� ������ ����� �������� �θ�, �ڽ� ���� ����
	
	// ���������� �޼ҵ�� public abstract
	
	
	/*public abstract*/ int plus(int num1, int num2);
	
	public abstract int minus(int num1, int num2);
	
	public abstract int multiple(int num1, int num2);
	
	public abstract int divide(int num1, int num2);
	
}
