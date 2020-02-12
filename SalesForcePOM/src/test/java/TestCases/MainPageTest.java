package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseSF;
import Data.ReadData;
import Pages.HomePageSF;
import Pages.loginPage;
import Utility.Resuable;

public class MainPageTest extends baseSF{
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
		
		@Test
	public static void TC_05_SelectUserMenu() throws Exception {
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
	
	
}
