package HMS.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import HMS.base.testbase;

public class commonutility extends testbase{
	
//Method for click the upload file
	
	//method for click
	public static void mouseclick(WebElement webE)
	{
		Actions actn=new Actions(driver);
		actn.click(webE).build().perform();
	}
	//method for upload
	public static void fileuploading(String file)
	{
		StringSelection ssl=new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssl, null);
		
		try {
			Robot rbt=new Robot();
			
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_V);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
//Method for screen shot if any exception	
	public static void takescreenshot()
	{
		
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String crnt=System.getProperty("user.dir");
		File destination=new File(crnt+"./screenshot/"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
