package edsoftwebconference;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
public class Edsoftlive {
private WebDriver driver;

 @Test(priority=1)
 public void conferenceSection() throws Exception {
	 System.out.println("Loaded Link");
	 ChromeOptions options = new ChromeOptions();
	    //options.addArguments("use-fake-device-for-media-stream");
	   // options.addArguments("use-fake-ui-for-media-stream");
	 //https://stackoverflow.com/questions/48777822/allowing-camera-and-mic-access-in-chrome-64
	    options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized","use-fake-ui-for-media-stream"));
	    //allow camera always selenium java
	    //https://stackoverflow.com/questions/48777822/allowing-camera-and-mic-access-in-chrome-64
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "7 79.0.3945.130");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "7.1");
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
	   // WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	  System.setProperty("webdriver.chrome.driver", "E:\\Test\\Automate\\driver\\chromedriver.exe");
	    driver = new ChromeDriver(options); driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	    
   driver.get(" https://vc.edsoft.us/login"); 
   driver.manage().window().maximize();
   String Title = driver.getTitle();
   System.out.println(Title);
   Assert.assertTrue(driver.getTitle().matches("EdSoft Technologies"),"Invalid Credentials");
   System.out.println("Login successful");
   driver.findElement(By.cssSelector("input.form-control[formcontrolname=email]")).sendKeys("prince.j@enfintechnologies.com");
  // driver.findElement(By.cssSelector("input.form-control[formcontrolname=email]")).sendKeys("prince.j@enfintechnologies.com");
   Thread.sleep(1000);
   driver.findElement(By.cssSelector("input.form-control[formcontrolname=password]")).sendKeys("123456ab");
   Thread.sleep(2000);
   driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[3]/button")).click();
  Thread.sleep(10000); 
   driver.findElement(By.xpath("/html/body/app-root/app-teacher-dashboard/div/div/button")).click();
Thread.sleep(5000);
   driver.findElement(By.cssSelector("input.form-control[formcontrolname=classTitle]")).sendKeys("testapril8");
   Thread.sleep(2000);
   driver.findElement(By.cssSelector("textarea.form-control[formcontrolname=classInfo]")).sendKeys("testinfo");
   Thread.sleep(2000);
   driver.findElement(By.name("classDuration")).clear();
   driver.findElement(By.name("classDuration")).sendKeys("150");
   Thread.sleep(4000);
  // driver.findElement(By.cssSelector("input.inputtext[name=email]")).sendKeys("Software Testing Materi"); 
   //https://www.softwaretestingmaterial.com/css-selector-selenium-webdriver-tutorial/
   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("window.scrollTo(1000, document.body.scrollHeight)");  
driver.findElement(By.xpath("/html/body/app-root/app-schedule/div/div/form/div[10]/button[1]")).click();
System.out.println("clicked register button");
driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/schedulemodalcontent/div[3]/button[2]")).click();
driver.findElement(By.xpath("/html/body/app-root/app-teacher-dashboard/div/app-meeting/div/div/table/tbody/tr[1]/td[7]/button")).click();
System.out.println("clicked Launch button");
  Thread.sleep(10000);
driver.navigate().refresh();

//https://www.edureka.co/community/14143/how-open-link-new-tab-chrome-browser-using-selenium-webdriver
//https://seleniumpoint.com/New-Tab-Window-handling-using-Selenium-WebDriver/
for (String handle: driver.getWindowHandles())
{
	   System.out.println(handle);driver.switchTo().window(handle);System.out.println(driver.getCurrentUrl());
}
  //String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
  //driver.findElement(By.linkText("www.facebook.com")).sendKeys(selectLinkOpeninNewTab);
  System.out.println("Loaded Link");
  driver.findElement(By.xpath("//button[@onclick='onContinue()']")).click();
  //driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/div/button[2]")).click();
  System.out.println("Clicked Save and Continue");
 Thread.sleep(5000);
  driver.findElement(By.xpath("/html/body/div[15]/div/div/div/div[3]/button[3]")).click();
  System.out.println("Clicked Camera Cancel button");
  Thread.sleep(2000); 
  driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/ul[1]/li[1]")).click();
  System.out.println("WEB CONFERENCE");	 
  Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/ul[1]/li[2]")).click();
		  Thread.sleep(5000);
		  System.out.println("WEBinar");
		  Thread.sleep(2000);
  driver.findElement(By.xpath("//li[@onclick='loadWhiteboard()']")).click();
   driver.findElement(By.xpath("//a[@onclick='onContentLibrayOpen()']")).click();
   driver.findElement(By.xpath("//div[@id='mediaUploadPop']/div/div/div/div[2]")).click();
