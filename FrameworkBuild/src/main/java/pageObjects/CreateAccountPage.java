package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage 
{
	WebDriver driver;

	public CreateAccountPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email_create")
	WebElement id;
	
	@FindBy(id="SubmitCreate")
	WebElement CreateAccountButton;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement gender1;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement gender2;
	
	@FindBy(css="input[id='customer_firstname']")
	WebElement CustomerFirstName;
	
	@FindBy(name="customer_lastname")
	WebElement CustomerLastName;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement years;
	
	@FindBy(xpath="//input[@name='newsletter']")
	WebElement checkbox1;
	@FindBy(xpath="//input[@name='optin']")
	WebElement checkbox2;
	
	@FindBy(id="firstname")
	WebElement FirstName;
	
	@FindBy(id="lastname")
	WebElement LastName;
	
	@FindBy(id="company")
	WebElement Company;
	
	@FindBy(id="address1")
	WebElement Address;
	
	@FindBy(id="address2")
	WebElement Address2;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="id_state")
	WebElement StateDropDown;
	
	@FindBy(id="postcode")
	WebElement ZipPostal;
	
	@FindBy(id="id_country")
	WebElement CountryDropDown;
	
	@FindBy(name="other")
	WebElement Additional;
	
	@FindBy(css="input[id='phone']")
	WebElement HomePhone;
	
	@FindBy(id="phone_mobile")
	WebElement MobilePhone;
	
	@FindBy(id="alias")
	WebElement AddressAlias;
	
	@FindBy(id="submitAccount")
	WebElement Register;
	
	public WebElement id()
	{
		return id;
	}
	public WebElement createAcc()
	{
		return CreateAccountButton;
	}	
	public WebElement gender1()
	{
		return gender1;
	}
	public WebElement gender2()
	{
		return gender2;
	}
	public WebElement CustomerFirstName()
	{
		return CustomerFirstName;
	}
	public WebElement CustomerLastName()
	{
		return CustomerLastName;
	}
	public WebElement Password()
	{
		return Password;
	}
	public WebElement DaysDropdown()
	{
		return days;
	}
	public WebElement MonthsDropdown()
	{
		return months;
	}
	public WebElement YearsDropdown()
	{
		return years;
	}
	public WebElement ChechBox1()
	{
		return checkbox1;
	}
	public WebElement ChechBox2()
	{
		return checkbox2;
	}
	
	public WebElement FirstName()
	{
		return FirstName;
	}
	public WebElement LastName()
	{
		return LastName;
	}
	public WebElement Company() 
	{
		return Company;
	}
	public WebElement Address()
	{
		return Address;
	}
	public WebElement Address2()
	{
		return Address2;
	}
	public WebElement City()
	{
		return City;
	}
	public WebElement State()
	{
		return StateDropDown;
	}
	public WebElement ZipPostal()
	{
		return ZipPostal;
	}
	public WebElement Country()
	{
		return CountryDropDown;
	}
	public WebElement Additional()
	{
		return Additional;
	}
	public WebElement HomePhone()
	{
		return HomePhone;
	}
	public WebElement MobilePhone()
	{
		return MobilePhone;
	}
	public WebElement AddressAlias()
	{
		return AddressAlias;
	}
	public WebElement Register()
	{
		return Register;
	}
	
}
