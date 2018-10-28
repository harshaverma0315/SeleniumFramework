package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement EnterEmail;
	
	@FindBy(id="passwd")
	WebElement EnterPassword;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgorPassword;
	
	@FindBy(name="SubmitLogin")
	WebElement SubmitLogin;
	
	
	public WebElement EnterEmail()
	{
		return EnterEmail;
	}
	
	public WebElement EnterPassword()
	{
		return EnterPassword;
	}
	
	public WebElement forgorPassword()
	{
		return forgorPassword;
	}
	
	public WebElement SubmitLogin()
	{
		return SubmitLogin;
	}

}
