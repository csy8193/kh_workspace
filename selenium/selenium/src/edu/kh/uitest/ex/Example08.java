package edu.kh.uitest.ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example08 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://kh-aclass.xyz:8081/Selenium/exam1/iframeTest2.html");
		
		
		// 문제 해결 방법 적용
		driver.switchTo().frame("subIframe");
		
		
		// iframe 내부에 작성된 id input 요소를 얻어와 "test" 값 전달
		WebElement id = driver.findElement(By.id("id"));
		id.sendKeys("test");
		
		WebElement pw = driver.findElement(By.id("password"));
		pw.sendKeys("test");
		
		
		// ********* Selenium에서 Javascript 수행하는 방법 ***********
		
		// WebDriver를 JS가 실행 가능한 형태로 형변환을 시켜야 한다
		
		// --> Javascript Executor로 형변환
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		
		// 로그인 버튼에 있는 이벤트 리스너 ( fnLogin() ) 호출
		exe.executeScript("fnLogin()");
		
		
		// ***********************************************************
		
		
		// alert로 포커스를 이동하여 확인버튼 누르기
		driver.switchTo().alert().accept(); // -> alert 확인버튼 클릭
		// -> 클릭 후 자동으로 포커스 복귀
		
		
		
		
		
		// iframe으로 이동했던 포커스를 다시 원래 화면(부모 프레임)
		driver.switchTo().parentFrame();
		
		// 태그명이 p태그인 요소를 모두 얻어오기
		List<WebElement> pList = driver.findElements(By.tagName("p"));
		
		// 얻어온 p 요소 개수
		System.out.println("p 개수 : " + pList.size());
		
		// 향상된 for문으로 얻어온 p 요소의 내용 출력하기
		for(WebElement p : pList) {
			System.out.println(p.getText());;
		}
		
		
	}
}
