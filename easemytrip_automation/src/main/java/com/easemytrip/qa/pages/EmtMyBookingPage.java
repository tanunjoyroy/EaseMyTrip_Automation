package com.easemytrip.qa.pages;

import org.openqa.selenium.By;

import com.easemytrip.qa.base.Testbase;

public class EmtMyBookingPage extends Testbase 
{
	public void selectFlightBooking(String bookingRefNo)
	{
		
		driver.findElement(By.xpath("//a[text()='"+bookingRefNo+"']/parent::td/preceding-sibling::td/input")).click();
	}
}
