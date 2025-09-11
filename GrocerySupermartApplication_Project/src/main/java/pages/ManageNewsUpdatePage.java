package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;


public class ManageNewsUpdatePage {

	public WebDriver driver;

	public ManageNewsUpdatePage(WebDriver driver) {
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

	public ManageNewsUpdatePage searcButtonClick() {
		searcbutton.click();
		return this;
	}

	public ManageNewsUpdatePage enterSearcMsg(String msgs) {
		textbox.sendKeys(msgs);
		return this;
	}

	public ManageNewsUpdatePage searcButtonClicks() {
		searcbutton2.click();
		return this;
	}

	public ManageNewsUpdatePage tableSerach() {
		for (WebElement tabledata : tabledatas) {
			if (tabledata.getText().equalsIgnoreCase("health")) {
				// actionbutton.click();
				PageUtility page = new PageUtility();
				page.javaScriptclick(driver, actionbutton);
			}
		}
		return this;
	}

	
	 /* public void actionButonClick() {
	 * 
	 * //actionbutton.click(); PageUtility page=new PageUtility();
	 * page.javaScriptclick(driver, actionbutton); }
	 */

	public ManageNewsUpdatePage enterTextMsg(String msgs) {
		textareanews.clear();
		textareanews.sendKeys(msgs);
		return this;
	}

	public ManageNewsUpdatePage clickUpdateButon() {
		updatebutton.click();
		return this;
	}

	public boolean alertMsgDisplay() {
		return alerts.isDisplayed();
	}
}
