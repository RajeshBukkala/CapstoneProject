package sdet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseCase {
	public WebDriver driver;
	@FindBy(xpath="//*[@id=\"menu-item-10\"]/a")
	WebElement Contact;
	@FindBy(id="g3-name")
	WebElement Name;
	@FindBy(id="g3-email")
	WebElement Email;
	@FindBy(id="contact-form-comment-g3-message")
	WebElement Message;
	@FindBy(xpath ="//*[@id=\"contact-form-3\"]/form/div/div[4]/button")
	WebElement ContactMe;
	@FindBy(id ="contact-form-success-header")
	WebElement VerifiedMessage;
	
	public void clickcontact() {
		Contact.click();
	}
	public void EnterName(String name) {
		Name.sendKeys(name);
	}
	public void EnterEmail(String email) {
		Email.sendKeys(email);
	}
	public void EnterMessage(String message) {
		Message.sendKeys(message);
	}
	public void clickcontactMe() {
		ContactMe.click();
		
	}
	public String MesasageSent() {
		return VerifiedMessage.getText();
	}
	public BaseCase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
}
