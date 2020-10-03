package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		return this.driver.findElement(By.xpath("//*[@id='user_country_id']"));
	}

	public WebElement getState() {
		return this.driver.findElement(By.xpath("//*[@id='user_state_id']"));
	}

	public WebElement getCity() {
		return this.driver.findElement(By.xpath("//*[@id='user_city']"));
	}

	public WebElement getSaveProfileInfoBtn() {
		return this.driver.findElement(By.xpath("//*[@id='profileInfoFrm']/div[5]/div/fieldset/input"));
	}

	public WebElement getSavePassswordBtn() {
		return this.driver.findElement(By.xpath("//*[@id='frm_fat_id_changePwdFrm']/div/div[4]/fieldset/input"));
	}

	public WebElement getUploadBtn() {
		return this.driver.findElement(By.className("upload"));
	}

	public WebElement getRemoveBtn() {
		return this.driver.findElement(By.className("remove"));
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void uploadPhotoFile(String photo) throws IOException, InterruptedException {

		js.executeScript("arguments[0].click();", this.getUploadBtn());	
	 photo = new File("images\\slika.jpg").getCanonicalPath();
		WebElement upload = this.driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys(photo);
	}

	public void removePhoto() {
		js.executeScript("arguments[0].click()", getRemoveBtn());
	}

	public void inputAll(String firstName, String lastName, String address, String phone, String zipCode,
			String country, String state, String city) throws InterruptedException {
		this.getFirstName().sendKeys(Keys.chord(Keys.CONTROL, "a"), firstName);
		this.getLastName().sendKeys(Keys.chord(Keys.CONTROL, "a"), lastName);
		this.getAddress().sendKeys(Keys.chord(Keys.CONTROL, "a"), address);
		this.getPhone().sendKeys(Keys.chord(Keys.CONTROL, "a"), phone);
		this.getZipCode().sendKeys(Keys.chord(Keys.CONTROL, "a"), zipCode);
		Thread.sleep(1000);
		this.getCountry().sendKeys(country);
		Thread.sleep(1000);
		this.getState().sendKeys(state);
		Thread.sleep(1000);
		this.getCity().sendKeys(city);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", getSaveProfileInfoBtn());

	}
}