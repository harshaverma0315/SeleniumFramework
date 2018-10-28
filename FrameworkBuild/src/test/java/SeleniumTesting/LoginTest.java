package SeleniumTesting;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
public class LoginTest extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	
	@Test (dataProvider = "getData")
	public void signIn(String username, String password) {
		LandingPage lp = new LandingPage(driver);
		lp.signin().click();
		LoginPage lpg = new LoginPage(driver);
		lpg.EnterEmail().sendKeys(username);
		lpg.EnterPassword().sendKeys(password);
		//lpg.forgorPassword().click();
		lpg.SubmitLogin().click();
		log.info("Successfully tested login code");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data =new Object[1][2];
		
		data [0][0] = "harsha@gmail.comm";
		data [0][1] = "password";
		
		return data;
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Successfully closed the browser");
		driver=null;
	}
}
