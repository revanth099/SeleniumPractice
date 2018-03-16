package com.DataDrivenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel_Utility.Xls_Reader;

public class DataDrivenFromExcel {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:/Users/Revanth/git/SeleniumPractice/Practice_Selenium_TestNG/src/com/TestData/Gmail/GmailTestData.xlsx");

		/*System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		//driver.switchTo().window("Facebook - log in or Sign up");
		String expec_Title = "Gmail - Free Storage and Email from Google";
		String currentWindow = driver.getWindowHandle();  //will keep current window to switch back
		for(String winHandle : driver.getWindowHandles()){
		   if (driver.switchTo().window(winHandle).getTitle().equals(expec_Title)) {
		     //This is the one you're looking for
		     break;
		   } 
		   else {
		      driver.switchTo().window(currentWindow);
		   } 
		}*/
		
		String Fname=reader.getCellData("GmailData", "firstname", 2);
		System.out.println(Fname);
	}
	

}
