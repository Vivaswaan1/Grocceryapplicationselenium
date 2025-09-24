package test;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import automationcore.Testngbase;
import constants.Constant;
import page.Adminuserspage;
import page.Homepage;
import page.Loginpage;
import page.Managenewspage;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends Testngbase {
	public Managenewspage managenewspage;
	public Homepage homepage;
	


	@Test(priority=2, description="user able to add new news title",groups= {"smoke"},retryAnalyzer=retryAnalyzer.Retry.class)
	public void verifyWhetherUserIsAbleToAddNewNewsTitle() throws IOException {
		String UserName=ExcelUtility.getStringData(1, 0, "Login");
		String password=ExcelUtility.getStringData(1, 1, "Login");
		Loginpage login=new Loginpage(driver);
		login.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password);
		homepage=login.clicksignin();
		
		Managenewspage managenews=new Managenewspage(driver);
		managenewspage=managenews.clickonmoreinfo().clickonnewbutton();
		String Text=ExcelUtility.getStringData(1, 0, "Manageuser");
		managenews.enterthetextonnewsinfofield(Text).clickonsavebutton();
		
		boolean successalertdisplayed=managenews.issuccessalertdisplayed();
		Assert.assertTrue(successalertdisplayed,Constant.NEWSNOTCREATED);

	}

	@Test(priority=1, description="user able to search new news title",groups= {"regression"})
	public void verifySearchForNewNewsTitle() throws IOException {
		String UserName=ExcelUtility.getStringData(1, 0, "Login");
		String password=ExcelUtility.getStringData(1, 1, "Login");
		Loginpage login=new Loginpage(driver);
		login.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password);
		homepage=login.clicksignin();
		
		Managenewspage searchnews=new Managenewspage(driver);
		managenewspage=searchnews.clickonmoreinfo().clickonsearch();
		
		String Text=ExcelUtility.getStringData(1, 0, "Manageuser");
		searchnews.entertexttosearch(Text).performsearchusingbutton();
		
		boolean searchdisplay=searchnews.issearchedvaluedisplayed();
		Assert.assertTrue(searchdisplay, Constant.NEWSUNABLETOSEARCH);
	}

	@Test(priority=3, description="user able to reset new news title",groups= {"sanity","regression"},dataProvider="loginProvider")
	public void verifyResetButtonFunctionality(String UserName, String password) throws IOException {
	
		/*String UserName=ExcelUtility.getStringData(1, 0, "Login");
		String password=ExcelUtility.getStringData(1, 1, "Login");*/
		Loginpage login=new Loginpage(driver);
		login.enterUsernameOnUsernameField(UserName).enterpasswordonpasswordfield(password);
		homepage=login.clicksignin();
		
		Managenewspage resetnews=new Managenewspage(driver);
		managenewspage=resetnews.clickonmoreinfo().clickresetbutton();
		
		boolean titledisplayafterreset=resetnews.istitledisplayedforreset();
		Assert.assertTrue(titledisplayafterreset,Constant.NEWSNOTRESETTED);
		
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

