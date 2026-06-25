package Tests;

import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;

public class LoginTest extends Base {
	@Test(groups = { "smoke" })

	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);

		loginPage.login("standard_user", "secret_sauce");

		dashboardPage.logout();

	}

}
