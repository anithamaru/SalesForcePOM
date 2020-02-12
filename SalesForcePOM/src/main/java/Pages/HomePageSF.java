package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Base.baseSF;
import Utility.Resuable;



public class HomePageSF extends baseSF{
	public HomePageSF() {
		PageFactory.initElements(driver, this);
	}
	Resuable reuse = new Resuable();
	//@FindBy(id="userNavButton")	WebElement userMenu;
	@FindBy(id="userNav-arrow") WebElement userMenu;
	@FindBy(linkText="Logout") WebElement Logout;
	@FindBy(xpath="//div[@id='userNav-menuItems']//a") List<WebElement> dropDown;
	
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
//	String[] list = { "My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience",
//	"Logout" };

	public void validateDropdown(String menu) {
		String[] items=menu.split(",");
		List<String> options = new ArrayList<String>();

		for(WebElement op:dropDown) {
			options.add(op.getText());
			
		
		}
		
		for(int i=0;i<items.length;i++) {
			
			System.out.println(items[i]+" compares with "+options.get(i));
			if(items[i].equals(options.get(i))){
				
				logger.log(LogStatus.PASS,"The User menu is present as expected");
			}
			else
				logger.log(LogStatus.FAIL,"The User menu is NOT  present as expected");
		
		}
	}

}