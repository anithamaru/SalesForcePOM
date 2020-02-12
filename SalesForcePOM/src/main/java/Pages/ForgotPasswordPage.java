package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.baseSF;
import Utility.Resuable;

public class ForgotPasswordPage extends baseSF{
	Resuable reuse = new Resuable();
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="un")	WebElement provideUsername;
	@FindBy(id="continue")	WebElement continueButton;
	
	public String validatePage(String text_name) {
		return driver.getTitle();
	}
	public void provideUsername(String input,String text_name) {
		reuse.enterData(provideUsername, input, text_name);
	}
	
	public CheckYourEmail continueButton(String text_name) throws Exception {
		reuse.clickButton(continueButton, text_name);
		return new CheckYourEmail();
	}
}
