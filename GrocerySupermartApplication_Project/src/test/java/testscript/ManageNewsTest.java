package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	 ManageNewsPage managenewspage;
	 LogOutPage logout;
	 
	@Test(retryAnalyzer = retry.Retry.class, description = "User is able to access the Manage News Page")

	public void verifyUserisAbleToAccessManageNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		
		logout=loginpage.clickSignin();
		String textmsg = ExcelUtility.getStringData(3, 0, "ManageNewsPage");
		//ManageNewsPage managenewspage = new ManageNewsPage(driver);
		
		managenewspage=logout.moreinfo_manageNewsPage();
		managenewspage.newButtonClick().newsTextBox(textmsg).saveButton();
		
		/*managenewspage.newsTextBox(textmsg);
		managenewspage.saveButton();*/
		
		boolean alerts = managenewspage.alertmsg();
		Assert.assertTrue(alerts,Constant.ALERT_MSG_DISPLAY);

	}

}
