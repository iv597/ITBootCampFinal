package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.NotificationSystemPage;

public class ProfileTest extends BasicTest{
	
	@Test
	public void editProfileTest() throws InterruptedException, IOException{
		this.driver.navigate().to(this.baseUrl + "guest-user/login-form");
		
		NotificationSystemPage nsp = new NotificationSystemPage(this.driver, this.wait, this.js);
		
	}
	

}
