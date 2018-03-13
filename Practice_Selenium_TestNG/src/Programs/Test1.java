package Programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Test1 {
	
	protected WebDriver driver;
	
	  
	  @Test(priority=1)
	  public void testStep1() {
		  System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.google.com");
			String title1= "Google";
			String curentwindow= driver.getWindowHandle();
			for(String windhanhle:driver.getWindowHandles()) {
			if (driver.switchTo().window(windhanhle).getCurrentUrl().equalsIgnoreCase(title1)) {
				break;
			}
			else {
				driver.switchTo().window(curentwindow);
			}
			
		}
	  } 
	  
	  @Test(priority=2)
	  public String mainMethod() {
		  
		  driver.findElement(By.linkText("Gmail")).click();
		  
		  String res = driver.findElement(By.xpath("html/body/nav/div/a[2]")).getText();
		  return res; 
	  }
		  
		  
	  

	  @Test(priority=3)
	  public String testStep2() {
		  driver.navigate().back();
		  String res1=driver.getCurrentUrl();
		  driver.quit();
		  return res1;
		  
		  
	  }
	  
}
