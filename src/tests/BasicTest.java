package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.nashorn.internal.scripts.JS;


public abstract class BasicTest {
	protected String baseUrl = "http://demo.yo-meals.com/";
	protected String userId = "customer@dummyid.com";
	protected String userPass = "12345678a";
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String phone;
	JavascriptExecutor js = (JavascriptExecutor) driver;



	@BeforeClass
	public void beforeClass() throws IOException{
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(driver, 30);		
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	}

	
	
	@AfterMethod
	public void afterTest(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			File ss = ((RemoteWebDriver) this.driver).getScreenshotAs(OutputType.FILE);
			String fileName = new SimpleDateFormat("yyyyMMddHHmmSS'.png'").format(new Date());
			File save = new File("screenshots/" + fileName);
			   FileHandler.copy(ss, save);
		}
	}
	


	@AfterClass
	public void afterClass() {
//		this.driver.quit();
	}
}


