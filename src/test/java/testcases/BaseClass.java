package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import utilities.readconfig;

public class BaseClass 
{
	readconfig rc = new readconfig();
	public String baseurl = rc.getbaseurl();
	public String username = rc.getusername();
	public String password = rc.getpassword();
	public static WebDriver driver;
	public Actions Act;
	WebDriverWait wait;
	public Logger log;

	public void setUp(String br) 
	{
		log=Logger.getLogger("hrm project");
		PropertyConfigurator.configure("log4j.properties");
		if (br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", rc.getchromepath());
			driver = new ChromeDriver();
			

		} else if (br.equals("ie")) {

			System.setProperty("webdriver.ie.driver", rc.getiepath());
			driver = new InternetExplorerDriver();
			
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getfirefoxpath());
			driver=new FirefoxDriver();
			

		} else {
			System.out.println("driver not available");
		}
		
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseurl);
	
	}
  
public void close(){
   driver.quit();
     }
	
	public void verifyHomepage(String title)
	{
		if (driver.getTitle().equals(title)) 
		{
			System.out.println("hmepage" + title);
		} else {
			takeScreenshot(driver, title);
			log.info("title not matching"+title);
			System.out.println("homepage" + title);
			return;
		}

	}

	public void maxbro() 
	{
		driver.manage().window().maximize();
	}
	
	
	public void mouseOverAction(WebElement element){
		Act=new Actions(driver);
		
		Act.moveToElement(element).build().perform();
		
		
	}
	
	public void mouseoverClickAction(WebElement element){
		Act=new Actions(driver);
		
		Act.moveToElement(element).click().build().perform();
	}
	
	public void switchingFrame(String frametitle){
		driver.switchTo().frame(frametitle);
	}
	public void waitforelementpresent(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForTextToBePresent(WebElement element,String text){
		if(wait.until(ExpectedConditions.textToBePresentInElement(element, text))){
			System.out.println(text);
			
		}
		else{
			System.out.println("element not present");
		}
		
	}
	
	public void threadsleep(long time){
		try{
		Thread.sleep(time);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public void takeScreenshot(WebDriver driver,String screenshotname){
		TakesScreenshot tc=(TakesScreenshot)driver;
		File src=tc.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"/screenshots/"+screenshotname+".png");
	    try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
