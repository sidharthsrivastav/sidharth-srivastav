package testNG;

import org.openqa.selenium.WebDriver;

public class FunctionCalls {
WebDriver driver;
	public static void main(String[] args) {
		TestAnnotations.aat();
		TestAnnotations.bm();
		TestAnnotations obj=new TestAnnotations();
		obj.bat();
	
	}

}
