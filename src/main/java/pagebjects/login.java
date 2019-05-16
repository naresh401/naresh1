package pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.BaseClass;

public class login extends BaseClass {
	WebDriver rdriver;
	
	@FindBy(name="txtUserName")
	WebElement txtusername;
	@FindBy(name="txtPassword")
	WebElement txtpassword;
	@FindBy(name="Submit")
	WebElement clicklogin;
	@FindBy(name="Clear")
	WebElement clearbtn;
	public login(WebDriver driver){
		this.rdriver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void setusername(String uname){
		txtusername.sendKeys(uname);
	}
	public void setpassword(String pass){
		txtpassword.sendKeys(pass);
	}
	public void clicksub(){
		clicklogin.click();
	}
	
	
	
	
}
