package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add' and @onclick='click_button(1)']")
	WebElement newbutton;

	@FindBy(xpath = "//input[@id='category']")
	WebElement category;

	@FindBy(xpath = "//ul[@class='ms-list']//child::li[@id='134-selectable']")
	WebElement selectgroup;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;

	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	WebElement yesbutton;

	@FindBy(xpath = "//input[@value='no' and @name='show_home']")
	WebElement radiobutton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public ManageCategoryPage newbutton() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage category(String value) {
		category.sendKeys(value);
		return this;
	}

	public ManageCategoryPage groupselect() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, selectgroup);
		return this;
	}

	public ManageCategoryPage choosefile() {
		yesbutton.click();
		FileUploadUtility file = new FileUploadUtility();
		file.fileUploadUsingSendKeys(choosefile, Constant.TESTDATAIMAGE4);
		return this;
	}

	public ManageCategoryPage clickTopMenu() {
		PageUtility page = new PageUtility();
		page.scrollFromTop(driver);
		page.javaScriptclick(driver, yesbutton);
		return this;
	}

	public ManageCategoryPage clickSowHome() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, radiobutton);
		return this;
	}

	public ManageCategoryPage saveButton() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, save);
		return this;
	}

	public boolean isViewAlert() {
		return alert.isDisplayed();
	}
}
