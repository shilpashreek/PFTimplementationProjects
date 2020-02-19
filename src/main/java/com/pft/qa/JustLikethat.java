package com.pft.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JustLikethat 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void settings()
	{
		driver.get("chrome://settings/content/siteDetails?site=http://192.168.150.205:1000/BC/product/modules/signin.aspx?viacom18digital");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("list-frame")));
		driver.findElement(By.id("search")).sendKeys("hello");
	}
}
