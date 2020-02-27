package viacom18digital;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GenericClass 
{
	static WebDriver driver;
	String Desfile;
	static String AssetTitle="pfttest-21jan";
	static String IngestedFileName="TEST";
	 
	 @BeforeSuite
	 
	  public void ChromeSettings() throws IOException
	 {
		File Desfile = new File("D:\\PFTprojects\\MavenDemoProject\\temp");
		File Srcfile = new File("D:\\PFTprojects\\MavenDemoProject\\ChromeData");
		if(Desfile.exists())
	    {
	    	//Srcfile.mkdir();
	    	//System.out.println("folder has been created successfully");
	    	FileUtils.copyDirectory(Srcfile, Desfile);
	    	System.out.println("folder is present already");
			
		}
	    	
	    
	    else
	    {
	    	Desfile.mkdir();
	        FileUtils.copyDirectory(Srcfile, Desfile);
			System.out.println("Folder is created and copied data successfully");
	    }
		
 }
	 
	 
@BeforeTest
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
	
	// options.addArguments("--disable-gpu");            //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
	
	 //--disable-browser-side-navigation
	 //options.addArguments("--disable-browser-side-navigation");
	 
	 
	 //options.setPageLoadStrategy(PageLoadStrategy.NONE);
	 //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	 
	DesiredCapabilities capabilities = new DesiredCapabilities();
	//options.addArguments("disable-infobars");
	//options.addArguments("--start-maximized");
	HashMap<String, Object> prefs = new HashMap<String, Object>();
	//prefs.put("profile.default_content_settings.popups", 1);
	//options.addArguments("--no-sandbox");
   // options.addArguments("--disable-dev-shm-usage");
	prefs.put("credentials_enable_service", false);
	prefs.put("profile.password_manager_enabled", false);
	prefs.put("profile.default_content_setting_values.plugins", 1);
	prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
	prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
	prefs.put("profile.default_content_settings.popups", 1);
	prefs.put("PluginsAllowedForUrls", "http://192.168.150.205:1000/BC/Product/Modules/Dashboard/Dashboard.aspx");
    options.setExperimentalOption("prefs", prefs);
    options.setExperimentalOption("useAutomationExtension", false);
   // options.addArguments("--headless");
	System.setProperty("webdriver.chrome.driver", "C:/Users/shilpashree.k/Downloads/drivers/chromedriver.exe");
	driver=new ChromeDriver(options);
	driver.manage().window().maximize();
}
	/*System.setProperty("webdriver.gecko.driver", "C:/Users/shilpashree.k/Downloads/geckodriver-v0.26.0-win64/geckodriver.exe");
	driver=new FirefoxDriver();*/


public WebElement expandRootElement(WebElement element)
{
	WebElement ele=(WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
	return ele;
}


@Test(priority=0,enabled=true)
public void HandlingFlash()
{	
	driver.get("chrome://settings/content/siteDetails?site=http://192.168.150.205:1000/BC/product/modules/signin.aspx?viacom18digital");	
		
		
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
	
	


//current date and time
public static void DateTime()
{
	Date date = new Date();

	//decide date and time format
	SimpleDateFormat dateformat = new SimpleDateFormat();
	String date1 = dateformat.format(date);
	System.out.println(date1);
}


@AfterSuite
public void DeleteTempdata() throws IOException, EmailException
{
	File temp = new File("D:\\PFTprojects\\MavenDemoProject\\temp");
	if(temp.exists())
	{
		FileUtils.deleteDirectory(temp);
	}
	else
	{
		System.out.println("TempDir folder is not present in the project");
	}
	
	mail();
}

@AfterTest
public void CloseApplication()  //close the browser driver.quit(); 
{
	driver.quit();
}


	
public static void TakeScreenshot(String testMethodName)
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try
	{
		FileUtils.copyFile(src, new File("D:/PFTprojects/MavenDemoProject/screenshots/" +testMethodName+ "_"+".png"));
	} catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


public static void mail() throws EmailException
{
	Email email = new SimpleEmail();
	email.setHostName("mail.primefocus.com");
	email.setSmtpPort(465); //465
	email.setAuthenticator(new DefaultAuthenticator("shilpashree.k@primefocus.com", "SAURXCUSYTYDJIZQ"));  //SAURXCUSYTYDJIZQ
	email.setSSLOnConnect(true);
	email.setFrom("shilpashree.k@primefocus.com");
	email.setSubject("TestCaseExecutionMail");
	email.setMsg("All the testcases are executed successfully");
	email.addTo("sivakumar.vasagar@primefocus.com"); //nayana.dj@primefocus.com
	email.addCc("sreenivasrao.vampu@primefocus.com");
	email.send();
	//System.out.println("testcase of test" +testMethodName +"is pass");
	
}
}




