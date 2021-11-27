package edu.kh.poly.ex2.model.vo;

// 강아지, 고양이, 기린, 펭귄, 호랑이, 알파카, 코끼리, 곰, 돼지
// 뱀, 거미, 개미, 사람, 갈매기
public abstract class Animal {
	
	// 추상 클래스 (abstract class)
	// 1. 추상 메소드를 포함하고 있는 미완성된 클래스
	
	// 2. 미완성된 부분이 없어도 객체로 생성되서는 안되는 클래스
	
	
	// 필드
	private String type; // 종
	private String eatType; // 식성 (초식, 육식, 잡식)
	
	
	// 생성자 : 객체 생성 기능
	// * 추상 클래스는 직접적인 객체 생성은 불가능 하지만
	//	 상속 받은 자식 객체 내부에 생성될 수 있으므로 생성자 작성 가능
	//	 ( 자식 생성자 코드 내부 super() 생성자를 위함 )

	public Animal() {
		super();
	}
	
	public Animal(String type, String eatType) {
		super();
		this.type = type;
		this.eatType = eatType;
	}
	

	
	// 기능
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getEatType() {
		return eatType;
	}
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	
	// 동물이라면 모두 가지고 있는 기능이지만
	// 동물별로 수행하는 방법이 다른 기능
	public abstract void hunt(); // 미완성 메소드
	
	
	
}
