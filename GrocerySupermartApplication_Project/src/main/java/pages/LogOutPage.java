package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	public WebDriver driver;
	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown'] ") WebElement admin;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item'] ") WebElement logout;
	
	@FindBy(xpath="//button[text()='Sign In']") WebElement signin;
	
	
	public void clickAdmin()
	{
		admin.click();
	}
	
	public void clickLogout()
	{
				
		logout.click();
	}
	
	public boolean isViewSignin()
	{
		return signin.isDisplayed();
	}

}
