package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;

public class dashboardpage extends testbase{
	
	
	@FindBy(css="span[class='sidebar-session']")WebElement checkdahboardpagetitle;
	@FindBy(css="img[class='topuser-image']")WebElement clickprofilebutton;
	@FindBy(css="h4[style='text-transform: capitalize;']")WebElement checkprofilename;
	@FindBy(css="a[class='pull-right']")WebElement clicklogout;
	
	@FindBy(css="ul.sidebar-menu>li:nth-child(10)")WebElement clickfinance;
	@FindBy(css="ul.treeview-menu>li:nth-child(1)")WebElement clickincome;
	
	
	public dashboardpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkingdashbrdtitle()
	{
		return checkdahboardpagetitle.getText();
	}
	public void clickprofilebutton()
	{
		clickprofilebutton.click();
	}
	public String checkingprofilename()
	{
		return checkprofilename.getText();
	}
	public void clicklogoutbutton()
	{
		clicklogout.click();
	}
	
	
	

	public Financepage clickfinancemodule()
	{
		clickfinance.click();
		clickincome.click();
		return new Financepage();
	}
	
	
	

}
