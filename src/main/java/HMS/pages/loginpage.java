package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;

public class loginpage extends testbase{
	
	
	@FindBy(css="img[style='height: 30px;']")WebElement checkpagelogo;
	@FindBy(css="i[class='fa fa-key']")WebElement checkpagekey;
	@FindBy(css="h3.font-white")WebElement checkpagename;
	@FindBy(css="input.form-username")WebElement enterusername;
	@FindBy(css="input.form-password ")WebElement enterpassword;
	@FindBy(css="button.btn ")WebElement clicksignin;
	@FindBy(css="a[class='forgot']")WebElement clickforgotpassword;
	@FindBy(css="h3[class='font-white']")WebElement checkforgotpasswordname;
	@FindBy(css="input[name='email']")WebElement enteremail;
	@FindBy(css="button[type='submit']")WebElement clicksubmit;
	@FindBy(css="div.alert-success")WebElement checkalert;
	@FindBy(css="input.form-username")WebElement ogusername;
	@FindBy(css="input.form-password ")WebElement ogpassword;
	@FindBy(css="button.btn ")WebElement againclicksignin;
	
	public loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String websitename()
	{
		return driver.getTitle();
	}
	public boolean checklogo()
	{
		return checkpagelogo.isDisplayed();
	}
	public boolean checkpagekey()
	{
		return checkpagekey.isDisplayed();
		
	}
	public String checkpagename()
	{
		return checkpagename.getText();
		
	}
	public dashboardpage enterusrnmpasswrdclksgnin(String uname,String pass)
	{
		enterusername.sendKeys(uname);
		enterpassword.sendKeys(pass);
		clicksignin.click();
		return new dashboardpage();
	}
	public void clickforgotpassword()
	{
		clickforgotpassword.click();
	}
	public String checkfrgotpasswordname()
	{
		return checkforgotpasswordname.getText();
		
	}
	public void enteremailclicksubmit(String email)
	{
		enteremail.sendKeys(email);
		clicksubmit.click();
	}
	public String checkalertmessage()
	{
		return checkalert.getText();
		
	}
	public void againenterusrmepaswrdclicksignin(String ogname,String ogpass)
	{
		ogusername.sendKeys(ogname);
		ogpassword.sendKeys(ogpass);
		againclicksignin.click();
	}
	
	
	
	

}
