package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public Homepage homepage;
	
	public WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*@FindBy(xpath="//input[@name='username']")private WebElement Username;
	@FindBy(xpath="//input[@type='password']")private WebElement Password;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")private WebElement Signin;*/
	@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement Adminicon;
	@FindBy(xpath="//a[@class='dropdown-item'][2]")private WebElement logout;
	@FindBy(xpath="//b[text()='7rmart supermarket']")private WebElement title;
	
	
	public Homepage clickadminicon()
	{
		Adminicon.click();
		return this;
	}
	
	public Loginpage clicklogoutbutton()
	{
		logout.click();
		return new Loginpage(driver);
	}
	public boolean istitledisplayed()
	{
		return title.isDisplayed();
	}
	
	public String  gettitletext()
	{
		return title.getText();
	}

}
