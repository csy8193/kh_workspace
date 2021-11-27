package edu.kh.poly.ex2.model.service;

public class MyCalculator implements Calculator, Marker {
	// extends : 클래스간의 상속, 인터페이스 간의 상속
	// 		   : 인터페이스 - 클래스 상속 관계
	
	// 클래스간의 다중 상속은 불가능
	// 인터페이스 - 클래스 간의 다중 상속은 가능
	
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
