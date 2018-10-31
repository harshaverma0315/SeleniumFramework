package SeleniumTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
import SeleniumTesting.CreateAccountTest;

public class LoginTest extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
			FileInputStream fis = new FileInputStream("C:\\Users\\Harsha\\Desktop\\CreateAccountDetails.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet("Login");
			int getTotalRows = sheet.getLastRowNum();
			System.out.println(getTotalRows + " is the totals no. of rows in Login");
			int getTotalCol = sheet.getRow(0).getLastCellNum();
			System.out.println(getTotalCol + " is the totals no. of columns in first row");
			Object[][] DataCellValues = new Object[getTotalRows + 1][getTotalCol];
			for (int i = 0; i <= getTotalRows; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j <= getTotalCol - 1; j++) {
					XSSFCell cell = row.getCell(j);
					DataCellValues[i][j] = new DataFormatter().formatCellValue(row.getCell(j));
					System.out.println(DataCellValues[i][j]);
				}
			}
			return DataCellValues;
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
	
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Successfully closed the browser");
		
	}
}
