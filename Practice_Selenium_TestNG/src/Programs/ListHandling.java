package Programs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListHandling {
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		//driver.switchTo().window("Facebook - log in or Sign up");
		String your_title = "Google";
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
		
	}
	
  @Test
  public void f() {
	  driver.findElement(By.id("lst-ib")).sendKeys("Java");
	  List<WebElement> links=driver.findElements(By.xpath(".//ul[@role='listbox']//li//div[@class='sbqs_c']"));
	  System.out.println(links.size());
	  for(int i=0;i<=links.size();i++) {
		  System.out.println(links.get(i).getText());
		  if(links.get(i).getText().equalsIgnoreCase("javatpoint")) {
			  links.get(i).click();
			  break;
		  }
		  /*else {
			  System.out.println("Expected Word not found");
		  }*/
	  }
  }
  @AfterMethod
  public void TearDown() {
	  driver.close();
	  driver.quit();
  }
}
