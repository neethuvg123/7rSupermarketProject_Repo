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

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement moreinfo;

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

	public void moreinfo() {
		moreinfo.click();
	}

	public void newbutton() {
		newbutton.click();
	}

	public void category(String value) {

		category.sendKeys(value);
	}

	public void groupselect() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, selectgroup);
	}

	public void choosefile() {
		yesbutton.click();
		FileUploadUtility file = new FileUploadUtility();
		file.fileUploadUsingSendKeys(choosefile, Constant.TESTDATAIMAGE4);
	}

	public void clickTopMenu() {
		PageUtility page = new PageUtility();
		page.scrollFromTop(driver);
		page.javaScriptclick(driver, yesbutton);
	}

	public void clickSowHome() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, radiobutton);
	}

	public void saveButton() {
		PageUtility page = new PageUtility();
		page.javaScriptclick(driver, save);
	}

	public boolean viewAlert() {
		return alert.isDisplayed();
	}
}
