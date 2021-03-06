package edu.kh.uitest.ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example04 {
	public static void main(String[] args) {
		
		// 네이버 홈페이지 -> 로그인 페이지 -> 로그인
		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naver.com");
		
		List<WebElement> btns = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[2]/a"));
		
		if(btns.size() == 1) {
			btns.get(0).click();
		}
		
		driver.findElement(By.id("id")).sendKeys("test1234");
		
		driver.findElement(By.id("pw")).sendKeys("xptmxm!123");
		
		driver.findElement(By.id("log.login")).click();
		
	}
}
