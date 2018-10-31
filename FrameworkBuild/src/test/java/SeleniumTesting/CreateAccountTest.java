package SeleniumTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class CreateAccountTest extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}

	@DataProvider
	public Object[][] Registerdata() throws IOException {
		////// Object[][] data = new Object[1][2];
		
	        return new Object[][]
	                {
	            {"harsha@gmail.comm", "Male", "Harsha", "Verma", "password", "15", "March ", "1992", "", "","","1234 address plaza",
	            	"apt#123","Omaha","Nebraska","12345","United States", "n/a", "1234567890", "9876543210", ""}
	            };
	  
	
	}

	@Test(dataProvider = "Registerdata")
	public void Register(String id, String gender, String CustomerFirstName, String CustomerLastName, String Password, String days,
			String months, String years, String FirstName, String LastName, String Company, String Address,
			String Address2, String City, String StateDropDown, String ZipPostal, String CountryDropDown,
			String Additional, String HomePhone, String MobilePhone, String AddressAlias) throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		lp.signin().click();
		CreateAccountPage cp = new CreateAccountPage(driver);
		cp.id().sendKeys(id);
		cp.createAcc().click();
		if (gender.equals("Male")) {
		cp.gender1().click();
		
		  } else if (gender.equals("Female")) { cp.gender2().click(); }
		 
		cp.CustomerFirstName().sendKeys(CustomerFirstName);
		cp.CustomerLastName().sendKeys(CustomerLastName);
		cp.Password().sendKeys(Password);
		Select day = new Select(cp.DaysDropdown());
		day.selectByValue(days);
		Select month = new Select(cp.MonthsDropdown());
		month.selectByVisibleText(months);
		Select year = new Select(cp.YearsDropdown());
		year.selectByValue(years);
		cp.ChechBox1().click();
		Assert.assertTrue(cp.ChechBox1().isSelected());
		cp.ChechBox2().click();
		Assert.assertTrue(cp.ChechBox2().isSelected());
		cp.FirstName().sendKeys(FirstName);
		cp.LastName().sendKeys(LastName);
		cp.Company().sendKeys(Company);
		cp.Address().sendKeys(Address);
		cp.Address2().sendKeys(Address2);
		cp.City().sendKeys(City);
		Select selectState = new Select(cp.State());
		selectState.selectByVisibleText(StateDropDown);
		cp.ZipPostal().sendKeys(ZipPostal);
		Select country = new Select(cp.Country());
		country.selectByVisibleText(CountryDropDown);
		cp.Additional().sendKeys(Additional);
		cp.HomePhone().sendKeys(HomePhone);
		cp.MobilePhone().sendKeys(MobilePhone);
		cp.AddressAlias().sendKeys(AddressAlias);
		cp.Register().click();

		log.info("Successfully tested CreateAccount code");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Successfully closed the browser");
		
	}
}
