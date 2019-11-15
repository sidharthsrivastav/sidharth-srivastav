package testNG;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.*;

@Test
public class Tipscrossbrowser {
	WebDriver driver;
	Workbook wb;
	Sheet sheet;

  @Test
  @Parameters("browser")
  public void binvokebrowser(String browser) throws Exception {
	//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				System.setProperty("webdriver.firefox.marionette", "C:\\Sid_Folder\\Selenium\\geckodriver-v0.23.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver","C:\\Sid_Folder\\Selenium\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();
			}
			
			//Check if parameter passed as 'IE'
			else if(browser.equalsIgnoreCase("ie")){
				
			
		    	System.setProperty("webdriver.ie.driver", "C:\\Sid_Folder\\Selenium\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
		    	driver = new InternetExplorerDriver();
		    	
			}
			
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//Launch Browser	
			driver.get("http://ttipsweb01q.tbccorp.com/ntwtips/");
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(),"http://ttipsweb01q.tbccorp.com/ntwtips/distribution/search/","Login Failed");

		}  
	  
	 
  @Test
  public void csubmitorder() throws Exception, Exception {
	     File src= new File("C:/data.xls");
	     System.out.println("Excel located");	     
	     Workbook wb=Workbook.getWorkbook(src);
	     Sheet sheet=wb.getSheet(0);
	     System.out.println("Workbook loaded");
	     
	/*     String data00=wb.getSheet(0).getCell(0, 0).getContents();
	     System.out.println("Data is " +data00);
	     
	     String data01=wb.getSheet(0).getCell(1, 0).getContents();
	     System.out.println("Data is " +data01);*/
	     
	     int rowCount=sheet.getRows();
	     
	     for(int i=1; i<rowCount; i++)
	     {   		

	    	    String username= sheet.getCell(0, i).getContents();
	     		String password=sheet.getCell(1, i).getContents();
	     		String tiresize=sheet.getCell(2, i).getContents();
	     		String delivery=sheet.getCell(3,i).getContents();
	     	//Login
				driver.findElement(By.id("fldAccount")).sendKeys(username);
				driver.findElement(By.id("fldPassword")).sendKeys(password);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
	            System.out.println("username is" +username); 
	            System.out.println("Password is" +password);
	            System.out.println("delivery is" +delivery);
	            Thread.sleep(5000);
	         //Validate if login was successful
	            Assert.assertEquals(driver.getCurrentUrl(),"http://ttipsweb01q.tbccorp.com/ntwtips/distribution/search/","Login Failed");
	         //TireSearch
				driver.findElement(By.id("fldSearchSize")).sendKeys(tiresize);
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
				String Article=driver.findElement(By.xpath("//div[@id='items']/div[5]/div[2]/div[2]/div[2]/strong")).getText();
				System.out.println("The Article that is being ordered is: " +Article);
				
			//Add to Cart
				driver.findElement(By.xpath("//input[@value='']")).sendKeys("1");
				driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
				Thread.sleep(10000);
				driver.findElement(By.cssSelector("#menuIconCart > i.fas.fa-shopping-cart")).click();
				Thread.sleep(5000);
				driver.findElement(By.cssSelector(".btn-checkout")).click();
				Thread.sleep(2000);
				
			//Pick up vs Delivery									
				
				driver.findElement(By.id(delivery)).click();
				
				//driver.findElement(By.id("fldCheckoutPickupRoute")).click();						
				
	     
		   //Checkout				
				//driver.findElement(By.xpath("//div[@id='content']/form/span/button[3]")).click();
				driver.findElement(By.id("fldCheckoutPO")).sendKeys("testpo");
				driver.findElement(By.id("fldCheckoutNotes")).sendKeys("testtext");
				driver.findElement(By.id("fldConName")).sendKeys("tester");
				driver.findElement(By.id("fldConPhone")).sendKeys("1111111111");
				driver.findElement(By.id("fldConEmail")).sendKeys("tester@aol.com");
				driver.findElement(By.xpath("//div[@id='dlgCheckout']/div/div/div[3]/button[2]")).click();
				Thread.sleep(5000);
			//Capture Order Number
				String Ordernumber = driver.findElement(By.xpath("//div[@id='dlgSystemMessage']/div/div/div[2]/p/ul/li")).getText();
				System.out.println("The order number is:" +Ordernumber);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@id='dlgSystemMessage']/div/div/div[3]/button")).click();
				Thread.sleep(2000);
			//Back to TireSearch
				driver.findElement(By.linkText("Continue Shopping")).click();
				Thread.sleep(5000);
			//Logout
				driver.findElement(By.xpath("//ul[@id='ntw-top-menu']/li/a/i")).click();
				driver.findElement(By.xpath("//ul[@id='ntw-side-menu']/li[12]/a")).click();
				Thread.sleep(2000);
				
	            
  }
}
        @Test
  		public void dclosebrowswer() {
  		
         //Browser close and Workbook close	
  			driver.close();
  			
  		}
}

