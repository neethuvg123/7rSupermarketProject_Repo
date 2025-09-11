package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement actionbutton;
	
	@FindBy(xpath = "//input[@type='text' and @id='phone']")
	WebElement phone;

	@FindBy(xpath = "//input[@type='text' and @id='email']")
	WebElement email;

	@FindBy(xpath = "//textarea[@name='address' and @id='content']")
	WebElement address;

	@FindBy(xpath = "//textarea[@name='del_time' and @id='content']")
	WebElement delivtime;

	@FindBy(xpath = "//input[@type='text' and @name='del_limit']")
	WebElement delivcharge;

	@FindBy(xpath = "//button[@type='submit' and @name='Update']")
	WebElement buton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;
	
	public ManageContactPage clickAction() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver,actionbutton);
		//actionbutton.click();
		return this;
	}

	public ManageContactPage updatePhone(String phonno) {
		phone.clear();
		phone.sendKeys(phonno);
		return this;
	}

	public ManageContactPage updateEmail(String emailid) {
		email.clear();
		email.sendKeys(emailid);
		return this;
	}

	public ManageContactPage updateAddress(String add) {
		address.clear();
		address.sendKeys(add);
		return this;
	}

	public ManageContactPage updateDeliveryTime(String time) {
		delivtime.clear();
		delivtime.sendKeys(time);
		return this;
	}

	public ManageContactPage updateDeliveryCharge(String charges) {
		PageUtility page = new PageUtility();
		page.scrollFromTop(driver);
		delivcharge.clear();
		delivcharge.sendKeys(charges);
		return this;
	}

	public ManageContactPage clickUpdate() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver,buton);
		return this;
	}

	public boolean viewAlert() {
		return alerts.isDisplayed();
	}

	public boolean updateBtnEnabled() {
		return buton.isEnabled();
	}
}
