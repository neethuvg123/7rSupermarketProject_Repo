package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	ManageFooterPage managefooterpage;
	LogOutPage logout;

	@Test(retryAnalyzer = retry.Retry.class, description = "User is able to access the Manage Footer Page", groups = {
			"regression" })

	public void verifyUserIsAbletoAccessManageFooterPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		logout = loginpage.clickSignin();
		managefooterpage = logout.moreinfo_manageFooterpage();
		String address = ExcelUtility.getStringData(2, 0, "ManageFooterPage");
		String email = ExcelUtility.getStringData(2, 1, "ManageFooterPage");
		String phone = ExcelUtility.getIntegerData(2, 2, "ManageFooterPage");
		managefooterpage.clickButton().updateAddress(address).updateEmail(email).updatePhone(phone).clickUpdateButton();
		boolean msg = managefooterpage.alertViewAlertMessage();
		Assert.assertTrue(msg, Constant.ALERT_MSG_DISPLAY);
	}

	@Test(description = "user is able to validate UPDATE BUTTON in the page")

	public void validateUpdatebtnInManageFooterPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		logout = loginpage.clickSignin();
		managefooterpage = logout.moreinfo_manageFooterpage();
		managefooterpage.clickButton();
		boolean msg = managefooterpage.updateButonEnabled();
		Assert.assertTrue(msg, Constant.UPDATE_BTN);
	}

}
