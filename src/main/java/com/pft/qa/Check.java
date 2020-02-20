package com.pft.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("192.168.150.205:1000/BC/product/modules/signin.aspx?viacom18digital");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.getTitle();

	}

}
