package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDependency {
	WebDriver driver;
	
  @Test
  public void openBrowser() {
	  
	  
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Sid_Folder\\Selenium\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.get("http://ttipsweb01q.tbccorp.com/ntwtips/");
			Thread.sleep(5000);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
  
  }
 
  @Test (dependsOnMethods= {"openBrowser"})
  public void login() {
	  try {
			driver.findElement(By.id("fldAccount")).sendKeys("20660846");
			driver.findElement(By.id("fldPassword")).sendKeys("Testing1");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
  }
  
  
  
}
