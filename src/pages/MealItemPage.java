package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealItemPage extends BasicPage {

	public MealItemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement addToCart() {
		return this.driver.findElement(By.xpath("//*[@id='body']/section[1]/div/div/div[2]/div/div[3]/div[2]/a"));
	}
	public void addMeal(String qty) {
		this.wait.until(ExpectedConditions.elementToBeClickable(addToCart()));
		
	}
	public void addToFavourite() {
		this.driver.findElement(By.xpath("//*[@id=\"item_42\"]/i/svg/g/path")).click();
	}

}
