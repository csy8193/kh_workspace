package edu.kh.poly.ex2.model.service;

public class MyCalculator implements Calculator, Marker {
	// extends : Ŭ�������� ���, �������̽� ���� ���
	// 		   : �������̽� - Ŭ���� ��� ����
	
	// Ŭ�������� ���� ����� �Ұ���
	// �������̽� - Ŭ���� ���� ���� ����� ����
	
	@Override
	public int plus(int num1, int num2) {
		int sum = 0;
		sum = num1 + num2;
		return sum;
	}

	@Override
	public int minus(int num1, int num2) {
		int minus = 0;
		minus = num1 - num2;
		return minus;
	}

	@Override
	public int multiple(int num1, int num2) {
		return 0;
	}

	@Override
	public int divide(int num1, int num2) {
		return 0;
	}
	
	
}
