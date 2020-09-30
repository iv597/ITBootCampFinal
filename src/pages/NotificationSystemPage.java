package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement getSuccessfulLogin() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	public String getSuccessfulLoginMessage() {
		return this.getSuccessfulLogin().getText();
	}
	public void waitTobeInvisible() {
		 this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, 'system_message')]")));
		
	}
}
