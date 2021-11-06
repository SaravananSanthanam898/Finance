package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.Financepage;
import HMS.pages.dashboardpage;
import HMS.pages.loginpage;

public class Financetest extends testbase{
	
	
	loginpage logobj;
	dashboardpage dashobj;
	Financepage finobj;
	
	public Financetest()
	{
		super();
	}
	@BeforeClass
	public void setup()
	{
		initialization();
		logobj=new loginpage();
		dashobj=logobj.enterusrnmpasswrdclksgnin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		finobj=dashobj.clickfinancemodule();
		
	}
	@Test
	public void Financemoduletest()
	{
		String expectedincomepagetitle="Income List";
		Assert.assertEquals(finobj.checkincomepagetitle(), expectedincomepagetitle);
		finobj.clickaddincomebutton();
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}

}
