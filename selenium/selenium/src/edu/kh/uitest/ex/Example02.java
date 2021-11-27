package edu.kh.uitest.ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


// WebElement : 웹 요소를 저장하는 객체

// driver.findElement(지정방식("찾을 요소")) : 얻어온 화면에서 요소 1개 찾기

// (지정방식) -> By.id("아이디 속성값") : id로 찾기

// 요소.sendKeys("값") : 요소에 값 전달(input태그 값 작성)
// 요소.click() : 요소 클릭
// 요소.submit() : 현재 요소가 표함된 form태그 제출(submit) 이벤트 발생

public class Example02 {
	public static void main(String[] args) {
		
		// 웹 드라이버 위치 지정
		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");
		
		// 연결된 드라이버를 제어하는 객체 생성
		WebDriver driver = new ChromeDriver(); // 브라우저가 열림
		
		// 네이버 홈페이지 화면 얻어오기
		// == 이동하기
		driver.get("https://www.naver.com");
		
		
		// 검색창을 나타내는 요소를 얻어옴
		// -> 원하는 요소를 지정된 방식으로 찾아서 얻어옴
		
		// driver.findElement(지정된 방식("찾을 요소")) : 얻어온 화면에서 요소 1개 찾기
		
		// By.id("id속성값") : 아이디를 이용해서 찾겠다(지정방식)
		WebElement inputSearch = driver.findElement(By.id("query"));
		
		System.out.println(inputSearch);
		
		// 찾은 검색창 요소에 "KH정보교육원" 값을 전달
		inputSearch.sendKeys("kh정보교육원");
		
		// 검색 버튼 요소를 찾아서 얻어오기
		// WebElement searchBtn = driver.findElement(By.id("search_btn"));
		// 네이버 검색 버튼 아이디 : search_btn
		
		// searchBtn.click();
		
		// 제출 동작 수행
		inputSearch.submit();
		
		
		
		
		
		
		
//		driver.close();
	}
}
