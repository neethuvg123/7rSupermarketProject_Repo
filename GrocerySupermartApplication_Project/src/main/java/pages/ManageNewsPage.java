package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//@FindBy(xpath="//div[@class='row']//div[7]//a") WebElement moreinfo;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
	
	@FindBy(xpath="//textarea[@id='news']") WebElement news;
	
	@FindBy(xpath="//button[text()='Save']") WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	
	/*public void moreInfo() {
		moreinfo.click();
	}*/
	
	
	public void newButtonClick()
	{
		newbutton.click();
	}
	
	public void newsTextBox(String msg)
	{
		news.clear();
		news.sendKeys(msg);
	}
	
	public void saveButton()
	{
		save.click();
	}
	
	public boolean alertmsg()
	{
		return alert.isDisplayed();
	}

}
