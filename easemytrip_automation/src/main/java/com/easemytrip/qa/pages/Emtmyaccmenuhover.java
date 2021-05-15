package com.easemytrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easemytrip.qa.base.Testbase;

public class Emtmyaccmenuhover extends Testbase {
	
	@FindBy(xpath="//span[@id='spnMyAcc']")
	WebElement myAccountdd;
	
	@FindBy(xpath="//div[@id='divSignInPnl']/a[text()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(xpath="//div[@id='divSignInPnl']/a[text()='Register']")
	WebElement regBtn;
	
	public Emtmyaccmenuhover() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void hoverMenuSignIN()
	{
		Actions act = new Actions(driver);
		act.moveToElement(myAccountdd).build().perform();
		
		signInBtn.click();
		
	}

	public void hoverMenuRegIN()
	{
		Actions act = new Actions(driver);
		act.moveToElement(myAccountdd).build().perform();
		
		regBtn.click();
		
	}
}
