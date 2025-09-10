package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageContactUpdateBtnPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	
	@Test(retryAnalyzer=retry.Retry.class,description=" User is able to access te Manage Contact Test page",groups= {"regression"})

	public void verifyUserisAbleToAccessManageContactPage() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		String phno = ExcelUtility.getIntegerData(1, 0, "ManageContact");
		String email = ExcelUtility.getStringData(1, 1, "ManageContact");
		String addres = ExcelUtility.getStringData(1, 2, "ManageContact");
		String time = ExcelUtility.getIntegerData(1, 3, "ManageContact");
		String charge = ExcelUtility.getIntegerData(1, 4, "ManageContact");
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickmoreinfo();
		managecontactpage.clickAction();
		managecontactpage.updatePhone(phno);
		managecontactpage.updateEmail(email);
		managecontactpage.updateAddress(addres);
		managecontactpage.updateDeliveryTime(time);
		managecontactpage.updateDeliveryCharge(charge);
		managecontactpage.clickUpdate();
		boolean alertmsg = managecontactpage.viewAlert();
		Assert.assertTrue(alertmsg,Constant. ALERT_MSG_DISPLAY);
	}

	@Test(retryAnalyzer = retry.Retry.class,description=" User his able to validate te UPDATE BUTTON in te page")

	public void validateUpdateBtnInManageContact() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		ManageContactUpdateBtnPage managecontactpage = new ManageContactUpdateBtnPage(driver);
		managecontactpage.clickmoreinfo();
		managecontactpage.clickAction();
		boolean alertmsg =managecontactpage.updateBtnEnabled();
		Assert.assertTrue(alertmsg,Constant.UPDATE_BTN);

	}

}
