package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
 public	WebDriver driver;
 public  ExcelDataProvider excel;
 public ConfigDataProvider config;
 public ExtentReports report;	
 public ExtentTest logger ;

 
 
 @BeforeSuite
 public void setUpSuite() {
	 
	 Reporter.log("Setting up reports and Test is getting ready", true);
	 excel=new ExcelDataProvider();
	 config=new ConfigDataProvider();
	 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Asite_"+ Helper.getCurrentDateTime() +".html"));
	 report=new ExtentReports();
	 report.attachReporter(extent);
	 Reporter.log("Setting Done- Test can be started", true);
 }
	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start browser and getting application ready", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getAsiteqaURL());
		Reporter.log("Browser and Application is up and running", true);
	}
	@AfterClass
public void tearDown() {
		
	driver.close();
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			
			Helper.captureScreenshot(driver);
		}
		else {
			Helper.captureScreenshot(driver);
		}
        report.flush();
        Reporter.log("Test Completed >>> Repors Generated", true);
	}

}
