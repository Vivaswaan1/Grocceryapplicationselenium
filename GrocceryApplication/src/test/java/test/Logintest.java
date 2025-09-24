package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import automationcore.Testngbase;
import constants.Constant;
import page.Homepage;
import page.Loginpage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class Logintest extends Testngbase {
	public Homepage homepage;
	@Test(priority=1,description="successful login using valid creds",groups= {"smoke","regression"}, retryAnalyzer=retryAnalyzer.Retry.class)
	public void verifylogintestvalidcredentials() throws IOException
	{
		Loginpage validcreds=new Loginpage(driver);
		String UserName = ExcelUtility.getStringData(1, 0, "Login");
		String password = ExcelUtility.getStringData(1, 1, "Login");
		
		
		
		validcreds.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password);
		homepage=validcreds.clicksignin();
	}
	
	@Test(priority=2,description="unsuccessful login using invalid username",groups= {"regression"},retryAnalyzer=retryAnalyzer.Retry.class)
	public void verifytestcredentialsusinginvalidusername() throws IOException
	{
		/*Faker faker=new Faker();
		String UserName=faker.name().username();
		String password = ExcelUtility.getStringData(2, 1, "Login");*/
	
	  String UserName = ExcelUtility.getStringData(2, 0, "Login");
	String password = ExcelUtility.getStringData(2, 1, "Login");
		Loginpage invalidusername=new Loginpage(driver);
		invalidusername.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password).clicksignin();
		
		
		boolean alertforinvalidusername=invalidusername.isalertmessagedisplayed();
		Assert.assertTrue(alertforinvalidusername,Constant.INVALIDUSERNAMEERROR);
		/*String alertmessage=invalidusername.getlogintitle();
		Assert.assertEquals(alertmessage, "7rmart supermarket");*/
	}
	@Test(priority=3,description="unsuccessful login using invalid password",groups={"smoke"})
	public void verifytestcredentialsusinginvalidpassword() throws IOException
	{
		String UserName = ExcelUtility.getStringData(3, 0, "Login");
		String password = ExcelUtility.getStringData(3, 1, "Login");
		Loginpage invalidpassword=new Loginpage(driver);
		invalidpassword.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password).clicksignin();
		
		
		
		boolean alertmessageforinvalidpassword=invalidpassword.isalertmessagedisplayed();
		Assert.assertTrue(alertmessageforinvalidpassword,Constant.INVALIDPASSWORDERROR);
		
		
		/*String logintitletext=invalidpassword.getlogintitle();
		Assert.assertEquals(logintitletext, "7rmart supermarket");*/
	}
	@Test(priority=4,description="unsuccessful login using invalid creds",dataProvider="loginProvider")
	public void verifytestusinginvalidcredentials(String UserName, String password) throws IOException
	{   /*Faker faker=new Faker();
	   String UserName=faker.name().username();
	   String password=faker.internet().password();*/
		/*String UserName = ExcelUtility.getStringData(4, 0, "Login");
	String password = ExcelUtility.getStringData(4, 1, "Login");*/
		Loginpage invalidcreds=new Loginpage(driver);
		invalidcreds.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password).clicksignin();
		
		
		/*String getheading=invalidcreds.getlogintitle();
		Assert.assertEquals(getheading, "7rmart supermarket");*/
		
	    boolean alertmessageforinvalidcreds=invalidcreds.isalertmessagedisplayed();
	    Assert.assertTrue(alertmessageforinvalidcreds,Constant.INVALIDCREDENTIALERROR);
	    
	    
	    
	}
	@DataProvider(name = "loginProvider") // Any name can be given
	public Object[][] getDataFromDataProvider() throws IOException 
	{ // userdefined method

		return new Object[][] {  new Object[]{"admin123","admin123"}//pairs of user name and password.
																//Both pairs will be executed here. More pairs can be added
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		
	};
	}

}
