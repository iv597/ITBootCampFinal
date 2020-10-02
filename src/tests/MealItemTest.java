package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LocationPopUpPage;
import pages.MealItemPage;
import pages.NotificationSystemPage;

public class MealItemTest extends BasicTest {
	
	@Test
	public void mealItemTest() throws InterruptedException{
		this.driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
	
		SoftAssert sa = new SoftAssert();

	MealItemPage mp = new MealItemPage(this.driver, this.wait, this.js);
	LocationPopUpPage lpp = new LocationPopUpPage(this.driver, this.wait, this.js);
	NotificationSystemPage nsp = new NotificationSystemPage(this.driver, this.wait, this.js);
	
	lpp.closeLocationHeader();
	
	mp.addMeal("3");
	Thread.sleep(2000);
	
	
	sa.assertTrue(nsp.getSuccessfulMessage().equals("The Following Errors Occurred:" + "\n" + "Please Select Location"));
	
	wait.until(ExpectedConditions.invisibilityOf(nsp.getSuccessfulMessage()));
	
	lpp.openSelectLocation();
	lpp.selectLocation("City Center - Albany");
	Thread.sleep(2000);
	
	mp.addMeal("2");
	sa.assertTrue(nsp.getSuccessfulMessage().equals("Meal Added To Cart"));
	
	sa.assertAll();
	
	
	
	}
}
