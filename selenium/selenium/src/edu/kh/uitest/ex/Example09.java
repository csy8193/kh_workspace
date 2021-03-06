package edu.kh.uitest.ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example09 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://kh-aclass.xyz:8081/Selenium/exam1/attrTest.html");
		
		// input 요소 얻어오기
		WebElement input = driver.findElement(By.cssSelector("body > input[type=text]"));
		
		
		// input 요쇼의 value 얻어오기
		// -> input.getAttribute("value") : input 요소의 value 속성값을 반환
		System.out.println(input.getAttribute("value"));
		
		System.out.println(input.getAttribute("type"));
		
		
		// div 요소 얻어오기
		WebElement div = driver.findElement(By.xpath("/html/body/div[1]"));
		
		// div 요소의 내용 얻어오기
		System.out.println(div.getText());
		System.out.println(div.getAttribute("innerText"));
		System.out.println(div.getAttribute("innerHTML"));
		
		// select 요소 얻어오기
		Select select = new Select(driver.findElement(By.id("age")));
		
		// select 내부 option 속성 중 "20대" 선택
		// 1) 화면에 보이는 값을 이용해 "20대" 선택
		// select.selectByVisibleText("20대");
		
		// 2) select가 가지고있는 option 태그의 인덱스 번호로 선택
		// select.selectByIndex(2);
		
		// 3) option에 작성된 value 값으로 선택
		select.selectByValue("2");
		
	}
}
