package pagebjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.BaseClass;


public class homepageobjects extends BaseClass {
	Actions Act;
    WebDriver driver;
	@FindBy(xpath="//input[@value='Add']")
	WebElement clickaddbtn;
	@FindBy(xpath = "//h2[contains(text(),'PIM : Add Employee')]")
	WebElement txtpresent;
	@FindBy(id="txtEmployeeId")
	WebElement txtEmployeeId;
	@FindBy(id="txtEmpLastName")
	WebElement txtEmpLastName;
	@FindBy(name="txtEmpFirstName")
	WebElement txtEmpFirstName;
	@FindBy(xpath = "//input[@value='Save']")
	WebElement savebutton;
	public homepageobjects(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	public void clickaddbtn(){
		switchingFrame("rightMenu");
		clickaddbtn.click();
		
        /*mouseOverAction(mouseoverpim);
        mouseoverClickAction(mouseoverpim);*/
		
		}
	
	public String gettexttitle(){
		return txtpresent.getText();
	}
	
	public void setlastname(String lastname){
		txtEmpLastName.sendKeys(lastname);
		
   }
	
	public void setfristname(String fristname){
	    txtEmpFirstName.sendKeys(fristname);
	}
	
	public void clickonsave(){
		savebutton.click();
		
	}
	
	
		
		
	
	

	
	
	
	
	
	

}
