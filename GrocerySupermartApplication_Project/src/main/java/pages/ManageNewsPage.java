package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searcbutton;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement textbox;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searcbutton2;

	@FindBy(xpath = "//td[text()='grocery supermarket testcase']")
	WebElement actionbutton;

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textareanews;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement updatebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> tabledatas;

	@FindBy(xpath = "//a[text()='Next']")
	WebElement paginateNext;

	@FindBy(xpath = "./td[2]//a[contains(@href,'edit')]")
	WebElement editBtn;

	@FindBy(xpath = "./td[1]")
	WebElement searchData;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement news;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageNewsPage searcButtonClick() {
		searcbutton.click();
		return this;
	}

	public ManageNewsPage enterSearcMsg(String msgs) {
		textbox.sendKeys(msgs);
		return this;
	}

	public ManageNewsPage searcButtonClicks() {
		searcbutton2.click();
		return this;
	}

	public ManageNewsPage updateNews(WebDriver driver, String msgs, String msg) throws Exception {
		boolean found = false;
		while (!found) {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			for (WebElement row : rows) {
				WebElement newsCol = row.findElement(By.xpath("./td[1]"));
				if (newsCol.getText().equalsIgnoreCase(msgs)) {
					WebElement editBtn = row.findElement(By.xpath("./td[2]//a[contains(@href,'edit')]"));
					editBtn.click();
					textareanews.clear();
					textareanews.sendKeys(msg);
					updatebutton.click();
					found = true;
					break;
				}
			}
			if (!found) {
				try {
					if (paginateNext.isDisplayed() && paginateNext.isEnabled()) {
						paginateNext.click();
					} else {
						throw new RuntimeException("News not found in any page!");
					}
				} catch (NoSuchElementException e) {
					throw new RuntimeException("Pagination ended. News not found: " + msg);
				}
			}
		}
		return this;
	}

	public boolean isAlertMsgDisplay() {
		return alerts.isDisplayed();
	}

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

	public boolean isViewAlertmsg() {
		return alert.isDisplayed();
	}

}
