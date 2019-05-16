package testcases;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pagebjects.homepageobjects;
import pagebjects.login;

public class tc2 extends BaseClass {

	login lg;

	homepageobjects hpo;
	@BeforeClass
	public void launch(){
		setUp("chrome");
		 maxbro();
		 
		}
	
	@Test()
	public void tc_002(){ 
		log.info("login to homepage");
		
		lg=new login(driver);
		lg.setusername(username);
		lg.setpassword(password);
		lg.clicksub();
		log.info("verify homepage title");
		verifyHomepage("OrangeHRM");
        hpo=new homepageobjects(driver);
        log.info("click addemp button");
		hpo.clickaddbtn();
		String str=hpo.gettexttitle();
		log.info("verify add emp text");
		Assert.assertEquals(str, "PIM : Add Employee");
		log.info("enter lastname");
		hpo.setlastname("abc");
		log.info("enter fristname");
		hpo.setfristname("abvcs");
		log.info("click submit");
		hpo.clickonsave();
	}
	
	@AfterClass
	public void close(){
		driver.quit();
	}
	
	
}
