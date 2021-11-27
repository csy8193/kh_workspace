package edu.kh.uitest.ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example05 {
	public static void main(String[] args) {
		// 구글 홈페이지 -> "KH정보교육원" 검색
		// -> 제일 위 검색 결과를 선택 -> KH정보교육원 홈페이지 접속
		
		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.co.kr");
		
		WebElement input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		
		input.sendKeys("KH정보교육원");
		
		input.submit();
		
		driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a")).click();
		
		try {
			Thread.sleep(5000); // 현재 메소드(메인 메소드)가 동작 중인 스레드를 5초간 정지
			driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
