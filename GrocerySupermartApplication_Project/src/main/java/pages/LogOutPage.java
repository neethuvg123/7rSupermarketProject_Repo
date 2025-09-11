package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

	public WebDriver driver;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement moreinfo_adminPage;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement moreinfo_manageCategory;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	WebElement moreinfo_manageContact;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement moreinfo_manageFooter;

	@FindBy(xpath = "//div[@class='row']//div[7]//a")
	WebElement moreinfo_manageNews;

	@FindBy(xpath = "//div[@class='row']//div[7]//a")
	WebElement moreinfo_manageNewsUpdate;

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown'] ")
	WebElement admin;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item'] ")
	WebElement logout;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;

	public AdminUserPage moreinfo_AdminPage() {
		moreinfo_adminPage.click();
		return new AdminUserPage(driver);

	}

	public ManageCategoryPage moreinfo_manageCategoryPage() {
		moreinfo_manageCategory.click();
		return new ManageCategoryPage(driver);
	}

	public ManageContactPage moreinfo_manageContactPage() {
		moreinfo_manageContact.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterPage moreinfo_manageFooterpage() {
		moreinfo_manageFooter.click();
		return new ManageFooterPage(driver);
	}

	public ManageNewsPage moreinfo_manageNewsPage() {
		moreinfo_manageNews.click();
		return new ManageNewsPage(driver);
	}

	public ManageNewsUpdatePage moreinfo_manageNesUpdatePage() {
		moreinfo_manageNewsUpdate.click();
		return new ManageNewsUpdatePage(driver);
	}

	public void clickAdmin() {
		admin.click();
	}

	public void clickLogout() {
		logout.click();
	}

	public boolean isViewSignin() {
		return signin.isDisplayed();
	}

}
