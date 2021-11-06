package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.dashboardpage;
import HMS.pages.loginpage;

public class dashboardtest extends testbase{
	
	loginpage logobj;
	dashboardpage dashobj;
	
	public dashboardtest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
		logobj=new loginpage();
		dashobj=logobj.enterusrnmpasswrdclksgnin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	
		
	}
	@Test
	public void dashboardtest()
	{
		
		String expecteddashbrdtitle="Smart Hospital Management System";
		Assert.assertEquals(dashobj.checkingdashbrdtitle(), expecteddashbrdtitle);
		dashobj.clickprofilebutton();
		String expectedprofilename="Super Admin";
		Assert.assertEquals(dashobj.checkingprofilename(), expectedprofilename);
		dashobj.clicklogoutbutton();
		
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	
	

}
