package sdet;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseCase2 {
	public WebDriver driver;
	@FindBy(xpath="//input[@class='_3704LK']")
	WebElement SearchBar;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")
	WebElement SearchResult;
	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement CloseButton;
	
	
	@FindBy(className = "_4rR01T")
	List<WebElement> count;
	
	@FindBy(className = "_4rR01T")
	WebElement Firstproduct;
	
	public void ClickCloseButton() {
		CloseButton.click();
	}
	public void EnterSearchBar(String text) {
		SearchBar.sendKeys(text,Keys.ENTER);
	}
	public void ClickFirstResult() { 
		SearchResult.click();
	}
	public void ClickFirstproduct() { 
		System.out.println(count.size());
		Firstproduct.click();
	}
	
	public BaseCase2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
