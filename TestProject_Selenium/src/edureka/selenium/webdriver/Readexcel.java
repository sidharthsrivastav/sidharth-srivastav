package edureka.selenium.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Readexcel {
WebDriver driver;
	public void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
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
			
			driver.get("http://ttipsweb01q.tbccorp.com/ntwtips/");
			Thread.sleep(5000);
    	    String username= sheet.getCell(0, i).getContents();
     		String password=sheet.getCell(1, i).getContents();
			driver.findElement(By.id("fldAccount")).sendKeys(username);
			driver.findElement(By.id("fldPassword")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
            System.out.println("username is" +username);
            System.out.println("Password is" +password);
            driver.close();
     }
     
	}
}


