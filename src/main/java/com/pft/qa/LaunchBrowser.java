package com.pft.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser {
	WebDriver driver;

	@BeforeMethod
	public void Openapplication() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://sonyops.clearhub.tv/BC/Product/Modules/SignIn.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.getTitle();
	}

	@Test
	public void Url() {
		System.out.println("HELL");
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
