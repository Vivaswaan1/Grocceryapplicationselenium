package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement Username;
	@FindBy(name = "password")
	private WebElement  Password;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")private WebElement Signin;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement Dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement Alertmessage;
	@FindBy(xpath="//b[text()='7rmart supermarket']")private WebElement title;
	@FindBy(xpath="//a[text()='Home']")private WebElement Home;
	
	public Loginpage enterUsernameOnUsernameField(String UserName) {

		Username.sendKeys(UserName);
		return this;
		

	}

	
	public Loginpage enterpasswordonpasswordfield(String password)
	{
		Password.sendKeys(password);
		return this;
		
	}
	public Homepage clicksignin()
	{
		Signin.click();
		return new Homepage(driver);
	}
	
	public boolean isDisplayed()
	{
		return Dashboard.isDisplayed();
		
	}
	public boolean isalertmessagedisplayed()
	{
		return Alertmessage.isDisplayed();
	}
	
	public String getlogintitle()
	{
		return title.getText();
	}
	public String gettexthome()
	{
		return Home.getText();
	}
	
	
	
}
	
	
	
	


