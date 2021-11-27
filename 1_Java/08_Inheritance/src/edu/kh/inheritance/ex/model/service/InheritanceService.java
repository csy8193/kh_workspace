package edu.kh.inheritance.ex.model.service;

import edu.kh.inheritance.ex.model.vo.Person;
import edu.kh.inheritance.ex.model.vo.Student;

public class InheritanceService {
	
	public void example1() {
		// Person, Student 상속 확인
		
		// 1) Person 객체 생성
		Person p1 = new Person();
		p1.setName("홍길동");
		p1.setAge(20);
		p1.setNationality("대한민국");
		
		// 2) Student 객체 생성
		Student s1 = new Student();
		
		// * s1. 입력 후 상속 받은 부모의 setter/getter가 자동 완성 구문에 포함되어 있는지 확인
		s1.setName("헤르미온느");
		s1.setAge(15);
		s1.setNationality("영국");
		s1.setGrade(2);
		s1.setClassRoom(3);
		
		
		System.out.println( s1.getName() ); // 상속
		System.out.println( s1.getAge() ); // 상속
		System.out.println( s1.getNationality() ); // 상속
		System.out.println( s1.getGrade() );
		System.out.println( s1.getClassRoom() );
		
		
		// Object는 모든 클래스의 최상위 부모(조상)이다.
		// == 모든 클래스는 Object 클래스의 후손이다.
		
		p1.hashCode();
		// Person에는 hashCode()가 작성되지 않았지만 사용할 수 있다
		// == 상속 받은 Object의 hashCode()를 사용할 수 있다.
		
		s1.hashCode();
		
		
		Student s2 = new Student(3, 10, "고길동", 16, "대한민국");
		
		System.out.println("===== super() 생성자 확인 =====");
		System.out.println( s2.getName() );
		System.out.println( s2.getAge() );
		System.out.println( s2.getNationality() );
		
		
		System.out.println("===== super 참조변수 확인 =====");
		System.out.println(s2.information());
	}
	
	public void example2() {
		
		// 오버라이딩, 오버로딩 예제
		
		// 1. Object의 toString()을 오버라이딩 하기 전
		// edu.kh.inheritance.ex.model.vo.Person@139a55
		
		// 2. Object의 toString()을 오버라이딩 후
		// 홍길동 / 20 / 대한민국
		Person p1 = new Person("홍길동", 20, "대한민국");
		
		System.out.println(p1);
		// print 관련 구문 내에 참조변수를 작성하면 해당 객체의 toString()을 출력함
		
		Student s1 = new Student(3, 3, "안젤리나졸리", 19, "미국");
		
		System.out.println(s1);
	}
	
	public void example3() {
		// 상속 : 부모 클래스의 멤버(필드, 메소드)를
		//		 자식이 물려 받아 자식의 것처럼 사용하는 것
		
		// 상속 키워드 : extends (확장하다)
		// -> 자식의 멤버에 부모의 멤버가 추가되어 자식의 몸이 확장된느 것을 표현 (메모리구조 참고)
		
		// - 클래스간의 다중 상속 불가
		// - 모든 클래스는 Object 클래스의 후손
		//	+ Object 클래스 : 자바에서 모든 객체들이 가져야할
		//					공통적인 기능을 추상화를 통해 추출하여 모아둔 최상위 클래스
		
		
		Student s1 = new Student();
		
		System.out.println( s1.overridingTest() );
		// 오버라이딩된 자식의 메소드가 수행된다.
		
		
		
		// *** 오버라이딩, 오버로딩 차이점 잘 알아두기!
		
		// 오버로딩
		// - 같은 클래스 내에서 같은 이름의 메소드를 여러 개 정의하는 것
		
		// 오버로딩 성립 조건
		// - 메소드명 동일
		// - 
		
		System.out.println(s1.sum(10, 20));
		System.out.println(s1.sum(3.14, 2.12));
		
		// -> 메서드 호출 시 원하는 결과는 같으나
		//		매개변수의 타입, 개수, 순서에 따라 수행되는 코드가 달라져야 할 때
		//		오버로딩을 사용한다.
	}
}
