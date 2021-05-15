package com.easemytrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easemytrip.qa.base.Testbase;

public class Emtregistrationpage extends Testbase {
	
	@FindBy(xpath="//input[@id='txtEmail']")
	WebElement enterUsrname;
	
	@FindBy(xpath="//input[@onclick='CreateAccountMobEmail();']")
	WebElement registerBtn;
	
	public Emtregistrationpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Register()
	{
		
		enterUsrname.sendKeys("rtanunjoy@gmail.com");
		registerBtn.click();
	}
	
	
	

}
