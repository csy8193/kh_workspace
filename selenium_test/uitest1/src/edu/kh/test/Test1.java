package edu.kh.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.iei.or.kr/login/login.kh");
		
		
		// 아이디, 비밀번호 입력
		driver.findElement(By.id("id")).sendKeys("khevaltest");
		driver.findElement(By.id("password")).sendKeys("jWsh2j#df");
		
		// 자바스크립트로 로그인 버튼 클릭
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("fnLogin()");
		
		// title이 마이페이지 일때까지 대기
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("마이페이지"));
		
		// 우리반 게시판으로 이동
		exe.executeScript("location.href='/login/currBoard.kh'");
		
		// title이 우리반 게시판 일때까지 대기
		wait.until(ExpectedConditions.titleContains("우리반 게시판"));
		
		// 글쓰기 버튼 클릭
		exe.executeScript("fnWriteForm()");
		
		// id가 title인 요소가 클릭 가능할때 까지 대기
		wait.until(ExpectedConditions.elementToBeClickable(By.id("title")));
		
		// id가 title인 요소에 값을 넣음
		driver.findElement(By.id("title")).sendKeys("시험문제 답안 작성 중 입니다. 제목-최승엽");
		
		// frame 이동
		driver.switchTo().frame("tx_canvas_wysiwyg");
		
		// class명이 tx-content-container인 요소에 값을 넣음
		driver.findElement(By.className("tx-content-container")).sendKeys("시험문제 답안 작성 중 입니다. - frame 처리");
		
		// frame을 부모frame으로 이동
		driver.switchTo().parentFrame();
		
		// 등록버튼 클릭
		exe.executeScript("fnRegister()");
		
		// alert창이 뜰때까지 대기 후 확인버튼
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		// driver 종료
		driver.close();
		
	}
}
