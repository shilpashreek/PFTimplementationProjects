package viacom18digital;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(viacom18digital.TestngListerners.class)
public class VerifyLoginPage extends GenericClass
{
	
@Test(priority=1,enabled=true)
public void LoginPagetest() throws InterruptedException 

{
	//passing url 
	
	driver.get("http://192.168.150.205:1000/CE/product/modules/signin.aspx?viacom18digital");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='x-username']")).sendKeys("shilpa_viacomuser");
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//div[@id='ContinueText']")).click();
	
	WebDriverWait wait=new WebDriverWait(driver,100);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Continue")));
	element.submit();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='x-password']")).sendKeys("Shilpa@9620");
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@class='loginButton']")).submit();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//verification
	
	String title = driver.getTitle();
	System.out.println(title);
	String url = driver.getCurrentUrl();
	System.out.println(url);
	Assert.assertEquals(title, "Clear EDGE");
	{
		System.out.println("home page is displayed");
	}
	//String id = driver.getWindowHandle();
	//System.out.println(id);
	//SoftAssert sa=new SoftAssert();
	//sa.assertEquals(title, "Clear");
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 //Logout

    /*driver.findElement(By.xpath("//div[@class='headerLogoutBtn']")).click();
	// Verify logout is successful
	String url1 = driver.getCurrentUrl();
	System.out.println(url1);
	Assert.assertEquals(url1, "http://192.168.150.205:1000/CE/Product/Modules/SignIn.aspx");
	{
		System.out.println("Portal is logged out successfully");
	}*/
	
	
}

 @Test(priority=2,enabled=true)
public void UploadFile() throws AWTException, InterruptedException

{
	driver.findElement(By.xpath("//div[@class='uploadButton']")).click();
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//driver.switchTo().frame("CEUploadeframe");
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("CEUploadeframe")));
	
	//WebElement popup = driver.findElement(By.xpath("//td[@class='popupBG']"));

	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vcTitle']")));
	element1.sendKeys("PFTtest-ingest");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("vcAssetMasterID")).sendKeys("123");
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	//Scroll down and select ip 
	
	WebElement dropdown = driver.findElement(By.xpath("//select[@id='vcAsperaId']"));
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
	//dropdown.click();
	Select value = new Select(dropdown);
	value.selectByVisibleText("10.1.95.100");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Browse file 
	Robot r = new Robot();
			
	driver.findElement(By.xpath("//div[@class='browseButton']")).click();
	//Thread.sleep(3000);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waiting")));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//upload.sendKeys("C:\\Viacom18\\Ingest\\TEST.mp4");
	
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
  //Thread.sleep(1500);
	
	//Uploading file using Robot class
   StringSelection stringselection=new StringSelection("C:\\Viacom18\\Ingest\\TEST.mp4");
   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
   
   r.setAutoDelay(3000);
   
   r.keyPress(KeyEvent.VK_CONTROL);
   r.keyPress(KeyEvent.VK_V);
   r.keyRelease(KeyEvent.VK_CONTROL);
   r.keyRelease(KeyEvent.VK_V);
   
   r.setAutoDelay(3000);
   
   r.keyPress(KeyEvent.VK_ENTER);
   r.keyRelease(KeyEvent.VK_ENTER);
   
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnUpload"))).click();
   
   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waiting")));
   
  String alertmsg = wait.until(ExpectedConditions.elementToBeClickable(By.className("alertGreen"))).getText();
   
  //WebElement alertmsg = driver.findElement(By.className("alertGreen"));
  //String alertmsg = driver.switchTo().alert().getText();
  System.out.println(alertmsg);
  Assert.assertEquals(alertmsg, "Success");
   {
	  System.out.println("File upload initiated successfully");
   }
 
   //transfer history
  // WebElement transferHistory = driver.findElement(By.id("gTransferHistory"));
 // List<WebElement> tableRows = transferHistory.findElements(By.xpath("//tr[@class='dataGridHeader']"));
  WebElement titleCol = driver.findElement(By.xpath("//tr[2]/td[2]"));
  String NewEntry = titleCol.getText();
  System.out.println("Newly ingested asset entry is available in transfer history dashboard-->" +NewEntry);
 
   //driver.findElement(By.id("btnUpload")).click();
   
	
	//String AsperaText = driver.switchTo().alert().getText();
	//System.out.println(AsperaText);
	
	

	/*	try 
		{
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().getT
			ext();
			
			
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Alert is not present");
		}*/
	
}

private boolean AssertEquals(String alertmsg, String string)
{
	// TODO Auto-generated method stub
	return false;
}

