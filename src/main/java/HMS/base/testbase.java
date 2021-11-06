package HMS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HMS.utility.WebEventListener;

public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener lstnr;
	public static EventFiringWebDriver evtfrng;
	
	public testbase()
	{
		prop=new Properties();
		try {
			FileInputStream FIS=new FileInputStream("./src/main/java/HMS/config/config.properties");
			prop.load(FIS);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browsername=prop.getProperty("BROWSER");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		
		
		
		//Method for screen shot while exception
	    lstnr=new WebEventListener();
		evtfrng=new  EventFiringWebDriver(driver);
		evtfrng.register(lstnr);
		driver=evtfrng;
		
		
			
	}
	
	public void waitforvisibility(WebElement webE)
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(webE));
	}
	
	
	
	
	
	
	

}
