package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managenewspage {
	
public WebDriver driver;
	
	public Managenewspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	
	@FindBy(xpath="//p[text()='Manage News']/ancestor::div/a[contains(text(),'More info')]")private WebElement Managenewsmoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement NewManagenews;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enternewsinfo;
	@FindBy(xpath="//button[@type='submit']")private WebElement save;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement search;
	@FindBy(xpath="//input[@name='un']")private WebElement texttosearch;
	@FindBy(xpath="//button[@type='submit']")private WebElement performsearch;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")private WebElement clickreset;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement successalert;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']//tbody/tr[1]")private WebElement searchedmessagedisplayed;
	
	public Managenewspage clickonmoreinfo()
	{
		Managenewsmoreinfo.click();
		return new Managenewspage(driver);
	}
	
	public Managenewspage clickonnewbutton()
	{
		NewManagenews.click();
		return this;
	}
	
	public Managenewspage enterthetextonnewsinfofield(String Text)
	{
		enternewsinfo.sendKeys(Text);
		return this;
	}
	public Managenewspage clickonsavebutton()
	{
		save.click();
		return this;
	}
	
	public Managenewspage clickonsearch()
	{
		search.click();
		return this;
	}
	public Managenewspage entertexttosearch(String Text)
	{
		texttosearch.sendKeys(Text);
		return this;
	}
	
	public Managenewspage performsearchusingbutton()
	{
		performsearch.click();
		return this;
	}
	
	public Managenewspage clickresetbutton()
	{
		clickreset.click();
		return this;
	}
	
	public boolean issuccessalertdisplayed()
	{
	return successalert.isDisplayed();
}
	
	public boolean issearchedvaluedisplayed() 
	{
		return searchedmessagedisplayed.isDisplayed();
	}
	
	public boolean istitledisplayedforreset() {
		return searchedmessagedisplayed.isDisplayed();
	}
	
	
}






