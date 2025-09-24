package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}
	
	public void selectDropdownWithValue(WebElement element, String Value) {

		Select select = new Select(element);
		select.selectByValue(Value);

	}
	
	public void selectDropdownbyvisibletext(WebElement element, String Value) {

		Select select=new Select(element);
		select.selectByContainsVisibleText(Value);

	}
	

	public void javaScriptClickAction(WebDriver driver, String showMessageButton)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;  // creating reference for the Interface
		js.executeScript("arguments[0].click();", showMessageButton);
	}
	
	
	public void javaScriptScrollUpOrDown(WebDriver driver, int xAxis, int yAxis)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(xAxis,yAxis)", "");
	}
	public void rightClickonElement(WebDriver driver, WebElement element)
	{	
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}	
	
	public void mouseHoverOnElement(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void dragAndDropAnElement(WebDriver driver, WebElement dragMe, WebElement dropMe)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(dragMe, dropMe).build().perform();
	}

}
		

	


