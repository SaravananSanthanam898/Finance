package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HMS.base.testbase;
import HMS.utility.Datepicker;
import HMS.utility.commonutility;

public class AddIncomepage extends testbase{
	
	@FindBy(css="h4[class='box-title']")WebElement checkaddincomepagetitle;
	@FindBy(css="select[name='inc_head_id']")WebElement dropdownincomehead;
	@FindBy(css="input[name='name']")WebElement entername;
	@FindBy(css="input[name='invoice_no']")WebElement enterinvoiceno;
	@FindBy(css="input#date")WebElement datepic;
	@FindBy(css="input[name='amount']")WebElement enteramnt;
	@FindBy(css="input[name='documents']")WebElement uploadingfile;
	@FindBy(css="textarea[name='description']")WebElement enterdscrptn;
	@FindBy(css="buon.clse")WebElement clickclosebutton;
	
	public AddIncomepage()
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public String checkaddincomepagetitle()
	{
		waitforvisibility(checkaddincomepagetitle);
		return checkaddincomepagetitle.getText();
	}
	public void enteralldetailsinaddincome(String data[]) throws InterruptedException
	{
		
		Select sl=new Select(dropdownincomehead);
		sl.selectByVisibleText(data[0]);
		entername.sendKeys(data[1]);
		
		enterinvoiceno.sendKeys(data[2]);
		
	    datepic.click();
	   
		Datepicker dp=new Datepicker();
		dp.datpicker(data[3]);
	    enteramnt.sendKeys(data[4]);
		//uploadingfile;
	    commonutility.mouseclick(uploadingfile);
	    Thread.sleep(6000);
	    commonutility.fileuploading(data[5]);
		enterdscrptn.sendKeys(data[6]);
		Thread.sleep(6000);
		clickclosebutton.click();
		
		
		
		
		
		
		
	}
	
	
	
	
}
