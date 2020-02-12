package Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.baseSF;
import Utility.Resuable;

public class loginPage extends baseSF{
	Resuable reuse = new Resuable();
	@FindBy(id="username")	WebElement username;
	@FindBy(id="password")	WebElement password;
	@FindBy (id="Login") WebElement loginButton;
	@FindBy (id="error") WebElement errorMessage;
	@FindBy (name="rememberUn")WebElement rememberMe;
	@FindBy(id="forgot_password_link")WebElement forgotPassword;
	@FindBy(id="idcard-identity")WebElement usernameVerify;
	
	
	public loginPage() {
		PageFactory.initElements(driver, this);
	}

	public void getUsername(String arg1,String text_name) {
		reuse.enterData(username, arg1,text_name);
	 }
	public void getPassword(String arg1,String text_name) {
		reuse.enterData(password, arg1,text_name);
	 }
	public HomePageSF getButton(String text_name) throws Exception {
		reuse.clickButton(loginButton,text_name);
		return new HomePageSF();
	}
	public  void getErrorMessage(String msg) {
		reuse.validateText(errorMessage,msg);
	}

	public void VerifyTitle(String title) throws InterruptedException {
		reuse.validateTitle(title, "loginPage");
		
				
	}
	public void checkBox(String text_name) {
		reuse.checkBox(rememberMe,text_name);
	}
	public void getRememberMe(String text_name) throws InterruptedException {
		reuse.clickButton(rememberMe, text_name);
	}
	public String getUsernameVerify() {
		return usernameVerify.getText();
	}
		public ForgotPasswordPage forgotPassword(String text_name) throws Exception {
			reuse.clickButton(forgotPassword, text_name);
			return new ForgotPasswordPage();
		}
	}

