package testNG;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;


public class OMS_CCLogin {
	WebDriver driver;
	Workbook wb;
	Sheet sheet;
	
	 @Test
	  public void binvokebrowser() throws Exception {
		    System.setProperty("webdriver.chrome.driver", "C:\\Sid_Folder\\Selenium\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//Launch Browser	
			driver.get("http://tomsapp01q:9080/isccs/isccs/login.do");
			Thread.sleep(5000);
	  }
	  
	  @Test
	  public  void c() throws Exception, Exception {
		     File src= new File("C:/omsdata.xls");
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
		     		//String tiresize=sheet.getCell(2, i).getContents();
		     	//Login
		     		driver.findElement(By.name("username")).sendKeys(username);
		     		driver.findElement(By.name("password")).sendKeys(password);
					driver.findElement(By.id("dijit_form_Button_0_label")).click();
		            System.out.println("username is" +username);
		            System.out.println("Password is" +password);
		            Thread.sleep(5000);
					String Text=driver.findElement(By.id("sc_plat_dojo_widgets_Label_4")).getText();
					System.out.println("The Article that is being ordered is: " +Text);
					

		            
	  }
	}
	        @Test
	  		public void dclosebrowswer() {
	  		
	         //Browser close and Workbook close	
	  			driver.close();
	  			
	  		}
	}


