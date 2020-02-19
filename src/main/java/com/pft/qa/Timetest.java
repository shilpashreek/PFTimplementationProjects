package com.pft.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Timetest 
{
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/shilpashree.k/Downloads/chromedriver_win32 (2)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       
		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("sonyops.clearhub.tv/bc/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.getTitle();*/
		
			
		}
		
	}


