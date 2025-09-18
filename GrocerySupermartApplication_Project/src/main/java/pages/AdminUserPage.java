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

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	public AdminUserPage clickNewButton() {
		newButton.click();
		return this;
	}

	public AdminUserPage updateUserame(String username) {
		usernametextbox.sendKeys(username);
		return this;
	}

	public AdminUserPage updatePassword(String password) {
		passwordtextbox.sendKeys(password);
		return this;
	}

	public AdminUserPage enterOption() {
		PageUtility page = new PageUtility();
		page.selectByVisibleText(selectoption, "Staff");
		return this;
	}

	public AdminUserPage clickSave() {
		savebutton.click();
		return this;
	}

	public boolean isViewAlertmsg() {
		return alerts.isDisplayed();
	}

}
