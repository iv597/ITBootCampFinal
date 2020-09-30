package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopUpPage extends BasicPage {
	
	public LocationPopUpPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	
	public WebElement getSelectLocation() {
		return this.driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[1]/div/a"));
	}
	public WebElement getCloseLocationElement() {
		return this.driver.findElement(By.xpath("//*[@id='location-popup']/div/div/div/div/a"));
	}
	public WebElement getKeyWord() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	public void openSelectLocation() {
		this.getSelectLocation().click();
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	public void selectLocation(String locationName) {
		this.getKeyWord().click();
		this.getLocationItem(locationName);
		String argumentValue = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), argumentValue);
		js.executeScript("arguments[0].click();", this.getSubmit());
		
}
	
	public void closeLocationHeader() {
		this.getCloseLocationElement().click();
	}
}
