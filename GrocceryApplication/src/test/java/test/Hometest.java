package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import automationcore.Testngbase;
import constants.Constant;
import page.Homepage;
import page.Loginpage;
import utilities.ExcelUtility;

public class Hometest extends Testngbase {
	
	public Homepage homepage;
	public Loginpage loginpage;
	@Test(priority=1,description="user logged out successfully",groups= {"smoke"},dataProvider="loginProvider")
	public void Verifyusercansuccessfullylogout(String UserName, String password) throws IOException
	{  
		/*String UserName=ExcelUtility.getStringData(1, 0, "Login");
		String password=ExcelUtility.getStringData(1, 1, "Login");*/
		/*Faker faker=new Faker();
		String UserName=faker.name().username();
		String password=faker.internet().password();*/
		
		
	
		Loginpage login=new Loginpage(driver);
		login.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password);
		
homepage= login.clicksignin();
		//explicit wait
		
		
		
		Homepage homepage=new Homepage(driver);
		homepage.clickadminicon();
		loginpage=homepage.clicklogoutbutton();
		
		boolean logout=homepage.istitledisplayed();
		Assert.assertTrue(logout, Constant.LOGOUTERROR);
		
		/*String titletext=homepage.gettitletext();
		Assert.assertEquals(titletext,"7rmart supermarket");*/
		
	}
	
	@DataProvider(name = "loginProvider") // Any name can be given
	public Object[][] getDataFromDataProvider() throws IOException 
	{ // userdefined method

		return new Object[][] {  new Object[]{"admin","admin"}//pairs of user name and password.
																//Both pairs will be executed here. More pairs can be added
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		
	};
	

}}
