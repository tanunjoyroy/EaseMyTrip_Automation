package com.easemytrip.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.easemytrip.qa.base.Testbase;

public class Emtloginpage extends Testbase {
	
	//Pageobjects
	
	@FindBy(id="txtusername")
	WebElement userNameTxt;
	
	@FindBy(id="Password1")
	WebElement pwdTxt;
	
	@FindBy(xpath="//input[@onclick='UserAuthentication()']")
	WebElement loginBtn;
	
    public Emtloginpage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    
   //Pagemethods
    
    public String validateLoginPageTitle()
    {
    	return driver.getTitle();
    }
    
    public Emthomepage Login(String un, String pwd) throws InterruptedException
    {
    	
    	userNameTxt.sendKeys(un);
    	pwdTxt.sendKeys(pwd);
    	
    	loginBtn.click();
    	
    	return new Emthomepage();
    }
    

}