@Test(priority=3,enabled=true)
public void LogoutCEportal()
{
	driver.findElement(By.xpath("//div[@title='Logout']")).click();
	String LogoutUrl = driver.getCurrentUrl();
	Assert.assertEquals(LogoutUrl, "http://192.168.150.205:1000/CE/Product/Modules/SignIn.aspx");
	{
		System.out.println("CE portal is logged out successfully");
	}
	
}

@Test(priority=4,enabled=true)
public void LoginBCportal() throws AWTException, InterruptedException
{
  //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
/*  JavascriptExecutor jse = ((JavascriptExecutor)driver);
  jse.executeScript("window.open()");
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  
  ArrayList<String> Al = new ArrayList<String>(driver.getWindowHandles());
  System.out.println(Al);
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  driver.switchTo().window(Al.get(1));*/
 driver.get("http://192.168.150.205:1000/BC/Product/Modules/SignIn.aspx?viacom18digital");
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  driver.findElement(By.id("editUserName")).click();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  driver.findElement(By.id("x-username")).clear();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
  driver.findElement(By.id("x-username")).sendKeys("vc_user");
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  
  driver.findElement(By.xpath("//input[@id='loginContinue']")).click();
  
  //driver.findElement(By.xpath("//input[@id='loginContinue']")).click();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//input[@name='x-password']")).sendKeys("July@2019");
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();
  
//verification
  String BCtitle = driver.getTitle();
  System.out.println(BCtitle);
  Assert.assertEquals(BCtitle, "Clear");
  {
	  System.out.println("Viacom BC portal is logged in and Home page is displayed");
  }
  
  driver.findElement(By.id("SearchV2Button")).click();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  driver.findElement(By.id("SimpleSearchTextBox")).sendKeys("Che");
  //visibility of elements
  WebDriverWait wait = new WebDriverWait(driver,30);
  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='suggestionListDiv']/descendant::div")));
  
 List<WebElement> list = driver.findElements(By.xpath("//div[@id='suggestionListDiv']/descendant::div"));
  System.out.println("total number of suggestions in suggestion box -->" + list.size());
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  
for(int i=0; i<list.size(); i++)
 {
	 System.out.println(list.get(i).getText());
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='suggestionListDiv']/descendant::div")));
	 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	if(list.get(i).getText().equals("CheckPublishFlow"))
	 {
	 list.get(i).click();
	 break;
	 }
	
	
 }

String duration = driver.findElement(By.xpath("//span[contains(.,' Duration: ')]")).getText();
System.out.println(duration);
//String TC = (duration);
//System.out.println(TC);


driver.findElement(By.xpath("(//img[@class='searchInfoIcon FL'])"));
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='searchInfoIcon FL']"))).click();


//driver.findElement(By.xpath("(//img[@class='searchInfoIcon FL'])"));

/*JavascriptExecutor js = ((JavascriptExecutor)driver);
js.executeScript("arguments[0].scrollIntoView(true);", AssettobeClicked);*/
//AssettobeClicked.click();

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

wait.until(ExpectedConditions.presenceOfElementLocated(By.className("popupHeader")));
String AssetTitle = driver.findElement(By.className("popupHeader")).getText();

//Verify metadata tab details
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waiting")));
WebElement MetadataTab = driver.findElement(By.xpath("//div[@title='Save']"));
wait.until(ExpectedConditions.visibilityOf(MetadataTab));
if(MetadataTab.isDisplayed())
{
	System.out.println("Metadata tab is loading");
}

//Verify Audittrial tab 
wait.until(ExpectedConditions.elementToBeClickable(By.id("AuditTrail"))).click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
WebElement AuditTrialTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(.,'VD--2032')]")));
if(AuditTrialTab!=null)
{
	System.out.println("Metadata in AuditTrial Tab is loaded");
}
else
{
	System.out.println("AuditTrial tab details is loading blank");
}

//Verify Essence tab
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Essence"))).click();

WebElement EssUploadBtn = wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("essenceUploadBtnV1"))));
//WebElement EssUploadBtn = driver.findElement(By.id("essenceUploadBtnV1"));
if(EssUploadBtn.isDisplayed())
{
	System.out.println("Essence tab metadata is loaded");
}
else
{
	System.out.println("Essence tab is loading blank");
}

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waiting")));


System.out.println("Asset detail pop-up is displayed and the title of the asset is --->" +AssetTitle);

WebElement PlayerComponents = driver.findElement(By.xpath("//div[@title='Play/Pause']"));
wait.until(ExpectedConditions.visibilityOfAllElements(PlayerComponents));
if(PlayerComponents.isDisplayed())
{
	System.out.println("Player is loading");
}
else
{
	System.out.println("player is not loading");
}

