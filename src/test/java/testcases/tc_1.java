package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pagebjects.homepageobjects;
import pagebjects.login;


public class tc_1 extends BaseClass{
	
	login lg;
	
	@BeforeClass
	public void launch(){
		
		setUp("chrome");
		log.info("maximize the broswer");
		 maxbro();
		}
	@Test
	public void tc_001(){
    lg=new login(driver);
    log.info("enter username");
    lg.setusername(username);
    log.info("enter password");
	lg.setpassword(password);
	log.info("click on submit");
	lg.clicksub();
	log.info("verify homepage title");
	verifyHomepage("OrangeHRM");
	
	}
	
	@AfterClass
	public void close(){
		driver.quit();
		
	}
	
	
	


	

}

	
	
	
