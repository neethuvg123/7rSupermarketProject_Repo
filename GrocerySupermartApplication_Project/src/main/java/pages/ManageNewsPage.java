package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement news;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageNewsPage newButtonClick() {
		newbutton.click();
		return this;
	}

	public ManageNewsPage newsTextBox(String msg) {
		news.clear();
		news.sendKeys(msg);
		return this;
	}

	public ManageNewsPage saveButton() {
		save.click();
		return this;
	}

	public boolean alertmsg() {
		return alert.isDisplayed();
	}

}
