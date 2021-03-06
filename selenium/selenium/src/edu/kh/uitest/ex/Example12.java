package edu.kh.uitest.ex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example12 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.iei.or.kr/login/login.kh");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleContains("KH정보교육원"));
		
		driver.findElement(By.id("id")).sendKeys("csy8193");
		
		driver.findElement(By.id("password")).sendKeys("Wpffl10071!");
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		
		exe.executeScript("fnLogin()");
		
		if(ExpectedConditions.alertIsPresent().apply(driver) != null) {
			driver.switchTo().alert().accept();
			exe.executeScript("fnLogin()");
		}
		
//		exe.executeScript("location.href='/login/currBoard.kh'");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"head_nav\"]/ul/li[16]")));
		
		exe.executeScript("location.href='/login/currBoard.kh'");
		
		exe.executeScript("fnWriteForm()");
		
		driver.findElement(By.id("title")).sendKeys("UI테스트-최승엽");
		
		driver.switchTo().frame("tx_canvas_wysiwyg");
		
		driver.findElement(By.xpath("/html/body")).sendKeys("테스트");
		
		driver.switchTo().parentFrame();
		
		exe.executeScript("fnRegister()");
		
//		ui테스트-최승엽
		
		
	}
}
