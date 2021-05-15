package com.easemytrip.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.easemytrip.qa.base.Testbase;
import com.easemytrip.qa.pages.Emthomepage;
import com.easemytrip.qa.pages.Emtloginpage;
import com.easemytrip.qa.pages.Emtmyaccmenuhover;

public class LoginPageTest extends Testbase {
	Emtloginpage loginpg;
	Emthomepage homepg;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		loginpg = new Emtloginpage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		
		String Actualtitle = loginpg.validateLoginPageTitle();
		Assert.assertEquals(Actualtitle, "Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com");
	}
	
	
	  @Test(priority=2) 
	  public void loginPagetTest() throws InterruptedException 
	  {
	  
		  Emtmyaccmenuhover myaccmenu = new Emtmyaccmenuhover();
	      myaccmenu.hoverMenuSignIN(); homepg =
	      loginpg.Login(prop.getProperty("username"),prop.getProperty("password")); 
	     
	  }
	 
	
	
	
	
	
	  @AfterMethod 
	  public void teardown() 
	  {
		  driver.quit(); 
	  }
	 
	 
	
	
	//find out why webdriver instance should be declared as static; if not static its throwing nullpointer exception
	//try to create a common method for mousehover
	
	
}
