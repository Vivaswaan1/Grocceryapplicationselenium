package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import automationcore.Testngbase;
import constants.Constant;
import page.Adminuserspage;
import page.Homepage;
import page.Loginpage;
import utilities.ExcelUtility;

public class Adminuserstest extends Testngbase {
	
	public Homepage homepage;
	public Adminuserspage adminuserspage;
	@Test(priority=2,description="To add a new user",retryAnalyzer=retryAnalyzer.Retry.class)
	public void verifyiftheuserisabletoaddnewuser() throws IOException
	{   
		String UserName=ExcelUtility.getStringData(1, 0, "Login");
		String password=ExcelUtility.getStringData(1, 1, "Login");
		Loginpage login=new Loginpage(driver);
		login.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password);
		homepage=login.clicksignin();
		
		Adminuserspage adduser=new Adminuserspage(driver);
		adminuserspage=adduser.clickmoreinfo().clicknewbutton();
		
		
		String userName=ExcelUtility.getStringData(2, 0, "Adminnewuser");
		String passWord=ExcelUtility.getStringData(2, 1, "Adminnewuser");
		adduser.enterusernameonusernamefield(userName).enterpasswordonpasswordfield(passWord).selectusertypevaluefromdropdown().clickonsavebutton();
		
		
		
		boolean alertdisplay=adduser.isstatusdisplayed();
		Assert.assertTrue(alertdisplay,Constant.NEWUSERNOTADDED);
		
		/*String headingdisplay=adduser.getalerttext();
		Assert.assertEquals(headingdisplay, "Admin Users");*/
		}
	@Test(priority=1,description="searchforanewuserafteradding",retryAnalyzer=retryAnalyzer.Retry.class)
	public void verifyiftheuserisabletosearchfornewuser() throws IOException
	{    
		String UserName=ExcelUtility.getStringData(1, 0, "Login");
		String password=ExcelUtility.getStringData(1, 1, "Login");
		Loginpage login=new Loginpage(driver);
		login.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password);
	homepage=	login.clicksignin();
		
		Adminuserspage searchnewuser=new Adminuserspage(driver);
	adminuserspage=	searchnewuser.clickmoreinfo().clickonsearchbutton();
		
		String userName=ExcelUtility.getStringData(2, 0, "Adminnewuser");
		/*Faker faker=new Faker();
		String userName=faker.lorem().sentence();*/
		searchnewuser.Enterthetextonsearchfield(userName).selectusertype().clicksearch();
		
		boolean newusersearch=searchnewuser.isthesearchresultdisplayed();
		Assert.assertTrue(newusersearch,Constant.UNABLETOSEARCHFORUSER);
		
		/*String searchusertext=searchnewuser.getsearchtext();
		Assert.assertEquals(searchusertext, "hen");*/
		
		
		
		
	}
	
	/*@DataProvider(name = "loginProvider") // Any name can be given
	public Object[][] getDataFromDataProvider() throws IOException 
	{ // userdefined method

		return new Object[][] {  new Object[]{"admin","admin"}//pairs of user name and password.
																//Both pairs will be executed here. More pairs can be added
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		
	};*/
	
	
	

}
