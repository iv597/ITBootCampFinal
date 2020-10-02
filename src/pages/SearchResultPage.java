package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement qtyInput() {
		return this.driver.findElement(By.name("product_qty"));
	}
	

	
	public List<WebElement> getSearchResult(){
		return this.driver.findElements(By.xpath("//*[@class='product-name']/a"));
		
	}
	
	public ArrayList<String> nameOfAllMeals(){
		ArrayList<String> names = new ArrayList<>();
		for (int i = 0; i <this.getSearchResult().size(); i++) {
			names.add(this.getSearchResult().get(i).getText());
		}
		return names;
	}
	public int numberOfSearchResults() {
		return this.getSearchResult().size();
	}
}
