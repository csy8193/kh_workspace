package edu.kh.eh.model.vo;

import java.io.EOFException;
import java.io.IOException;

public class Child extends Parent{
	
	// 상속 받은 methodA 오버라이딩
	
	@Override
	public void methodA() throws EOFException {
		
		// 오버라이딩 시 예외처리 구문의 예외 범위는
		// 같거나 더 구체적이어야 한다.
	}
}
