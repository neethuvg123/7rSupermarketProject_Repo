package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageFooterPage {
	public WebDriver driver;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1' and @role='button']//child::i")
	WebElement button;

	@FindBy(xpath = "//textarea[@id='content' and @name='address']")
	WebElement address;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;

	@FindBy(xpath = "//button[@type='submit' and @name='Update']")
	WebElement updatebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	public ManageFooterPage clickButton() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, button);
		return this;
	}

	public ManageFooterPage updateAddress(String addres) {
		WaitUtility wait= new WaitUtility();
		wait.waitForElementToBeClickable(driver,address );
		address.clear();
		address.sendKeys(addres);
		return this;
	}

	public ManageFooterPage updateEmail(String emailid) {
		email.clear();
		email.sendKeys(emailid);
		return this;
	}

	public ManageFooterPage updatePhone(String number) {
		phone.clear();
		phone.sendKeys(number);
		return this;
	}

	public ManageFooterPage clickUpdateButton() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, updatebutton);
		// updatebutton.click();
		return this;
	}

	public boolean isAlertViewAlertMessage() {
		return alerts.isDisplayed();
	}

	public boolean isUpdateButonEnabled() {
		return updatebutton.isEnabled();
	}

}
