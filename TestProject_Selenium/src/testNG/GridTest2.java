package testNG;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class GridTest2 {
	WebDriver driver;
	String nodeURL;
	
  @Test
  public void openBrowser() {
	  
		try {
			nodeURL= "http://10.7.248.107:5555/wd/hub";
		    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		    capabilities.setBrowserName("internet explorer");
		    capabilities.setPlatform(Platform.WINDOWS);
			driver=new RemoteWebDriver(new URL(nodeURL), capabilities);
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
 

  
  
}
