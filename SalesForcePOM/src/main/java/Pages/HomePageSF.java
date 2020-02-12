package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.baseSF;
import Utility.Resuable;



public class HomePageSF extends baseSF{
	public HomePageSF() {
		PageFactory.initElements(driver, this);
	}
	Resuable reuse = new Resuable();
	@FindBy(id="userNavButton")	WebElement userMenu;
	@FindBy(linkText="Logout") WebElement Logout;
	@FindBy(xpath="//div[@id='userNavMenu']//a") WebElement dropDown;
	
	public void getButton(String text_name) throws InterruptedException {
		reuse.clickButton(userMenu, text_name);
}
	public void VerifyTitle(String title) throws InterruptedException {
		reuse.validateTitle(title, "HomePage");
		
				
	}
	public loginPage LogoutButton(String text_name) throws InterruptedException {
		reuse.clickButton(Logout, text_name);
		return new loginPage();
}
	String[] list = { "My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience",
	"Logout" };


}