package com.easemytrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easemytrip.qa.base.Testbase;

public class Emthomepage extends Testbase {
	
	@FindBy(xpath="//span[@id='welcome-det-User']")
	WebElement userLogo;
	
	@FindBy(xpath="//input[@id='FromSector_show']")
	WebElement fromSearch;
	
	@FindBy(xpath="//input[@id='Editbox13_show']")
	WebElement toSearch;
	
	@FindBy(xpath="//input[@id='ddate']")
	WebElement fromDte;
	
	@FindBy(xpath="//input[@id='rdate']")
	WebElement toDate;
	
	@FindBy(xpath="//input[@onclick='SearchFlightWithArmy();']")
	WebElement searchBtn;
	
	//xpath of traveller economy dropdown pending
	
	//continue from 39:33 video wise but implement data driven pending before that complete https://www.youtube.com/playlist?list=PLFGoYjJG_fqqlW6swKwutBOVU2O8k_JHT
	
	//watch video 4,5,6 from excel playlist then resume pom video 4 continue from 39:33 video wise but just rewind the first 40 mins with your data reading code 
	
	//pom video 4 code copy to testutil.java in pomtest java project
	
	public Emthomepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String readuserlogo()
	{
		return userLogo.getText();
		 
	}
	
	public void enterFlightInfo(String FromPlace,String ToPlace)
	{
		fromSearch.clear();
		fromSearch.sendKeys(FromPlace);
		toSearch.clear();
		toSearch.sendKeys(ToPlace);
	}
	
	
	
	
	
	

}
