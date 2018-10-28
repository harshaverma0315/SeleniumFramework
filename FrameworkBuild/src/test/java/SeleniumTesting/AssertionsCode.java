package SeleniumTesting;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class AssertionsCode extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest

	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}

	@Test
	public void titleValidation() {

		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "Automations Practice Website");
		log.debug("Incorrect title");
		Assert.assertTrue(lp.BestSeller().isDisplayed());
		log.info("Best Seller tag is displayed");
	}

	@AfterTest

	public void teardown() {
		driver.close();
		log.info("Successfully closed the browser");
		driver=null;
	}
}
