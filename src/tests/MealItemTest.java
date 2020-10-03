package tests;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartSummaryPage;
import pages.LocationPopUpPage;
import pages.LoginPage;
import pages.MealItemPage;
import pages.NotificationSystemPage;
import pages.SearchResultPage;

public class MealItemTest extends BasicTest {

	@Test(priority = 0)
	public void mealItemTest() throws InterruptedException {
		this.driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");

		SoftAssert sa = new SoftAssert();

		MealItemPage mp = new MealItemPage(this.driver, this.wait, this.js);
		LocationPopUpPage lpp = new LocationPopUpPage(this.driver, this.wait, this.js);
		NotificationSystemPage nsp = new NotificationSystemPage(this.driver, this.wait, this.js);

		lpp.closeLocationHeader();
		Thread.sleep(1000);
		mp.addMeal("3");
		Thread.sleep(2000);

		sa.assertTrue(
				nsp.getSuccessfulMessage().equals("The Following Errors Occurred:" + "\n" + "Please Select Location"));

		wait.until(ExpectedConditions.invisibilityOf(nsp.getSuccessfulMessage()));

		lpp.openSelectLocation();
		lpp.selectLocation("City Center - Albany");
		Thread.sleep(2000);

		mp.addMeal("2");
		sa.assertTrue(nsp.getSuccessfulMessage().equals("Meal Added To Cart"));

	}

	@Test(priority = 10)
	public void addMealToFavourite() throws InterruptedException {
		this.driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");

		SoftAssert sa = new SoftAssert();

		MealItemPage mp = new MealItemPage(this.driver, this.wait, this.js);
		LocationPopUpPage lpp = new LocationPopUpPage(this.driver, this.wait, this.js);
		NotificationSystemPage nsp = new NotificationSystemPage(this.driver, this.wait, this.js);
		LoginPage lp = new LoginPage(this.driver, this.wait, this.js);

		//lpp.closeLocationHeader();
		Thread.sleep(2000);
		mp.addToFavourite();
		Thread.sleep(2000);

		sa.assertTrue(nsp.getSuccessfulMessage().equals("Please login first!"));

		wait.until(ExpectedConditions.invisibilityOf(nsp.getSuccessfulMessage()));
		mp.loginbtnclick();

		Thread.sleep(2000);
		lp.loginForm(this.userId, this.userPass);
		Thread.sleep(2000);

		this.driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mp.addToFavourite();

		sa.assertTrue(nsp.getSuccessfulMessage().equals("Product has been added to your favorites."));

	}

	@Test(priority = 15)
	public void clearCartTest() throws Exception {
		this.driver.get(baseUrl + "meals");
		MealItemPage mp = new MealItemPage(this.driver, this.wait, this.js);
		LocationPopUpPage lpp = new LocationPopUpPage(this.driver, this.wait, this.js);
		NotificationSystemPage nsp = new NotificationSystemPage(this.driver, this.wait, this.js);
		SearchResultPage srp = new SearchResultPage(this.driver, this.wait, this.js);
		CartSummaryPage csp = new CartSummaryPage(this.driver, this.wait, this.js);

		SoftAssert sa = new SoftAssert();
		 lpp.openSelectLocation();
		lpp.selectLocation("City Center - Albany");
		Thread.sleep(2000);

		File meals = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(meals);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);

			String mealUrl = row.getCell(0).getStringCellValue();
			System.out.println(mealUrl);

			this.driver.navigate().to(mealUrl);

			double qty = row.getCell(1).getNumericCellValue();
			mp.addMeal("" + qty + "");

			sa.assertTrue(nsp.getSuccessfulMessage().equals("Meal Added To Cart"));

			csp.clearbtn();

			sa.assertTrue(nsp.getSuccessfulMessage().equals("All meals removed from Cart successfully"));

		}
	}
}