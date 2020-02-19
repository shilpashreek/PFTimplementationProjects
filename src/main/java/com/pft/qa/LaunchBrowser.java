package com.pft.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser 
{
	WebDriver driver;
@BeforeMethod
public void Openapplication() 
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/shilpashree.k/Downloads/chromedriver_win32 (2)/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("sonyops.clearhub.tv/bc/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.getTitle();
	}
@Test
public void Url()
{
		System.out.println("HELL");
}



}
