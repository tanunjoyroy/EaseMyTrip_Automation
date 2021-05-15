package com.easemytrip.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

public class Testbase {
	
	public Properties prop;
	public static WebDriver driver;
	
	
	public Testbase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Study\\Naveen Automation\\Workspace\\easemytrip_automation\\src\\main\\java\\com\\easemytrip\\qa\\config\\configvars.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	public void initialization()
	{
		String browser = prop.getProperty("browser");
		
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Study\\Naveen Automation\\Latest chrome driver version 84\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
			
			
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Study\\Naveen Automation\\Latest Gecko driver\\geckodriver-v0.26.0-win64\\geckodriver.exe");	
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Study\\Naveen Automation\\Latest IE driver\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
			
		}
		else 
		{
			System.out.println("Browser is not present in the system");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PAGE_LOAD_TIME_OUT")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		

	}

}
