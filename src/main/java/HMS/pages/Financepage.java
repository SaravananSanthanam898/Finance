package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;

public class Financepage extends testbase{
	
	
	@FindBy(css="h3.box-title")WebElement checkincomepagetitle;
	@FindBy(css="div.box-tools")WebElement clickaddincome;
	
	public Financepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkincomepagetitle()
	{
		return checkincomepagetitle.getText();
	}
	public AddIncomepage clickaddincomebutton()
	{
		
		clickaddincome.click();
		return new AddIncomepage();
	}
	

}