//Check streaming
//String TCin = driver.findElement(By.xpath("//div[@id='CMP_AssetPlayerInstance_dvFrameTime']")).getText(); //TCin
//System.out.println(TCin);

//String AssetDuration = driver.findElement(By.xpath("//div[@id='CMP_AssetPlayerInstance_dvSeekTime']")).getText(); //full video duration
String AssetDuration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='CMP_AssetPlayerInstance_totalDuration']"))).getText();
System.out.println("asset is loading and duration is -->" +AssetDuration);


//WebElement loading = driver.findElement(By.xpath("//span[contains(.,'ing')]"));
Boolean loading = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(.,'ing')]")));
System.out.println("video is buffering"    +loading);




//WebElement buffering = driver.findElement(By.id("CMP_CatalogPlayerV2Container_playerStateDisplayText"));
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CMP_AssetPlayerInstance_slider\"]/span")));
   WebElement slider = driver.findElement(By.xpath("//*[@id=\"CMP_AssetPlayerInstance_slider\"]/span"));
   //WebElement slider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[3]"));
   
   if(slider.isDisplayed())
   {
	   System.out.println("Slider is displayed");
	   for(int i=0;i<=5;i++)
	   {
		   Actions actions = new Actions(driver);
		   actions.moveToElement(slider).clickAndHold().sendKeys(Keys.ARROW_RIGHT);   
	   }
	   //Actions actions = new Actions(driver);
	   //actions.moveToElement(slider).clickAndHold().sendKeys(Keys.ARROW_RIGHT);
	 
   } 
   else
   {
	   System.out.println("Asset is not streaming");
   }
   
  WebElement playbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CMP_AssetPlayerInstance_btnCMPPlayPause")));
  playbutton.click();
  Thread.sleep(5);
  playbutton.click();
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CMP_AssetPlayerInstance_dvSeekTime\"]"))).getText();
  String videotime = driver.findElement(By.xpath("//*[@id=\"CMP_AssetPlayerInstance_elapsedTime\"]")).getText();
  System.out.println("video time duration"    +videotime);
 
 if(videotime != null)
 {
	 System.out.println("Asset is streaming");
 }
 else
 {
	 System.out.println("Asset is not streaming");
 }
 
wait.until(ExpectedConditions.elementToBeClickable(By.id("closePFTPopup"))).click();

  
 // Actions act= new Actions(driver);
 // WebElement sildermsg = driver.findElement(By.id("CMP_AssetPlayerInstance_timeCodeDisplay"));
 // act.clickAndHold().moveToElement(sildermsg).perform();
 // System.out.println(sildermsg.getText());
  
  
/* driver.findElement(By.id("CMP_AssetPlayerInstance_dvFrameTime")).getText();
 
  
 slider = driver.findElement(By.xpath("//*[@id=\"CMP_AssetPlayerInstance_slider\"]/span"));
 wait.until(ExpectedConditions.elementToBeSelected(slider));
 act.moveToElement(slider).perform();
 String tooltipMsg = slider.getText();
 System.out.println("time duration displaying in tool tip is " +tooltipMsg);*/
  
  //slider.getAttribute("title");
	  
  
	  
  
	


//Actions actions = new Actions(driver);
//actions.clickAndHold(slider).dragAndDropBy(slider, 937, 475).release().build().perform();
//actions.dragAndDropBy(slider, 937, 475).release().build().perform();
//slider.click();
//String TextOnPlayer = driver.findElement(By.xpath("//span[@class='errorMessage']")).getText();

/*if(driver.findElement(By.linkText("see here")).isDisplayed())
{
	System.out.println("AdobeFlashMessage is displayed");
}
else if (driver.findElement(By.xpath("//span[contains(.,'Error')]")).isDisplayed())
{
	System.out.println("Error message is displayed");
}
else
{
	System.out.println("Player is loaded");
}*/


//closing asset detail pop-up
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//driver.findElement(By.id("closePFTPopup")).click();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("see here")));
//driver.findElement(By.linkText("see here")).click();
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



}



@Test(priority=5,enabled=true)
public void VerifyCatalogdashboard()
{
	
//mousehover to viacom18digital

WebElement role = driver.findElement(By.id("ddSelectedRole"));
Actions actions = new Actions(driver);
actions.moveToElement(role).click().build().perform();

//move to catalog role and select 
WebElement catalogrole = driver.findElement(By.id("Role_1"));
actions.moveToElement(catalogrole).click().build().perform();
WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='headerDashboardBtn']"))).click();
//driver.findElement(By.id("Cataloging")).click();
WebElement catdashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Cataloging")));
catdashboard.click();

