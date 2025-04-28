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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testbase {
	
	public Properties prop;
	public static WebDriver driver;
	
	
	public Testbase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/main/java/com/easemytrip/qa/config/configvars.properties");
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
			WebDriverManager.chromedriver()browserVersion("135").setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			
			driver = new ChromeDriver(options);
			
			
			
			
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();		
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("InternetExplorer"))
		{
			WebDriverManager.iedriver().setup();
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
