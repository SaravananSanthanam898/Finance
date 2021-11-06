package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.AddIncomepage;
import HMS.pages.Financepage;
import HMS.pages.dashboardpage;
import HMS.pages.loginpage;
import HMS.utility.ReadExcel;

public class AddIncometest extends testbase{
	
	loginpage logobj;
	dashboardpage dashobj;
	Financepage finobj;
	AddIncomepage adincmobj;
	public AddIncometest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		logobj=new loginpage();
		dashobj=logobj.enterusrnmpasswrdclksgnin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		finobj=dashobj.clickfinancemodule();
		adincmobj=finobj.clickaddincomebutton();
		
	}
	
	
	@DataProvider
	public Object[][] exceldata()
	{
		Object[][] data=ReadExcel.getTestData("Add Income");
		return data;
		
	}
	
	
	@Test(dataProvider = "exceldata")
	public void addincometest(String args[]) throws InterruptedException
	{
		String expectedaddincomepgtitle="Add Income";
		Assert.assertEquals(adincmobj.checkaddincomepagetitle(), expectedaddincomepgtitle);
		adincmobj.enteralldetailsinaddincome(args);
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	
	

}
