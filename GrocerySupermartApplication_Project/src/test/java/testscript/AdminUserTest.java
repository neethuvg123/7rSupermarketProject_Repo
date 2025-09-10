package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	@Test(description = "user is able to access te Admin User Page",retryAnalyzer = retry.Retry.class)

	public void verifyUserIsAbletoClickAdminUser() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickMoreInfo();
		adminuserpage.clickNewButton();
		//String usernames = ExcelUtility.getStringData(4, 0, "AdminUser");
		//String passwords = ExcelUtility.getIntegerData(4, 1, "AdminUser");
		
		FakerUtility faker=new FakerUtility();
		String usernames=faker.creatARandomFirstName();
		String passwords=faker.creatARandomLastName();
		adminuserpage.updateUserame(usernames);
		adminuserpage.updatePassword(passwords);
		adminuserpage.enterOption();
		adminuserpage.clickSave();
		boolean msg = adminuserpage.viewAlertmsg();
		
		Assert.assertTrue(msg,Constant.ADMIN_USER_PAGE);
	}

}
