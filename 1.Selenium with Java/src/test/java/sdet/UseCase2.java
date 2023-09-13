package sdet;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class UseCase2 {
	public WebDriver driver;
	@BeforeSuite
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	}
	@Test
	public void Test() {
		BaseCase2 rb=new BaseCase2(driver);
		rb.ClickCloseButton();
		rb.EnterSearchBar("iphone 14");
		List<WebElement>SearchResults=driver.findElements(By.xpath("//input[@class='_3704LK']"));
		System.out.println(SearchResults.size()+" items displayed");
		String MainHandle = driver.getWindowHandle();
		rb.ClickFirstResult();
		rb.ClickFirstproduct();
		
		Set<String> Handles=driver.getWindowHandles();
		for(String Handle:Handles) {
			if(!Handle.equals(MainHandle)) {
				driver.switchTo().window(Handle);
			}
		}
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="APPLE iPhone 14 ( 128 GB Storage ) Online at Best Price On Flipkart.com";
		Assert.assertEquals(ActualTitle,ExpectedTitle);
		
		
			}
		}
		
		
		
		
		
		
		
		
		
	
