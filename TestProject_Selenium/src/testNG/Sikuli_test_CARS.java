package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class Sikuli_test_CARS {
	@Test
	public void runSikuli() throws FindFailed {
		try {
			Screen screen=new Screen();
			System.setProperty("webdriver.chrome.driver", "C:\\Sid_Folder\\Selenium\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.get("https://sapuiq.tbccorp.com/sap/bc/personas?~transaction=zsd_pos1&sap-client=300&sap-language=EN");
			Thread.sleep(5000);
			driver.findElement(By.id("sap-user")).sendKeys("ssrivastav");
			driver.findElement(By.id("sap-password")).sendKeys("Lovetrups2");
			driver.findElement(By.id("LOGON_BUTTON")).click();
			Thread.sleep(5000);
			Pattern Billto=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\Billto.jpg");
			screen.click(Billto);
			screen.type("20660846");
			Pattern partno=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\part.jpg");
			screen.click(partno);
			//screen.type("MTMI-GAM33");
			
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
