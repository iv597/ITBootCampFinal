package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait,JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	
	public void loginButton() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div[2]/div[2]/ul/li[2]/a"));
		loginbtn.click();
	}
	
	public WebElement getUsername() {
		return this.driver.findElement(By.name("username"));
	}
	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	public WebElement rememberMeCheckBox() {
		return this.driver.findElement(By.name("remember_me"));
	}
	public WebElement loginBtn() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	public void loginForm(String username, String password) {
		this.getUsername().clear();
		this.getUsername().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		rememberMeCheckBox().click();
		loginBtn().click();
		
	}
	
}
