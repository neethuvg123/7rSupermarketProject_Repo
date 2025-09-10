package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
@FindBy(xpath="//input[@type='text']")WebElement admin;
	
	@FindBy(xpath="//input[@type='password']") WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']") WebElement signin;
	
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alerts;
	
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterUsername(String username)
	{
		admin.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password2)
	{
		password.sendKeys(password2);
		return this;
	}
	
	public LogOutPage clickSignin()
	{
		signin.click();
		return new LogOutPage(driver);
	}
	
	public boolean isdashboardView()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertmessageDisplayed()
	{
		return alerts.isDisplayed();
	}
	
	

}
