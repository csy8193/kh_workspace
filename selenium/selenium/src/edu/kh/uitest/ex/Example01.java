package edu.kh.uitest.ex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example01 {
	public static void main(String[] args) {
		
		// 웹 드라이버(크롬 드라이버) 위치 지정
		System.setProperty("webdriver.chrome.driver", 
						  "C:/tools/selenium/chromedriver.exe");
		
		// 연결된 웹 드라이버를 제어하는 객체 생성
		// -> 동시에 크롬 브라우저 열림
		WebDriver driver = new ChromeDriver();
		
		// 해당 주소로 이동
		// (해당 주소로 이동하여 화면을 얻어옴)
		driver.get("https://www.naver.com");
		
		// driver.getPageSource() : 현재 화면의 코드를 얻어옴
		System.out.println(driver.getPageSource());
		
//		driver.close(); // 브라우저 닫기
		// 보통 필수로 작성하나
		// 현재 공부중이고, 확인 작업이 필요하니 주석 처리
		
	}
}
