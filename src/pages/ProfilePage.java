package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	
	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	public WebElement getEmail() {
		return this.driver.findElement(By.name("user_email"));
	}
	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	}
	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}
	public WebElement getPhone() {
		return this.driver.findElement(By.name("user_phone"));
	}
	public WebElement getCountry() {
		return this.driver.findElement(By.name("user_country_id"));
	}
	public WebElement getState() {
		return this.driver.findElement(By.name("user_state_id"));
	}
	public WebElement getCity() {
		return this.driver.findElement(By.name("user_city"));
	}
	public WebElement getSaveProfileInfoBtn() {
		return this.driver.findElement(By.xpath("//*[@id='profileInfoFrm']/div[5]/div/fieldset/input"));
	}
	public WebElement getCurrentPassword() {
		return this.driver.findElement(By.name("current_password"));
	}
	public WebElement getNewPassword() {
		return this.driver.findElement(By.name("new_password"));
	}
	public WebElement getConfirmPassword() {
		return this.driver.findElement(By.name("conf_new_password"));
	}
	public WebElement getSavePassswordBtn() {
		return this.driver.findElement(By.xpath("//*[@id='frm_fat_id_changePwdFrm']/div/div[4]/fieldset/input"));
	}
	public WebElement getUploadBtn() {
		return this.driver.findElement(By.name("//*[@id='profileInfo']/div/div[1]/div/a[1]"));
	}
	public WebElement getRemoveBtn() {
		return this.driver.findElement(By.name("//*[@id='profileInfo']/div/div[1]/div/a[2]"));
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void uploadPhoto() {
		js.executeScript("arguments[0].click()", getUploadBtn());
	}
	
	public void uploadPhotoFile() {
		this.getUploadBtn().sendKeys("C:\\Users\\Ivana Kostic\\Desktop/Profile.jpg");
	}
		
		
	
	public void removePhoto() {
		js.executeScript("arguments[0].click()", getRemoveBtn());
}
	
	public void inputAll(String firstName, String lastName, String email, String address, String zipCode, 
			String phone, String country, String state, String city) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
		this.getCountry().clear();
		this.getCountry().sendKeys(country);
		this.getState().clear();
		this.getState().sendKeys(state);
		this.getCity().clear();
		this.getCity().sendKeys(city);
	}
}