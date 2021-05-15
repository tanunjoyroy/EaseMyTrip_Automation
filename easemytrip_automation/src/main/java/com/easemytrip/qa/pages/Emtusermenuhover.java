package com.easemytrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easemytrip.qa.base.Testbase;
import com.easemytrip.qa.utility.TestUtil;

public class Emtusermenuhover extends Testbase {
	
	@FindBy(id="welcome-det-User")
	WebElement usrLabelMenu;
	
	@FindBy(xpath="//a[@class='sb_link_2' and text()='My Booking']")
	WebElement myBookingOptn;
	
	@FindBy(xpath="//a[@class='sb_link_2' and text()='Print/Cancel Booking']")
	WebElement printCancelBookOptn;
	
	@FindBy(xpath="//a[@class='sb_link_2' and text()='My Profile']")
	WebElement myProfileOptn;
	
	@FindBy(xpath="//a[@class='sb_link_2' and text()='Log Out']")
	WebElement logOutOptn;
	
    public Emtusermenuhover() 
    {
		PageFactory.initElements(driver, this);
	}
    
    public EmtMyBookingPage clickMyBooking()
    {
    	Actions act = new Actions(driver);
    	act.moveToElement(usrLabelMenu).build().perform();
    	
    	myBookingOptn.click();
    	return new EmtMyBookingPage();
    	
    }
    
    public EmtCancelBookingPage clickCancelBooking()
    {
    	Actions act = new Actions(driver);
    	act.moveToElement(usrLabelMenu).build().perform();
    	printCancelBookOptn.click();
    	return new EmtCancelBookingPage();
    	
    }
    
    public EmtClickMyProfile clickMyProfile()
    {
    	Actions act = new Actions(driver);
    	act.moveToElement(usrLabelMenu).build().perform();
    	myProfileOptn.click();
    	return new EmtClickMyProfile();
    	
    }
    
    public Emtloginpage clickLogOut()
    {
    	Actions act = new Actions(driver);
    	act.moveToElement(usrLabelMenu).build().perform();
    	logOutOptn.click();
    	
    	TestUtil tu = new TestUtil();
    	tu.clickOkAlert();
    	
    	return new Emtloginpage();
    	
    }
}
