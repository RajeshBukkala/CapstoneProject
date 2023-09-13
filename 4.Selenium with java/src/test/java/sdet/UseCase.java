package sdet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseCase {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	}
	@Test
	public void Run() {
		BaseCase rb=new BaseCase(driver);
		rb.clickcontact();
		rb.EnterName("Rajesh");
		rb.EnterEmail("rajeshbukkala@gmail.com");
		rb.EnterMessage("Capstone Project");
		rb.clickcontactMe();
		
		String SucessMessage=rb.MesasageSent();
		System.out.println("MessageVerified");
		
		driver.close();
		
		
				
		
	}
}
