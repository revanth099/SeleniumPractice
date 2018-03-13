package Programs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartTest {
	
WebDriver driver;
	@Test(priority=1)
	void LaunchBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com");
			String your_title = "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";
			String currentWindow = driver.getWindowHandle();  //will keep current window to switch back
			for(String winHandle : driver.getWindowHandles()){
			   if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
			     //This is the one you're looking for
			     break;
			   } 
			   else {
			      driver.switchTo().window(currentWindow);
			   } 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test(priority=2)
	void ClosePopUp() {
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//body[@class='fk-modal-visible']/div[2]/div/div/button")).click();
		List<WebElement> set=driver.findElements(By.tagName("a"));
		System.out.println(set);
		
	}
  @AfterTest
  public void f() {
	  driver.quit();
  }
}
