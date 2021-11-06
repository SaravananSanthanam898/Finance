package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.loginpage;

public class logintest extends testbase{
	
	loginpage logobj;
	
	
	public logintest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		logobj=new loginpage();
		
	}
    @Test
    public void loginstep1()
    {
    	
    	String expectedwebname="Smart Hospital : Hospital Management System";
    	Assert.assertEquals(logobj.websitename(), expectedwebname);
    	Assert.assertTrue(logobj.checklogo());;
    	Assert.assertTrue(logobj.checkpagekey());
    	String expectedpagenmae="Admin Login";
    	Assert.assertEquals(logobj.checkpagename(), expectedpagenmae);
    	logobj.enterusrnmpasswrdclksgnin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
    }
    
    
    @Test
    public void loginstep2()
    {
    	logobj.clickforgotpassword();
    	String expectedpagename="Forgot Password";
    	Assert.assertEquals(logobj.checkfrgotpasswordname(), expectedpagename);
    	logobj.enteremailclicksubmit(prop.getProperty("EMAIL"));
    	String expectedalertmsg="Please check your email to recover your password";
    	Assert.assertEquals(logobj.checkalertmessage(), expectedalertmsg);
    	logobj.againenterusrmepaswrdclicksignin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
    }
    
    
    
    
    @AfterMethod
    public void teardown()
    {
    	driver.close();
    }
    
    
    
}
