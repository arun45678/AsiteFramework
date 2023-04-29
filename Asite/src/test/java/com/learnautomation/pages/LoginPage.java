package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		
		this.driver=driver;
				
	}
	
	@FindBy(name="_58_login") WebElement username;
   @FindBy(name="_58_password") WebElement password;
   @FindBy(id="login-cloud") WebElement loginButton;
   
   
   public void LoginToAsite(String usernameApplication,String passwordApplication)
   {

	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
	}
	   username.sendKeys(usernameApplication);
	   password.sendKeys(passwordApplication);
	   loginButton.click();

   }
}
