package com.pft.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickHere 
{
@Test
public void login()
{
	System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://unified-mamqa.clearhub.tv/BC/Product/Modules/SignIn.aspx");
	driver.findElement(By.linkText("Click Here")).click();
}
}
