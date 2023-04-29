package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Screenshot, alert, Frames, windows, Sync issue, Javascript executor
	
	public static String captureScreenshot(WebDriver driver) 
	{
		String screenshotPath=System.getProperty("user.dir"+"/Screenshots/Asite_"+getCurrentDateTime() + ".png");
		
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(src, new File("./Screenshots/Asite_"+ getCurrentDateTime()+".png"));
		System.out.println("Screenshot Caputred Successfully");
		
	} catch (IOException e) {
		
		System.out.println("Ubable to capture the screenshot "+e.getMessage());
	}
	return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
	 return	customFormat.format(currentDate);
		
	}
}
