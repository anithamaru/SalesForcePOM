package TestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.baseSF;
import Data.ReadData;
import Pages.HomePageSF;
import Pages.loginPage;
import Utility.Resuable;

public class loginPageTest extends baseSF{
	static Resuable reuse = new Resuable();
	 static ReadData rd;
		static loginPage lp;
		static HomePageSF hp;
		
		@BeforeMethod
		public void setUp() throws Throwable {
			initializeDriver();
			Reporting();
			reuse.launchURL();
			
			lp=new loginPage();
			rd=new ReadData();
		}
		@AfterMethod
		public static void TearDown() throws InterruptedException {
			Thread.sleep(3000);
			baseSF.Report_Close();
			driver.quit();

		}
		//@Test
		public static void TC_01_loginErrorMessage() throws Throwable {
			rd=new ReadData();
			logger=reports.startTest("TC_01_loginErrorMessage");
			//String data[][] = rd.getInputData(prop.getProperty("xlPath"),"Sheet1");
			String data[][] = rd.getInputData("C:\\QA_Architect\\SFDC_Project\\SFDC_TestData\\TC_SalesForce_Data.xls","Sheet1");
			//"C:\QA_Architect\SFDC_Project\SFDC_TestData\TC_SalesForce_Data.xls"
			String username_Data = data[1][2];
			System.out.println(data[1][2]);
			//String username_Data = "anitham2u@gmail.com";
			lp.getUsername(username_Data, "Username");
			String password_Data = data[1][3];
			//String password_Data ="";
			lp.getPassword(password_Data, "Password");
			lp.getButton("Login");
			lp.getUsernameVerify();
			String msg="Please enter your password.";
			//data[1][4]
			lp.getErrorMessage(msg);
			
	}
		@Test
		public static void TC_02_loginToSFDC() throws Exception {
			hp=new HomePageSF();
			logger = reports.startTest("TC_02_loginToSFDC");
			String data[][] = rd.getInputData("C:\\QA_Architect\\SFDC_Project\\SFDC_TestData\\TC_SalesForce_Data.xls","Sheet1");

			//String data[][] = rd.getInputData(prop.getProperty("xlPath"),"Sheet1");
			String username_Data = data[2][2];
			lp.getUsername(username_Data, "Username");
			String password_Data = data[2][3];
			lp.getPassword(password_Data, "Password");
			lp.getButton("Login");
			
			
			
		}
		//@Test
		public static void TC_03_rememberMeCheckBox() throws Exception {
			hp=new HomePageSF();
			logger = reports.startTest("TC_03_rememberMeCheckBox");
			String data[][] = rd.getInputData("C:\\QA_Architect\\SFDC_Project\\SFDC_TestData\\TC_SalesForce_Data.xls","Sheet1");

			//String data[][] = rd.getInputData(prop.getProperty("xlPath"),"Sheet1");
			String username_Data = data[2][2];
			lp.getUsername(username_Data, "Username");
			String password_Data = data[2][3];
			lp.getPassword(password_Data, "Password");
			
			lp.getRememberMe("RememeberMe");
			lp.getButton("Login");
			//String title="Home Page ~ Salesforce - Developer Edition";
			hp.VerifyTitle(data[3][4]);
			hp.getButton("User Menu");
			hp.LogoutButton("Logout");
			Thread.sleep(4000);
			lp.VerifyTitle(data[2][4]);
	lp.getUsernameVerify();
			
		}
		@Test
		public static void TC_4B_validateLoginErrorMessage() throws Exception {
			hp=new HomePageSF();
			logger = reports.startTest("TC_4B_validateLoginErrorMessage");
			String data[][] = rd.getInputData("C:\\QA_Architect\\SFDC_Project\\SFDC_TestData\\TC_SalesForce_Data.xls","Sheet1");
			String username_Data = data[6][2];
			lp.getUsername(username_Data, "Username");
			String password_Data = data[6][3];
			lp.getPassword(password_Data, "Password");
			lp.getButton("Login");
			lp.getErrorMessage(data[6][4]);
		}
}
