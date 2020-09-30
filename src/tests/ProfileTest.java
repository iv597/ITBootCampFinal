package tests;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.LocationPopUpPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest {

	@Test (priority = 0)
	public void editProfileTest() throws InterruptedException, IOException {
		this.driver.navigate().to(this.baseUrl + "guest-user/login-form");

		NotificationSystemPage nsp = new NotificationSystemPage(this.driver, this.wait, this.js);
		LocationPopUpPage lpp = new LocationPopUpPage(this.driver, this.wait, this.js);
		LoginPage lp = new LoginPage(this.driver, this.wait, this.js);
		ProfilePage pp = new ProfilePage(this.driver, this.wait, this.js);
		AuthPage ap = new AuthPage(this.driver, this.wait, this.js);

		SoftAssert sa = new SoftAssert();

		

		lpp.closeLocationHeader();
		lp.loginForm(this.userId, this.userPass);

		Assert.assertTrue(nsp.getSuccessfulMessage().equals("Login Successfull"));

		this.driver.navigate().to(this.baseUrl + "member/profile");

		pp.inputAll("Ivana", "Kostic", "user@gmail.com", "Nis", "18000", "09090", "Serbia", "Serbia", "Nis");

		Assert.assertTrue(nsp.getSuccessfulMessage().equals("Setup Successful"));

		ap.logout();

		Assert.assertTrue(nsp.getSuccessfulMessage().equals("Logout Successfull!"));

	}
	
	@Test (priority = 5)
	public void changeProfileImgTest() throws InterruptedException, IOException {
		this.driver.navigate().to(this.baseUrl + "guest-user/login-form");

		NotificationSystemPage nsp = new NotificationSystemPage(this.driver, this.wait, this.js);
		LocationPopUpPage lpp = new LocationPopUpPage(this.driver, this.wait, this.js);
		LoginPage lp = new LoginPage(this.driver, this.wait, this.js);
		ProfilePage pp = new ProfilePage(this.driver, this.wait, this.js);
		AuthPage ap = new AuthPage(this.driver, this.wait, this.js);

		SoftAssert sa = new SoftAssert();

		lpp.closeLocationHeader();
		
		lp.loginForm(this.userId, this.userPass);

		Assert.assertTrue(nsp.getSuccessfulMessage().equals("Login Successfull"));

		this.driver.navigate().to(this.baseUrl + "member/profile");
		
		String imgPath = new File("images/slika.jpg").getCanonicalPath();
		
		pp.uploadPhotoFile(imgPath);
		
		Assert.assertTrue(nsp.getSuccessfulMessage().equals("Profile Image Uploaded Successfully"));
		
		wait.until(ExpectedConditions.invisibilityOf(nsp.getSuccessfulMessage()));
		
		pp.removePhoto();
		
		Assert.assertTrue(nsp.getSuccessfulMessage().equals("Profile Image Deleted Successfully"));
		
		wait.until(ExpectedConditions.invisibilityOf(nsp.getSuccessfulMessage()));
		
		ap.logout();

		Assert.assertTrue(nsp.getSuccessfulMessage().equals("Logout Successfull!"));

	}

}
