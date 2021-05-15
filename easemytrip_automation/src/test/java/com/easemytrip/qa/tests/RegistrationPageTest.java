package com.easemytrip.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.easemytrip.qa.base.Testbase;
import com.easemytrip.qa.pages.Emtmyaccmenuhover;
import com.easemytrip.qa.pages.Emtregistrationpage;

public class RegistrationPageTest extends Testbase{
	
	Emtmyaccmenuhover accmenu;
	Emtregistrationpage regpg;
	
	public RegistrationPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		accmenu = new Emtmyaccmenuhover();
		regpg = new Emtregistrationpage();
	}
	
	@Test
	public void validateRegistrationTest()
	{
		accmenu.hoverMenuRegIN();
		regpg.Register();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}


//how to automate otp in selenium while registering in a web site