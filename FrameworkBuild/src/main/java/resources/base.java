package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Harsha\\FrameworkBuild\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\harsha\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harsha\\Desktop\\chromedriver.exe\\");
			driver = new ChromeDriver();
		} 
		else 
		{
			System.out.println("Please install the driver file of " + browserName + " and set the path");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	

	public void Screenshots(String result) throws IOException {
		// TODO Auto-generated method stub
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Harsha\\Screenshot\\"+result+"\\error.png")); 
		

	}

}
