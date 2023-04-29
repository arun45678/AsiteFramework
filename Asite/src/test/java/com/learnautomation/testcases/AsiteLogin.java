
package com.learnautomation.testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;

public class AsiteLogin extends BaseClass {

		
	@Test(priority=1)
	public void loginApp()
	{
		
		
		logger=report.createTest("Login to Asite");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		driver.switchTo().frame("iFrameAsite");
		logger.info("Starting Login page!");
		loginPage.LoginToAsite(excel.getStringData("Login",0,0), excel.getStringData("Login",0,1));
		logger.pass("Login Successfully!");
		
	}
	@Test(priority=2)
	public void logout()
	{
		
		logger=report.createTest("Logout");
		logger.fail("Logout failed");
		
	}

}
