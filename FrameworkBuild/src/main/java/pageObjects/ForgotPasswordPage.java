package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	WebElement emailid;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement retrievePass;
	
	@FindBy(xpath="//a[contain(@href='http://automationpractice.com/index.php?cont')")
	WebElement returnLogin;
	
	public WebElement enterEmail()
	{
		return emailid;
	}
	public WebElement retrievePass()
	{
		return retrievePass;
	}
	public WebElement returnLogin()
	{
		return returnLogin;
	}
}
