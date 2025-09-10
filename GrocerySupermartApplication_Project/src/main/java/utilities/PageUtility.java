package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	//dropdown
	
	
			public void selectByVisibleText(WebElement element,String visibleText) {
				Select select =new Select(element);
				select.selectByVisibleText(visibleText);
				
			}
			
			
			
			public void selectByValue(WebElement element,String value) {
				Select select =new Select(element);
				select.selectByVisibleText(value);	
			}
			
			
			public void selectByIndex(WebElement element,int index) {
				Select select =new Select(element);
				select.selectByIndex(index);	
			}
			
			
			//mouse actions
			
			public void DragAndDropmouseActions(WebDriver driver,WebElement source,WebElement target) {
				Actions action=new Actions(driver);
				action.dragAndDrop(source,target).perform();
				
			}
			
			
			public void rightClick(WebDriver driver)
			{
				
			Actions action=new Actions(driver);
			action.contextClick().perform();
			
			}
			
			
			public void mouseHover(WebDriver driver,WebElement target)
			{
				
			Actions action=new Actions(driver);
			action.moveToElement(target).perform();
			
			}
			
			
			public void doubleClick(WebDriver driver,WebElement target)
			{
				
			Actions action=new Actions(driver);
			action.doubleClick(target).perform();
			
			}
			
			public void actionClick(WebDriver driver,WebElement target)
			{
				
			Actions action=new Actions(driver);
			action.click(target).perform();;
			
			}
			//javascript executor :-scrolling
			
			public void scrollBy(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			}
			
			
			public void scrollFromTop(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
			}
			
			
			
			public void scrollFromBottom(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-150)", "");
			}
			
			
			//javascript executor :- sndkeys and click
			
			public void sendKeysclick(WebDriver driver,WebElement element,String Value) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value='Value';",element );
			}
			
			
			public void javaScriptclick(WebDriver driver,WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",element );
			}
			
		

}
