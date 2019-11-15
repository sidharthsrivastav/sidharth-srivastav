package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestAnnotations {
  @Test
  public void f1() {
	  System.out.println("Inside f1");
  }
  @Test
  public void f2() {
	  System.out.println("Inside f2");
  }
  
  @BeforeTest
  public void bat() {
	  try {
			System.setProperty("webdriver.chrome.driver", "C:\\Sid_Folder\\Selenium\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.get("http://ttipsweb01q.tbccorp.com/ntwtips/");
			Thread.sleep(5000);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  System.out.println("Inside bat");
  }
  
  @AfterTest
  public static void aat() {
	  System.out.println("Inside aat");
  }
  
  @BeforeMethod
  public static void bm() {
	  System.out.println("Inside bm");
  }
  
  @AfterMethod
  public void am() {
	  System.out.println("Inside am");
  }
  
  @BeforeClass
  public void bc() {
	  System.out.println("Inside bc");
  }
  
  @AfterClass
  public void ac() {
	  System.out.println("Inside ac");
  }
}

