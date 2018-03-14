package Programs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BestBuy {
	private WebDriver driver;
	private String first_url="https://www.google.com";
	private String sec_url="https://www.bestbuy.com";
	private String third_url="https://www.flipkart.com";
	private By path1= By.xpath(".//*[@id='intl_english']/div/div/select");
	private By path2= By.xpath(".//*[@id='intl_english']/div/div/div[1]/img");
	private By path3= By.id("gh-search-input");
	private String product= "apple iphonex";
	private By path4= By.xpath(".//button[@class='header-search-button']");
	private By path5=By.xpath(".//*[@id='resultsTabPanel']/div[2]/div[4]/div/div[2]/div/div[1]/h4/a");
	private By path6=By.xpath(".//*[@id='pdp-add-to-cart-button']/div/button");
	private By path7=By.xpath(".//*[@id='adttlb-modal']/div/div/div[2]/div/div[1]/p");
	private By fpath1= By.name("q");
	private By fpath2=By.xpath(".//*[@data-reactid='18']");
	private By fpath3=By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div/div[1]/div/a/div[3]/div[1]/div[1]");
	private String tagname="div";
	@BeforeMethod
	 public void Setup() {
		 try {
			 System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			 driver.get(first_url);
			 String title1= "google";
			 String title2= driver.getWindowHandle();
			 for(String title3:driver.getWindowHandles()) {
				 if(driver.switchTo().window(title3).equals(title1)) {
					 break;
				 }
				 else {
				      driver.switchTo().window(title2);
				   } 
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  @Test
  public void BestBuyAddtoCart() {
	  try {
		driver.get(sec_url);
		  Thread.sleep(5000);
		  Select country=new Select(driver.findElement(path1));
		  country.selectByIndex(1);
		  driver.findElement(path2).click();
		  Thread.sleep(7000);
		  driver.findElement(path3).sendKeys(product);
		  driver.findElement(path4).click();
		  Thread.sleep(5000);
		  driver.findElement(path5).click();
		  driver.findElement(path6).click();
		  Thread.sleep(5000);
		  boolean id=driver.findElement(path7).isDisplayed();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  }
  @Test
  public void FlipkartAddtoCart() {
	  try {
		driver.get(third_url);
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//body[@class='fk-modal-visible']/div[2]/div/div/button")).click();
		  driver.findElement(fpath1).sendKeys(product);
		  driver.findElement(fpath2).click();
		  Thread.sleep(5000);
		  driver.findElement(fpath3).click();
		  /*String titlef1= "Apple iPhone X (Space Gray, 64 GB) Online at Best Price with Great Offers Only On Flipkart.com:";
			 String titlef2= driver.getWindowHandle();
			 for(String titlef3:driver.getWindowHandles()) {
				 if(driver.switchTo().window(titlef3).equals(titlef1)) {
					 break;
				 }
				 else {
				      driver.switchTo().window(titlef2);
				   } 
			 }*/
		  	String title=driver.getTitle();
			 System.out.println(title);
			 String url=driver.getCurrentUrl();
			 System.out.println(url);
			 List<WebElement> divs= driver.findElements(By.tagName(tagname));
			 System.out.println(divs);
			 
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @AfterMethod
  public void NavigateBack() {
	  driver.navigate().back();
	  String urlb= driver.getCurrentUrl();
	  System.out.println(urlb);
	  String titleb=driver.getTitle();
	  System.out.println(titleb);
	  driver.close();
	  driver.quit();
  }
}
