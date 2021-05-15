package com.easemytrip.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.easemytrip.qa.base.Testbase;

public class Emtmenuoptiontabs extends Testbase {

	
	@FindBy(xpath="//div[@class='emt_nav']/ul/li")
	List<WebElement> menuTabs;
	
	 public Emtmenuoptiontabs()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public List<String> traverseAllLinks()
	 {
		 List<String> tabs = new ArrayList<String>();
		 for(WebElement i : menuTabs)
		 {
			 tabs.add(i.getText());
			 
		 }
		 return tabs;
}
}
