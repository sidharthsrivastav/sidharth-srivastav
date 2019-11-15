package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class Sikuli_test {
	@Test
	public void runSikuli() throws FindFailed, IOException {
		try {
			Screen screen=new Screen();
	//Script data
			String username="12925373";
		    String password="Welcome1!";
			
	//Launch RPOS
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\RPOS\\RPOS.exe"); 
			Thread.sleep(5000);
	//Login
			Pattern usr=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\username.jpg");
			screen.click(usr);
			screen.type(username);
			Pattern pwd=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\password.jpg");
			screen.click(pwd);
			screen.type(password);
			Pattern str=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\store.jpg");
			screen.click(str);
			screen.type("6012");
			Pattern log=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\login.jpg");
			screen.click(log);
			Thread.sleep(8000);
			
	//Pop up close
			//screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\close.jpg");
			//Thread.sleep(2000);
	//Work Order
			Pattern wo=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\workorder.jpg");
			screen.click(wo);
			Thread.sleep(2000);
			screen.click(pwd);
			screen.type(password);
			screen.click(log);
			Thread.sleep(8000);
			//screen.doubleClick("C:\\Sid_Folder\\Selenium\\SikuliImages\\cap.jpg");
			//screen.type('c', Key.CTRL);
	//Customer Search
			Pattern phone=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\phone.jpg");
			screen.click(phone);
			screen.type("5612223333");
			Thread.sleep(1000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\fname.jpg");
			screen.type("Sidharth");
			Thread.sleep(1000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\lname.jpg");
			screen.type("Srivastav");
			Thread.sleep(1000);
			//screen.doubleClick(phone);
			//screen.type("c", Key.CTRL);
			//screen.type("v", Key.CTRL);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\search.jpg");
			Thread.sleep(5000);
	//Carry Out Flow
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\carryout.jpg");
			Thread.sleep(2000);
	//Tire Search by Part no
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\tires.jpg");
			Thread.sleep(2000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\tsearch.jpg");
			screen.type("mich-22044");
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\searchpartno.jpg");
			Thread.sleep(5000);
			
	//Add to Cart
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\addtocart.jpg");
			Thread.sleep(5000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\additemstoorder.jpg");
			Thread.sleep(10000);
			screen.doubleClick("C:\\Sid_Folder\\Selenium\\SikuliImages\\cap.jpg");
			//Thread.sleep(2000);
	//Copy Order number
			screen.type("c", Key.CTRL);
			Thread.sleep(2000);
			screen.capture().save("C:/Sid_Folder/Selenium/SikuliImages/Output", "ShopCart");
			Thread.sleep(2000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\completeorder.jpg");
			Thread.sleep(3000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\idtypeenter.jpg");
			screen.type("License Plate");
			Thread.sleep(2000);
			//screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\licplate.jpg");
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\id.jpg");
			screen.type("ABC123");
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\authwo.jpg");
	//Wait for the refresh button
			Thread.sleep(45000);
			//screen.wait("C:\\Sid_Folder\\Selenium\\SikuliImages\\refresh.jpg");
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\refresh.jpg");
	//Order Search on dashboard			
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\ordersearch.jpg");
			Thread.sleep(2000);
			//screen.type("0");
			screen.type("v", Key.CTRL);
			//screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\ordernosearch.jpg");
			Thread.sleep(2000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\carrydash.jpg");
			screen.click(pwd);
			screen.type(password);
			screen.click(log);
			Thread.sleep(10000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\viewitems.jpg");
			Thread.sleep(5000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\completeorder.jpg");
			Thread.sleep(5000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\print.jpg");
			Thread.sleep(5000);
	//Capture Order no, balance & screenshot of payment screen
			Settings.OcrTextSearch=true;
			Settings.OcrTextRead=true;
			String Balance=screen.find("C:\\Sid_Folder\\Selenium\\SikuliImages\\balance.jpg").text();
			Thread.sleep(2000);
			System.out.println("Balance is:\n"+Balance);
			screen.capture().save("C:/Sid_Folder/Selenium/SikuliImages/Output", "paymentscreen");
			Thread.sleep(2000);
	//Cash Payment
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\cash.jpg");
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\amount.jpg");
			screen.type("90");
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\apply.jpg");
			Thread.sleep(5000);
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\final.jpg");
			Thread.sleep(20000);	
			String Order=screen.find("C:\\Sid_Folder\\Selenium\\SikuliImages\\order.jpg").text();
			Thread.sleep(2000);
			System.out.println("Order no is:\n"+Order);
			
	//Close Browser		
			screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\closebrowser.jpg");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
