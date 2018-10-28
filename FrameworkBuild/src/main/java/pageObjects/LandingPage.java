package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	 WebDriver driver;

	public LandingPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'controller=my-account')]")
	WebElement signIn;
	
	@FindBy(xpath="//div[@id='editorial_block_center']/h1")
	WebElement title;
	
	@FindBy(xpath="//a[@class='blockbestsellers']")
	WebElement BestSeller;
	
	public WebElement signin() 
	{
		return signIn;
	}
	
	public WebElement getTitle() 
	{
		return title;
	}
	
	public WebElement BestSeller() 
	{
		return BestSeller;
	}
	
}
