package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class cars_debug {
	@Test
	public void runSikuli() throws FindFailed, IOException {
		try {
			Screen screen=new Screen();
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\RPOS\\RPOS.exe"); 
			Thread.sleep(5000);
			Pattern usr=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\username.jpg");
			screen.click(usr);
			screen.type("12925373");
			screen.doubleClick(usr);
			screen.type("c", Key.CTRL);
			Pattern pwd=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\password.jpg");
			screen.click(pwd);
			screen.type("Quality1");
			Pattern str=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\store.jpg");
			screen.click(str);
			screen.type("6012");
			Thread.sleep(2000);
			Pattern log=new Pattern("C:\\Sid_Folder\\Selenium\\SikuliImages\\login.jpg");
			//screen.findText("C:\\Sid_Folder\\Selenium\\SikuliImages\\login.jpg");
			Settings.OcrTextSearch=true;
			Settings.OcrTextRead=true;
			String abc=screen.find("C:\\Sid_Folder\\Selenium\\SikuliImages\\English.jpg").text();
			System.out.println("Button text is:\n"+abc);
			//System.out.println("Button text is:\n"+screen.find("C:\\Sid_Folder\\Selenium\\SikuliImages\\English.jpg").text());
			
			//screen.click(log);
			//Thread.sleep(5000);
			//screen.click("C:\\Sid_Folder\\Selenium\\SikuliImages\\ordersearch.jpg");
			//Thread.sleep(2000);
			//screen.type("40000");
			//screen.type("v", Key.CTRL);
			//String img=screen.capture().save("C:/Sid_Folder", "test");

					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
