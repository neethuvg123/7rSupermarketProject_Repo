package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	ManageCategoryPage managecategorypage;
	HomePage logout;

	@Test(groups = {"regression" }, retryAnalyzer = retry.Retry.class, description = " User is able to access Manage Catergory Page")

	public void verifyuserIsAbleToAccessManageCategoryPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		logout = loginpage.clickSignin();	
		managecategorypage = logout.moreinfo_manageCategoryPage();
		String lists = ExcelUtility.getStringData(4, 0, "ManageCategoryPage");
		managecategorypage.newbutton().category(lists).groupselect().choosefile().clickTopMenu().clickSowHome().saveButton();
		boolean msg = managecategorypage.isViewAlert();
		Assert.assertTrue(msg, Constant.ALERT_MSG_DISPLAY);

	}

}
