package Utility;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.baseSF;

public class Resuable extends baseSF {
	// public static ExtentTest logger;
	public void launchURL() throws Throwable {

		// baseSF.initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		//logger.log(LogStatus.PASS, "The Browser is launched");
	}

	public void enterData(WebElement Obj, String input, String text_name) {
		if (Obj.isDisplayed() == true) {
			if (Obj.isEnabled() == true) {
				Obj.sendKeys(input);
				logger.log(LogStatus.PASS, input + " is entered in the " + text_name);

			} else {
				logger.log(LogStatus.FAIL, text_name + " button was not enabled");

			}
		} else {
			logger.log(LogStatus.FAIL, text_name + " button was not displayed");

		}
	}
public void verifyText(WebElement Obj, String value) {
	String actual=Obj.getAttribute("value");
	if(actual.equals(value)) {
		logger.log(LogStatus.PASS, value+" entered correct value");
	}else
		logger.log(LogStatus.FAIL, value+" NOT entered correct value");

		
}
	public void clickButton(WebElement Obj, String text_name) throws InterruptedException {
		Thread.sleep(4000);
		if (Obj.isDisplayed() == true) {
			Obj.click();
			logger.log(LogStatus.PASS, text_name + " is clicked");
		} else
			logger.log(LogStatus.FAIL, text_name + " is NOT clicked");
	}

	public void validateText(WebElement Obj, String msg) {
		String actual = Obj.getText();
		Assert.assertEquals(actual, msg);
		logger.log(LogStatus.PASS, msg + " Text is displayed as expected ");

	}

	public void validateTitle(String input, String ObjName) throws InterruptedException {
		String title = driver.getTitle();
		Thread.sleep(4000);
		System.out.println("Title "+title);
		Assert.assertEquals(title, input);
		logger.log(LogStatus.PASS, input + " Title is displayed as expected ");
	}

	public void checkBox(WebElement Obj, String text_name) {
		Obj.click();
		logger.log(LogStatus.PASS, text_name + " is clicked");
	}
}
