package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage managenewspage;
	HomePage logout;

	@Test(retryAnalyzer = retry.Retry.class, description = "User is able to access the Manage News Page")

	public void verifyUserisAbleToAccessManageNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		logout = loginpage.clickSignin();
		String textmsg = ExcelUtility.getStringData(3, 0, "ManageNewsPage");
		managenewspage = logout.moreinfo_manageNewsPage();
		managenewspage.newButtonClick().newsTextBox(textmsg).saveButton();
		boolean alerts = managenewspage.isViewAlertmsg();
		Assert.assertTrue(alerts, Constant.ALERT_MSG_DISPLAY);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "user is able to update Manage News page")

	public void validateSaveBtnInManageNews() throws Exception {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		logout = loginpage.clickSignin();
		managenewspage = logout.moreinfo_manageNewsPage();
		String msgs = ExcelUtility.getStringData(2, 0, "ManageNewsUpdate");
		String msg = ExcelUtility.getStringData(2, 1, "ManageNewsUpdate");
		managenewspage.searcButtonClick().enterSearcMsg(msgs).searcButtonClicks().updateNews(driver, msgs, msg);
		boolean alertmsg = managenewspage.isAlertMsgDisplay();
		Assert.assertTrue(alertmsg, Constant.ALERT_MSG_DISPLAY);
	}

}