package edu.kh.javatest.ex;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
	
	// 메인 메소드 : Java 프로젝트 실행 메소드
	public static void main(String[] args) {
		// public : 같은 프로젝트 내부 어디서든 접근 가능
		
		// 자바 메모리 영역
		// Stack : 호출된 메소드가 순서대로 쌓이는 영역
		// 		   메소드 안에 작성된 변수 == 지역변수
		//
		// Heap : 동적 메모리 영역
		// 		  프로그램 실행 중 new 연산자에 의해
		// 		  배열 또는 객체 등이 생성되고 사라지는 영역
		
		// Static : 정적 메모리 영역
		// 			프로그램 실행 시 static 키워드가 붙은 코드를
		// 			모두 메모리에 올리고, 프로그램 종료 시 까지 유지
		// 			어디서든 static에 작성된 코드를 호출할 수 있음
		
		System.out.println("print() 구문을 이용한 출력");
		
		int[] arr = new int[4];
		
		String[] arr2 = {"aaa", "bbb"};
		
		// 부모 타입 참조 변수로 자식 타입 객체를 참조할 수 있다
		// 객체 지향 언어의 특징 == 추상화, 캡슐화, 상속, 다형성
		
		// Collection의 List :
		// -> 타입, 크기 관계 없이 모두 저장
		// -> 인덱스 존재(순서 유지), 데이터 중복 허용
		
		// Generics(제네릭) : 컬렉션의 타입 제한을 걸어 사용이 용이
		List<String> list = new ArrayList<String>();
		
		// 리스트에 추가
		list.add("자바 너무 오랜만이에요");
		list.add("이렇게 말이 어려웠나요?");
		
		// 리스트에서 얻어오기
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		// 향상된 for문
		for(String s : list) {
			System.out.println(s);
		}
		
	}
}