driver.findElement(By.id("mediaPopClose")).click();  
 driver.findElement(By.xpath("//a[@onclick='manageScreenShare()']")).click();
 driver.findElement(By.id("settings-open")).click();
 driver.findElement(By.xpath("//button[@onclick='disposeCam()']")).click();
 driver.findElement(By.id("settings-open")).click();
 driver.findElement(By.xpath("//button[@onclick='disposeCam()']")).click();		   
 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/header/ul/li[1]/a")).click();
System.out.println("clicked meeting info");
Thread.sleep(5000);   
driver.findElement(By.xpath("/html/body/div[15]/div/div/div/div[3]/button[1]")); 
System.out.println("Clicked Cancel Recording button");
Thread.sleep(4000);


}

 @Test(priority=2)
 public void clickStudentlink() throws InterruptedException
 {
	// # Again new window
	// driver.switch_to.window(driver.window_handles[1]);
	 //driver.execute_script("window.open('https://twitter.com')")
	 //https://stackoverflow.com/questions/17547473/how-to-open-a-new-tab-using-selenium-webdriver
	// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
	// driver.findElement(By.linkText("https://vc.edsoft.us/meetings")).sendKeys(selectLinkOpeninNewTab);
	 
	 System.out.println("ENTER MEETING"); 
	 driver.get("https://vc.edsoft.us/meetings");	
	   //First Get parent window,means current window handle
	  // String parentWindoww = driver.getWindowHandle();System.out.println(driver.getCurrentUrl());
	 // driver.switchTo().window(parentWindoww); //Go back to Parent window
	driver.findElement(By.xpath("/html/body/app-root/app-teacher-dashboard/div/app-meeting/div/div/table/tbody/tr[1]/td[1]/a")).click();
	Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/app-root/app-scheduled-info/div/div/div/div/div/div[1]/p[2]/a")).click();
 }
 @Test(priority=3)
 public void clickExpertlink() throws InterruptedException
 {
	 System.out.println("ENTER MEETING EXPERT LINK");
	 driver.get("https://vc.edsoft.us/meetings");
	   String parentExpert = driver.getWindowHandle();   
	 System.out.println(driver.getCurrentUrl());
	  driver.switchTo().window(parentExpert);
	  driver.findElement(By.xpath("/html/body/app-root/app-teacher-dashboard/div/app-meeting/div/div/table/tbody/tr[1]/td[1]/a")).click();
		Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/app-root/app-scheduled-info/div/div/div/div/div/div[1]/p[3]/a")).click();
 }
 @Test(priority=4)
 public void clickPresenterlink() throws InterruptedException
 {
	 System.out.println("ENTER MEETING PRESENTER LINK");
	 driver.get("https://vc.edsoft.us/meetings");
	   String parentPresenter = driver.getWindowHandle();   
	 System.out.println(driver.getCurrentUrl());
	  driver.switchTo().window(parentPresenter);
	  driver.findElement(By.xpath("/html/body/app-root/app-teacher-dashboard/div/app-meeting/div/div/table/tbody/tr[1]/td[1]/a")).click();
		Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/app-root/app-scheduled-info/div/div/div/div/div/div[1]/p[1]/a")).click();
 }
 public void closeBrowser() { driver.close();}
}

