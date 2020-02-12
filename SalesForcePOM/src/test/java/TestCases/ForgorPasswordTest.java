package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseSF;
import Data.ReadData;
import Pages.CheckYourEmail;
import Pages.ForgotPasswordPage;
import Pages.HomePageSF;
import Pages.loginPage;
import Utility.Resuable;

public class ForgorPasswordTest extends baseSF{

	
		Resuable reuse = new Resuable();
		 static ReadData rd;
			static loginPage lp;
			HomePageSF hp;
			static ForgotPasswordPage fp;
			static CheckYourEmail cy;
			
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
			public static void TC_4A_forgotPassword() throws Exception {
				//lp=new loginPage();
				fp=new ForgotPasswordPage();
				cy=new CheckYourEmail();
				logger = reports.startTest("TC_4A_forgotPassword()");
				String data[][] = rd.getInputData("C:\\QA_Architect\\SFDC_Project\\SFDC_TestData\\TC_SalesForce_Data.xls","Sheet1");
               lp.forgotPassword("Forgot Password");
               fp.validatePage("ForgotPassword");
               fp.provideUsername(data[2][2], "email");
               fp.continueButton("SendEmail");
               cy.displayMessage(data[5][4]);
	}
}
