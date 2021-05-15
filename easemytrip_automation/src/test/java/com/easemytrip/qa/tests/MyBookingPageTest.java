package com.easemytrip.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.easemytrip.qa.base.Testbase;
import com.easemytrip.qa.pages.EmtMyBookingPage;
import com.easemytrip.qa.pages.Emthomepage;
import com.easemytrip.qa.pages.Emtloginpage;
import com.easemytrip.qa.pages.Emtmyaccmenuhover;
import com.easemytrip.qa.pages.Emtusermenuhover;

public class MyBookingPageTest extends Testbase{
	
	Emtmyaccmenuhover myaccmenu;
	Emtloginpage loginpg;
	Emthomepage homepg;
	Emtusermenuhover userMenu;
	EmtMyBookingPage myBookingPg;
	
	
	public MyBookingPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException
	{
		initialization();
		myaccmenu = new Emtmyaccmenuhover();
		myaccmenu.hoverMenuSignIN();
		loginpg = new Emtloginpage();
		homepg = loginpg.Login(prop.getProperty("username"), prop.getProperty("password"));
		userMenu = new Emtusermenuhover();
	}
	
	@Test
	public void myBookingTest()
	{
		myBookingPg = userMenu.clickMyBooking();
		myBookingPg.selectFlightBooking(prop.getProperty("BookingRefNo"));
		
	}
	

}
