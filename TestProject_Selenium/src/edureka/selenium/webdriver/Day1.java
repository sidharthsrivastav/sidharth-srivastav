package edureka.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		
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
	
	public void tiresearch() {
		try {
			driver.findElement(By.id("fldSearchSize")).sendKeys("2157015");
			driver.findElement(By.id("btnSearch")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addtocart() {
		try {
			driver.findElement(By.xpath("//input[@value='']")).sendKeys("1");
			driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
			Thread.sleep(10000);
			driver.findElement(By.cssSelector("#menuIconCart > i.fas.fa-shopping-cart")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkout() {
		try {
			driver.findElement(By.xpath("//div[@id='content']/form/span/button[3]")).click();
			driver.findElement(By.id("fldCheckoutPO")).sendKeys("testpo");
			driver.findElement(By.id("fldCheckoutNotes")).sendKeys("testtext");
			driver.findElement(By.id("fldConName")).sendKeys("tester");
			driver.findElement(By.id("fldConPhone")).sendKeys("1111111111");
			driver.findElement(By.id("fldConEmail")).sendKeys("tester@aol.com");
			driver.findElement(By.xpath("//div[@id='dlgCheckout']/div/div/div[3]/button[2]")).click();
			String Ordernumber = driver.findElement(By.xpath("//div[@id='dlgSystemMessage']/div/div/div[2]/p/ul/li")).getText();
			System.out.println("The order number is:" +Ordernumber);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closebrowser() {
		driver.close();
	}
	//public void shopcart() {
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[4]/header/div/div[3]/div[2]/div[1]/div/a/img")).click();
		//jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0,1000)");
		
	//}

	public static void main(String[] args) {
		
		try {
			for (int i = 0; i < 1; i++) {
				Day1 myobj = new Day1();
				myobj.invokeBrowser();
				myobj.login();
				Thread.sleep(5000);
				myobj.tiresearch();
				Thread.sleep(5000);
				myobj.addtocart();
				Thread.sleep(3000);
				myobj.checkout();
				Thread.sleep(10000);
				myobj.closebrowser();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
