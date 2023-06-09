package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver, String browserName,String appURL)
	{
	if(browserName.equals("Chrome")) 
		
	{
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equals("Firefox")) {
		System.out.println("We do not support this browser");
	}
	else if(browserName.equals("IE")) {
		System.out.println("We do not support this browser");
	}
	else
	{
		System.out.println("We do not support this browser");
	}
	
  driver.manage().window().maximize();
  driver.get(appURL);
  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
  	return driver;
	
	}
	
	
	
	public static void quitBrowser()
	{
		WebDriver driver = null;
		driver.close();
	}
}
