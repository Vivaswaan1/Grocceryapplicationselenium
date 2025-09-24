package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;

public class Adminuserspage {
	
	public WebDriver driver;
	
	public Adminuserspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//p[text()='Admin Users']/ancestor::div/a[contains(text(),'More info')]")private WebElement AdminusersMoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement Newbutton;
	@FindBy(xpath="//input[@id='username']")private WebElement Username;
	@FindBy(xpath="//input[@id='password']")private WebElement Password;
	@FindBy(xpath="//select[@name='user_type']")private WebElement UserType;
	@FindBy(xpath="//button[@name='Create']")private WebElement Savebutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement Searchbutton;
	@FindBy(name = "un")private WebElement entertextforsearch;
	@FindBy(id = "ut")private WebElement selectusertypeforsearch;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")private WebElement clicksearchbutton;
	@FindBy(xpath="//table[contains(@class,'table-bordered')]//tbody/tr[1]/td[3]")private WebElement Newuseradded;
	
	@FindBy(xpath="//table[contains(@class,'table-bordered')]//tbody/tr[1]")private WebElement newusersearched;
	@FindBy(xpath="//table[contains(@class,'table-bordered')]//tbody/tr[1]/td[1]")private WebElement newusersearchvalue;
	@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement newuseralreadyadded;
	
	
	
	
	
	
	
	
	
	public Adminuserspage clickmoreinfo()
	{
		AdminusersMoreinfo.click();
		return new Adminuserspage(driver);
	}
	
	public Adminuserspage clicknewbutton()
	{
		Newbutton.click();
		return this;
	}
	public Adminuserspage enterusernameonusernamefield(String userName)
	{
		Username.sendKeys(userName);
		return this;
	}
	public Adminuserspage enterpasswordonpasswordfield(String passWord)
	{
		Password.sendKeys(passWord);
		return this;
	}
	public Adminuserspage selectusertypevaluefromdropdown()
	{   PageUtility pageutility=new PageUtility();
pageutility.selectDropdownbyvisibletext(UserType, "Admin");
		/*Select select=new Select(UserType);
		select.selectByContainsVisibleText("Admin");*/
		return this;
		
	}
	public Adminuserspage clickonsavebutton()
	{ 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(Savebutton));
		Savebutton.click();
		return this;
}
	public Adminuserspage clickonsearchbutton()
	{
		Searchbutton.click();
		return this;
	}
	
	public Adminuserspage Enterthetextonsearchfield(String userName)
	{
		entertextforsearch.sendKeys(userName);
		return this;
		
	}
	public Adminuserspage selectusertype()
	{
		Select selectusertype=new Select(selectusertypeforsearch);
		selectusertype.selectByVisibleText("Admin");
		return this;
	}
	
	public Adminuserspage clicksearch()
	{
		clicksearchbutton.click();
		return this;
	}
	
	
	public boolean isthesearchresultdisplayed()
	{
		return newusersearched.isDisplayed();
	}
	
	public String getalerttext()
	{
		return newuseralreadyadded.getText();
	}
	public String getsearchtext()
	{
		return newusersearchvalue.getText();
	}
	public boolean isstatusdisplayed()
	{
		return Newuseradded.isDisplayed();
	}
	
	
	
	
	
	
}
