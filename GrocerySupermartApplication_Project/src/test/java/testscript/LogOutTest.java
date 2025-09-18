package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {

	@Test(description = "user is able to logout sucessfully")

	public void verifyUserisAbleToLout() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		HomePage logout = new HomePage(driver);
		logout.clickAdmin();
		logout.clickLogout();
		boolean view = logout.isViewSignin();
		Assert.assertTrue(view, Constant.LOGOUT_PAGE);
	}

}