//get today date and time

/*SimpleDateFormat dateforamt = new SimpleDateFormat("dd MMMM yyyy");
Date today = Calendar.getInstance().getTime();
String date = dateforamt.format(today);
System.out.println(date);*/

//catalogDashboard Entries


WebElement Catdashele = driver.findElement(By.xpath("//div/div[@id='Pagination']"));
wait.until(ExpectedConditions.visibilityOfAllElements(Catdashele));

if(Catdashele.isDisplayed())
{	
System.out.println("catalog dashboard data is loading and pagination icon is present");
}
else
{
	System.out.println("Catalog dashboard is loading blank");
}

}

@Test(priority=6,enabled=true)
public void Filters() throws InterruptedException 
{
	String filter_xpath="//select[@id='vCatalogstatus']//option";
	selectFilter(filter_xpath,"QC Completed");
	Thread.sleep(1000);
	selectFilter(filter_xpath,"In Progress");
	Thread.sleep(1000);
	selectFilter(filter_xpath,"Completed");
	Thread.sleep(1000);
	selectFilter(filter_xpath,"Not Started");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("clearLogout")).click();
}

public static void selectFilter(String xpath,String value) throws InterruptedException
{
	List<WebElement> StatusOptions = driver.findElements(By.xpath(xpath));
	System.out.println("Total number of status filters are" +StatusOptions.size());
	for(int i=0; i<StatusOptions.size(); i++)
	{
		System.out.println(StatusOptions.get(i).getText());
		if(StatusOptions.get(i).getText().equals(value))
		{
			StatusOptions.get(i).click();
			Thread.sleep(1000);
			System.out.println("Applied filter is -->" +driver.findElement(By.xpath("//div[contains(@class,'Status')]")).getText());
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(value, driver.findElement(By.xpath("//div[contains(@class,'Status')]")).getText());
			sa.assertAll();
			break;
		}
	}
}


@Test(priority=7,enabled=true)
public void QcLogin()
{
	driver.get("http://192.168.150.205:1000/QC/product/modules/signin.aspx?viacom18digital");
	boolean un = driver.findElement(By.className("loginText")).isDisplayed();
	System.out.println(un);
	driver.findElement(By.className("loginText")).sendKeys("shilpa_viacomuser");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement continuebtn = driver.findElement(By.xpath("//input[@class='loginButton']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", continuebtn);
    driver.findElement(By.cssSelector("input[placeholder=Password]")).sendKeys("Shilpa@9620");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement pwd=driver.findElement(By.id("ctl00_signInPanel_Sign"));
    js.executeScript("arguments[0].click();", pwd);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    //QC login verification
    String QCdashboard = driver.findElement(By.className("pftHeader")).getText();
    System.out.println(QCdashboard);
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(QCdashboard, "QC Dashboard");
    {
    	System.out.println("QC dashboard is logged in successfully");
    }
    sa.assertAll();
}
@Test(priority=8)
public void VerifyqcPopup()
{
		/*
		 * WebElement asset = driver.findElement(By.xpath("//th[3]"));
		 * System.out.println(asset.getText()); asset.click()
		 */;
		 
		boolean Newqcpopup = driver.findElement(By.id("btnNewEntry")).isDisplayed();
		
		System.out.println(Newqcpopup);
		if(Newqcpopup==true)
		{
			System.out.println("New button is displaying");
		}
		/*
		 * driver.findElement(By.id("btnNewEntry")).click(); WebDriverWait wait = new
		 * WebDriverWait(driver,20);
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waiting")))
		 * ; driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); WebElement
		 * errorpopup = driver.findElement(By.xpath("//div[.='Unauthorized Access']"));
		 * System.out.println(errorpopup.isDisplayed()); String errormsg =
		 * errorpopup.getText(); SoftAssert sa = new SoftAssert();
		 * sa.assertEquals(errormsg, "Unauthorized Access"); {
		 * System.out.println("QC popup is not loading");
		 * 
		 * } sa.assertAll();
		 */
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement qcstatus = driver.findElement(By.id("ctl00_contentPlaceHolder1_List_QC_Status"));
		Select s = new Select(qcstatus);
		System.out.println(s.getOptions());
		s.selectByVisibleText("Fail");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("div.headerLogoutBtn")).click();
		String logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='clearLoginLogo']"))).getText();
		System.out.println(logo);
		SoftAssert sa = new SoftAssert();
		
		
		
		
}
}


