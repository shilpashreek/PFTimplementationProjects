package com.pft.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickHere 
{
	static WebDriver driver;
	
@Test
public void login() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	//url("https://unified-mamqa.clearhub.tv/BC/Product/Modules/SignIn.aspx");
	//driver.get("https://unified-mamqa.clearhub.tv/BC/Product/Modules/SignIn.aspx");
	driver.findElement(By.linkText("Click Here")).click();
	//System.out.println(driver.getPageSource());
	Thread.sleep(2000);
	WebElement loginpage = driver.findElement(By.id("aspnetForm"));
	System.out.println(loginpage.getText());
}

public static void Url(String url)
{
	driver.get(url);
	
}
}
