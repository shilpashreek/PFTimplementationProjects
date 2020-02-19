package com.pft.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class GenericClass 
{
	@BeforeMethod
	public void OpenApplication()
	{
		//System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/chromedriver_win32 (2)/chromedriver.exe");
		//C:\Users\shilpashree.k\Downloads\chromedriver_win32 (2)
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationtesting.in");
	}
@Test
public void test()
{
	Reporter.log("pft");
	System.out.println("hi");
	
}
@Test
public void test1()
{
	System.out.println("hi pft");
	
}
}
