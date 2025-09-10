package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class,description="User is able to login using valid credential")
	public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException {
		// String username="admin";
		// String password="admin";
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		boolean homepage = loginpage.isdashboardView();
		Assert.assertTrue(homepage,Constant.LOGIN_WITH_VALID_CREDENTIAL);
	}

	@Test(retryAnalyzer = retry.Retry.class, description="User is able to login using both invalid credentials")
	public void verifyUserIsAbleToLoginUsingInvalidCredentials() throws IOException {
		// String username="abcde";
		// String password="qwerty";
		String username = ExcelUtility.getStringData(4, 0, "LoginPage");
		String password = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		boolean alertmsg = loginpage.isAlertmessageDisplayed();
		Assert.assertTrue(alertmsg, Constant.LOGIN_WITH_INVALID_CREDENTIAL);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "user is able to login using invalid username")

	public void verifyUserisAbleToLoginWithInvalidUsername() throws IOException {
		// String username="abcde";
		// String password="admin";
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		boolean alertmsg = loginpage.isAlertmessageDisplayed();
		Assert.assertTrue(alertmsg,Constant.LOGIN_WITH_INVALID_CREDENTIAL);

	}

	@Test(retryAnalyzer = retry.Retry.class, description=" user is able to login invalid password")

	public void verifyUserIsAbletoLoginUsingInvalidPassword() throws IOException {
		// String username="admin";
		// String password="123456";
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getIntegerData(3, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		boolean alertmsg = loginpage.isAlertmessageDisplayed();
		Assert.assertTrue(alertmsg,Constant.LOGIN_WITH_INVALID_CREDENTIAL);

	}

}
