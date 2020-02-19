package com.pft.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingFlash 

{
	WebDriver driver;
@BeforeTest
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
}

public WebElement expandRootElement(WebElement element)
{
	WebElement ele=(WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
	return ele;
}

@Test
public void settings()
{
	driver.get("chrome://settings/content/siteDetails?site=https://oneclear.clearhub.tv/BC/Product/Modules/SignIn.aspx");	
	
	
	WebElement root1 = driver.findElement(By.tagName("settings-ui"));
	WebElement shadowRoot1 = expandRootElement(root1);
	
	//WebElement root2 = driver.findElement(By.cssSelector("settings-main"));
	//WebElement shadowroot2 = expandRootElement(root2);
	
	//WebElement root3 = driver.findElement(By.cssSelector("settings-basic-page"));
	//WebElement shadowroot3 = expandRootElement(root3);
	
	WebElement root2 = shadowRoot1.findElement(By.cssSelector("settings-main"));
	WebElement shadowroot2 = expandRootElement(root2);
	
	WebElement root3 = shadowroot2.findElement(By.cssSelector("settings-basic-page"));
	WebElement shadowroot4 = expandRootElement(root3);
	
	//WebElement root4 = shadowroot4.findElement(By.cssSelector("settings-section"));
	//WebElement shadowroot5 = expandRootElement(root4);

	
	WebElement root5 = shadowroot4.findElement(By.tagName("settings-privacy-page"));
	WebElement shadowroot6 = expandRootElement(root5);
	
	//WebElement root6 = shadowroot6.findElement(By.cssSelector("settings-animated-pages"));
	//WebElement shadowroot7 = expandRootElement(root6);
	
	//WebElement root7 = shadowroot6.findElement(By.cssSelector("settings-subpage"));
	//WebElement shadowroot8 = expandRootElement(root7);
	
	WebElement root8 = shadowroot6.findElement(By.tagName("site-details"));
	WebElement shadowroot9 = expandRootElement(root8);
	
	WebElement root9 = shadowroot9.findElement(By.id("plugins"));
	WebElement shadowroot10 = expandRootElement(root9);
	
	WebElement FlashDropdown = shadowroot10.findElement(By.id("permission"));
	Select s = new Select(FlashDropdown);
	s.selectByValue("allow");
	
	
	
	
	
}



}
