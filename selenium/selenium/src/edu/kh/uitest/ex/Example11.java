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

public class Example11 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://kh-aclass.xyz:8081/Selenium/exam3/loginInput.html");
		
		// 아이디, 비밀번호에 값을 전달하고
		// 취소 버튼 누르기
		
		WebElement id = driver.findElement(By.id("id"));
		WebElement pw = driver.findElement(By.id("password"));
		
		id.sendKeys("test");
		pw.sendKeys("test");
		
		// 취소 버튼을 찾아서 클릭 -> 화면에 처음에 없기 때문에 오류 발생
		// -> 대기명령 작성하면 해결 가능
		
		// 1. 묵시적 대기(implicitlyWait)
		// driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(3));
		
		// 2. 명시적 대기(Explicitly Wait)
		// -> 명시적으로 대기를 지정할 객체 생성
		// 	  + 어떤 상황에 명시적 대기를 할 것인가 지정
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// -> 명시적 대기 명령을 작성하는 경우 driver를 최대 10초 대기 시킴
		
		// *** 명시적 대기 명령으로 지정할 수 있는 상황(상태)
		// 1. 특정 요소가 클릭이 가능할 때 까지 대기
		// -> 요소가 나타날 때 까지
		
		// 2. 페이지의 제목에 특정 문자열이 나타날 때 까지 대기
		// -> 페이지 로딩이 끝났을 때
		
		// 3. alert창이 뜰 때까지 대기
		
		// 1. 특정 요소가 클릭이 가능할 때 까지 대기
		wait.until(ExpectedConditions.elementToBeClickable(By.id("resetBtn")));
		
		WebElement resetBtn = driver.findElement(By.id("resetBtn"));
		resetBtn.click();
		
		
		// 초기화된 id, pw를 다시 작성
		id.sendKeys("test");
		pw.sendKeys("test");
		
		
		// 로그인 버튼에 작성된 fnLogin() 함수 호출
		// -> JavascriptExecutor 이용
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("fnLogin()");
		
		
		
		// 웹 페이지 제목에 "마이페이지" 라는 문자열이 포함되는 경우에
		// "훈련생도 평가" 버튼을 클릭
		
		wait.until(ExpectedConditions.titleContains("마이페이지"));
		// -> 제목에 "마이페이지" 문자열이 포함될 때까지 명시적 대기
		
		
		// 자바스크립트로 페이지 이동
		exe.executeScript("location.href='currBoard.html'");
		
		
		// 페이지 제목에 "우리반 게시판" 문자열이 포함될 때 까지 명시적 대시
		wait.until(ExpectedConditions.titleContains("우리반 게시판"));
		
		
		exe.executeScript("fnWriteForm()");
		
		
		// 글 제목 input 요소 찾기
		WebElement title = driver.findElement(By.id("title"));
		
		// 글 제목에 값 전달
		title.sendKeys("글제목을 작성해보고 있습니다.");
		
		
		driver.switchTo().frame("iframeMsg");
		
		WebElement textarea = driver.findElement(By.id("areaMsg"));
		
		textarea.sendKeys("가나다라\n1234\nABCD");
		
		
		// iframe으로 이동된 포커스를 다시 부모 프레임으로 이동
		driver.switchTo().parentFrame();
		
		// fnRegister() 함수 호출
		exe.executeScript("fnRegister()");
		
		
		// alert 창이 나타날 때 까지 명시적 대기
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		// alert 창 확인 버튼 클릭
		driver.switchTo().alert().accept();
		
		driver.quit();
		
	}
}
