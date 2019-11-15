package testNG;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

public class Readexcel {
	WebDriver driver;

  @Test
  public void f() throws Exception, Exception {
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
	     
	     for(int i=0; i<rowCount; i++)
	     {   		
	    	    System.setProperty("webdriver.chrome.driver", "C:\\Sid_Folder\\Selenium\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			//Launch Browser	
				driver.get("http://ttipsweb01q.tbccorp.com/ntwtips/");
				Thread.sleep(5000);
	    	    String username= sheet.getCell(0, i).getContents();
	     		String password=sheet.getCell(1, i).getContents();
	     		String tiresize=sheet.getCell(2, i).getContents();
	     	//Login
				driver.findElement(By.id("fldAccount")).sendKeys(username);
				driver.findElement(By.id("fldPassword")).sendKeys(password);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
	            System.out.println("username is" +username);
	            System.out.println("Password is" +password);
	            Thread.sleep(5000);
	         //TireSearch
				driver.findElement(By.id("fldSearchSize")).sendKeys(tiresize);
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Add to Cart
				driver.findElement(By.xpath("//input[@value='']")).sendKeys("1");
				driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
				Thread.sleep(10000);
				driver.findElement(By.cssSelector("#menuIconCart > i.fas.fa-shopping-cart")).click();
				Thread.sleep(5000);
		    //Checkout				
				driver.findElement(By.xpath("//div[@id='content']/form/span/button[3]")).click();
				driver.findElement(By.id("fldCheckoutPO")).sendKeys("testpo");
				driver.findElement(By.id("fldCheckoutNotes")).sendKeys("testtext");
				driver.findElement(By.id("fldConName")).sendKeys("tester");
				driver.findElement(By.id("fldConPhone")).sendKeys("1111111111");
				driver.findElement(By.id("fldConEmail")).sendKeys("tester@aol.com");
				driver.findElement(By.xpath("//div[@id='dlgCheckout']/div/div/div[3]/button[2]")).click();
				Thread.sleep(10000);
				String Ordernumber = driver.findElement(By.xpath("//div[@id='dlgSystemMessage']/div/div/div[2]/p/ul/li")).getText();
				System.out.println("The order number is:" +Ordernumber);
	            driver.close();
  }
  }
}
