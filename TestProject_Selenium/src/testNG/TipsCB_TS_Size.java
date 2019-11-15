package testNG;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.*;

@Test
public class TipsCB_TS_Size {
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
			
	
			
  }
	  
	 
  @Test
  public void ctiresearch() throws Exception, Exception {
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
	     		String type=sheet.getCell(4,i).getContents();
	     		String brand=sheet.getCell(5,i).getContents();
	     		String line=sheet.getCell(6,i).getContents();
	     		String year=sheet.getCell(7,i).getContents();
	     		String make=sheet.getCell(8,i).getContents();
	     		String model=sheet.getCell(9,i).getContents();
	     		String trim=sheet.getCell(10,i).getContents();
	     		String size=sheet.getCell(11,i).getContents();
	     	
	     	 //Login
				driver.findElement(By.id("fldAccount")).sendKeys(username);
				driver.findElement(By.id("fldPassword")).sendKeys(password);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(5000);
		     //Validate if login was successful
	            Assert.assertEquals(driver.getCurrentUrl(),"http://ttipsweb01q.tbccorp.com/ntwtips/distribution/search/","Login Failed");	        

	            System.out.println("username is" +username);
	            System.out.println("Password is" +password);
	            //System.out.println("type is" +type);
	            //System.out.println("brand is" +brand);
	            
	            
	         //TireSearch by Size
				driver.findElement(By.id("fldSearchSize")).sendKeys(tiresize);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@id='fldFilterType_chosen']/a/span")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldFilterType_chosen']/div/ul/li["+type+"]")).click();
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
				String Article=driver.findElement(By.xpath("//div[@id='items']/div[5]/div[2]/div[2]/div[2]/strong")).getText();
				System.out.println("The 1st Article on the list for type"  +type+  "is"  +Article);
				
		    //TireSearch by Brand
				driver.findElement(By.linkText("Brand")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchBrandVendor_chosen']/a/span")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchBrandVendor_chosen']/div/div/input")).sendKeys(brand);
				driver.findElement(By.xpath("//div[@id='fldSearchBrandVendor_chosen']/div/div/input")).sendKeys(Keys.TAB);
		        //Another way of selecting from the drop down		
				//driver.findElement(By.xpath("//div[@id='fldSearchBrandVendor_chosen']/div/ul/li["+brand+"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchBrandLine_chosen']/a/div/b")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchBrandLine_chosen']/div/div/input")).sendKeys(line);
				driver.findElement(By.xpath("//div[@id='fldSearchBrandLine_chosen']/div/div/input")).sendKeys(Keys.TAB);
				//driver.findElement(By.xpath("//div[@id='fldSearchBrandLine_chosen']/div/ul/li["+line+"]")).click();
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
				String Article1=driver.findElement(By.xpath("//div[@id='items']/div[5]/div[2]/div[2]/div[2]/strong")).getText();
				System.out.println("The 1st Article on the list for brand " +brand+  "line"  + line+  "is"  +Article1);
			
			//TireSearch by Vehicle
				driver.findElement(By.linkText("Vehicle")).click();
				//year
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleYear_chosen']/a/span")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleYear_chosen']/div/div/input")).sendKeys(year);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleYear_chosen']/div/div/input")).sendKeys(Keys.TAB);
				//make
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleMake_chosen']/a/span")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleMake_chosen']/div/div/input")).sendKeys(make);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleMake_chosen']/div/div/input")).sendKeys(Keys.TAB);
				//model
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleModel_chosen']/a/span")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleModel_chosen']/div/ul/li["+model+"]")).click();
				//Trim
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleTrim_chosen']/a/span")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleTrim_chosen']/div/ul/li["+trim+"]")).click();
				//Size
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleSize_chosen']/a/span")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='fldSearchVehicleSize_chosen']/div/ul/li["+size+"]")).click();
				//Search
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
				String Article2=driver.findElement(By.xpath("//div[@id='items']/div[5]/div[2]/div[2]/div[2]/strong")).getText();
				System.out.println("The 1st Article on the list for Year " +year+  "make"  + make+  "model" +model+ "is" +Article2);

			//Logout
				
				driver.findElement(By.xpath("//ul[@id='ntw-top-menu']/li/a/i")).click();
				driver.findElement(By.xpath("//ul[@id='ntw-side-menu']/li[12]/a")).click();
				Thread.sleep(2000);
	            
  }
}
        @Test
  		public void dclosebrowswer() {
  		
       //Browser close
  			driver.close();
  			
  		}
}

