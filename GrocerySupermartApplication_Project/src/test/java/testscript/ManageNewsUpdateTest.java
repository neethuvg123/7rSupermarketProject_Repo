package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageNewsUpdatePage;
import utilities.ExcelUtility;

public class ManageNewsUpdateTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class, description = "user is able to update Manage News page")

	public void validateSaveBtnInManageNews() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		ManageNewsUpdatePage managenewsupdatepage = new ManageNewsUpdatePage(driver);
		managenewsupdatepage.moreInfo();
		managenewsupdatepage.searcButtonClick();
		String msgs = ExcelUtility.getStringData(4, 0, "ManageNewsUpdate");
		managenewsupdatepage.enterSearcMsg(msgs);
		managenewsupdatepage.searcButtonClicks();
		managenewsupdatepage.tableSerach();
		//managenewsupdatepage.actionButonClick();
		String msg = ExcelUtility.getStringData(4, 1, "ManageNewsUpdate");
		managenewsupdatepage.enterTextMsg(msg);
		managenewsupdatepage.clickUpdateButon();
		boolean alertmsg = managenewsupdatepage.alertMsgDisplay();
		Assert.assertTrue(alertmsg,Constant.ALERT_MSG_DISPLAY);
	}
}