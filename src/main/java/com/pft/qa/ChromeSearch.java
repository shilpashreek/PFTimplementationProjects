package com.pft.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeSearch
{
	
	static WebDriver driver;
	@Test
	public void OpenApplication()
	{
		//Creating directory in eclipse 
		
		//loading user data to the chrome 
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=D:\\PFTprojects\\MavenDemoProject\\temp\\User Data");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		options.addArguments("	"
				+ "g=true");
		options.addArguments("--always-authorize-plugins=true");
		
		options.addArguments("--always-authorize-plugins=true");
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
		
		driver = new ChromeDriver(options);
        driver.get("chrome://downloads/");
        WebElement root1 = driver.findElement(By.tagName("downloads-manager"));
        WebElement shadow_root1 = expand_shadow_element(root1);

        WebElement root2 = shadow_root1.findElement(By.cssSelector("downloads-toolbar#toolbar"));
        WebElement shadow_root2 = expand_shadow_element(root2);

        WebElement root3 = shadow_root2.findElement(By.cssSelector("cr-toolbar#toolbar"));
        WebElement shadow_root3 = expand_shadow_element(root3);

        WebElement root4 = shadow_root3.findElement(By.cssSelector("cr-toolbar-search-field#search"));
        WebElement shadow_root4 = expand_shadow_element(root4);

        WebElement search_term = shadow_root4.findElement(By.cssSelector("div#searchTerm input#searchInput"));
        String js = "arguments[0].setAttribute('value','pdf')";
        ((JavascriptExecutor) driver).executeScript(js, search_term);

        WebElement search_button = shadow_root4.findElement(By.cssSelector("paper-icon-button#icon"));
        search_button.click();

        System.out.println("Search Button Clicked");
    }

    public static WebElement expand_shadow_element(WebElement element)
    {
        WebElement shadow_root = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
        return shadow_root;
    }



		

}


