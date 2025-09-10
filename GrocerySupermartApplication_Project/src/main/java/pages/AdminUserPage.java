package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserPage {
	
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement moreinfo;

	@FindBy(xpath = "//a[@href='javascript:void(0)']//child::i")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement usernametextbox;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordtextbox;

	@FindBy(xpath = "//select[@class='form-control' and @name='user_type']")
	WebElement selectoption;

	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	WebElement savebutton;

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	public void clickMoreInfo() {
		moreinfo.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void updateUserame(String username) {
		usernametextbox.sendKeys(username);
	}

	public void updatePassword(String password) {
		passwordtextbox.sendKeys(password);
	}

	public void enterOption() {
		PageUtility page = new PageUtility();
		page.selectByVisibleText(selectoption, "Staff");
	}

	public void clickSave() {
		savebutton.click();
	}

	public boolean viewAlertmsg() {
		return alerts.isDisplayed();
	}

}
