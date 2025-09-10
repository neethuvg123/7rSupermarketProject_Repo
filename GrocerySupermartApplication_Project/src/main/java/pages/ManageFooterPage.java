package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	public WebDriver driver;
	public ManageFooterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
  @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']") WebElement moreinfo;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1' and @role='button']//child::i")WebElement button;

     @FindBy(xpath="//textarea[@id='content' and @name='address']")WebElement address;
     
     @FindBy(xpath="//input[@id='email']") WebElement email;
     
     @FindBy(xpath="//input[@id='phone']") WebElement phone;
     
     @FindBy(xpath="//button[@type='submit' and @name='Update']") WebElement updatebutton;

     
     @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alerts;

public void clickMoreInfo()
{
	moreinfo.click();
}

public void clickButton()
{
	button.click();
}

public void updateAddress(String addres)
{
	address.clear();
	address.sendKeys(addres);
}

public void updateEmail(String emailid)
{
	email.clear();
	email.sendKeys(emailid);
}


public void updatePhone(String number)
{
	phone.clear();
	phone.sendKeys(number);
}

public void clickUpdateButton()
{
	updatebutton.click();
}

public boolean alertViewAlertMessage()
{
	return alerts.isDisplayed();
}
}
