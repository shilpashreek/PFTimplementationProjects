package com.pft.qa;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Otp 
{
static WebDriver driver;
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		 Email email = new SimpleEmail(); email.setHostName("mail.primefocus.com");
		 email.setSmtpPort(465); //465 email.setAuthenticator(new
		 //DefaultAuthenticator("shilpashree.k@primefocus.com", "SAURXCUSYTYDJIZQ");
		 //SAURXCUSYTYDJIZQ
		
		/*
		 * driver.get("https://mail.primefocus.com/zimbra/#1");
		 * driver.findElement(By.id("username")).sendKeys("shilpashree.k@primefocus.com"
		 * ); driver.findElement(By.id("password")).sendKeys("SAURXCUSYTYDJIZQ");
		 * driver.findElement(By.cssSelector("input[value='Sign In']")).submit();
		 */
	}

}
