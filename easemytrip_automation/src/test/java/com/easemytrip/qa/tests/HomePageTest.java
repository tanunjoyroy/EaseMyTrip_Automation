package com.easemytrip.qa.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.easemytrip.qa.base.Testbase;
import com.easemytrip.qa.pages.Emthomepage;
import com.easemytrip.qa.pages.Emtloginpage;
import com.easemytrip.qa.pages.Emtmenuoptiontabs;
import com.easemytrip.qa.pages.Emtmyaccmenuhover;
import com.easemytrip.qa.pages.Emtusermenuhover;
import com.easemytrip.qa.utility.TestUtil;
import com.google.common.collect.ImmutableList;

public class HomePageTest extends Testbase{
	
	Emtloginpage loginpg;
	Emtmyaccmenuhover myaccmenu;
	Emthomepage homepg;
	Emtusermenuhover usrMenHov;
	Emtmenuoptiontabs menuTabs;
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void Setup() throws InterruptedException
	{
		initialization();
		myaccmenu = new Emtmyaccmenuhover();
		myaccmenu.hoverMenuSignIN();
		loginpg = new Emtloginpage();
		homepg = loginpg.Login(prop.getProperty("username"),prop.getProperty("password"));
		usrMenHov = new Emtusermenuhover();
		menuTabs = new Emtmenuoptiontabs();
		
	}
	
	
	
	
	  @Test(priority = 1) public void validateuserlogo() { String actUsrLogo =
	  homepg.readuserlogo(); Assert.assertEquals(actUsrLogo,
	  "roytanunjoy@gmail.com","user logo is not matched successfully"); }
	  
	  @Test(priority = 2) public void usrLogOutTest() { loginpg =
	  usrMenHov.clickLogOut();
	  
	  }
	  
	  
	  
	  
	  @Test(priority = 3) public void validateMenuTabs() { List<String>
	  ExpectedLabels
	  =ImmutableList.of("FLIGHTS","HOTELS","TRAINS","BUS","HOLIDAYS","CABS","VISA",
	  "ACTIVITIES","GIFT CARD","CHARTERS\n" + "NEW","MORE"); List<String>
	  ActualLabels = menuTabs.traverseAllLinks();
	  
	  System.out.println(ActualLabels);
	  
	  Assert.assertEquals(ActualLabels,
	  ExpectedLabels,"the labels of the tabs did not match");
	  
	  
	  }
	 
	  
	  @DataProvider
	  public Iterator<Object[]> getExcelData()
	  {
		  ArrayList<Object[]> arrTestData = TestUtil.readExcelData();
		  return arrTestData.iterator();
		  //An Iterator is an object that can be used to loop through collections, like ArrayList and HashSet. 
	  }
	  
	  @Test(dataProvider = "getExcelData")
	  public void validateSearchFlight(String FromPlace,String ToPlace)
	  {
		  homepg.enterFlightInfo(FromPlace, ToPlace);
	  }
	 
	
	
	  @AfterMethod 
	  public void teardown() 
	  { 
		  driver.quit(); 
	  }
	 
	
	//resume from part 4
	  //learn about thread count & parallel mode in runner class
	    //code for clicking the links,table validation & other scenarios to test
	  
	
	 
}
