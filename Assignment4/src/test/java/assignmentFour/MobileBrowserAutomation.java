package assignmentFour;

import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileBrowserAutomation {

	public static AndroidDriver<WebElement> driver;
	
	
	
	public static <T> void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities ();
		

			capabilities.setCapability("chromedriverExecutable", "C:\\Users\\aucarroll\\Desktop\\Automation Training\\chromedriver.exe");
			capabilities.setCapability("automationName","UiAutomator1");
			capabilities.setCapability("deviceName","Pixel 3 XL API 24");
			capabilities.setCapability("platformVersion", "7");
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("appPackage", "com.android.chrome");
			//capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
			capabilities.setCapability("browserName","Chrome");
			//add C:\Users\aucarroll\Desktop\Automation Training\chromedriver.exe
			capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://www.amazon.com"); 
			String searchResult1 = "10";
			String searchResult2 = "7";
			
			//type in search bar //*[@id="nav-search-keywords"]
			driver.findElement(By.xpath("//*[@id=\"nav-search-keywords\"]")).sendKeys("Appium Book");
			//Search button click
			driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[2]/div")).click();
			
			//xPath of search results
			// This is the original xpath //*[@id="search"]/span[3]/div[2]/div[10]/div/span/div/div/div[1]/a
			driver.findElement(By.xpath("//*[@id=\"search\"]/span/div[2]/div["+ searchResult1 +"]/div/span/div/div/div[1]/a")).click();			
				
			//Selecting book rating //*[@id="acrCustomerReviewLink"]/span[1] (//*[@id=\"acrCustomerReviewLink\"]/i)
			driver.findElement(By.xpath("//*[@id=\"acrCustomerReviewLink\"]/span[1]")).click();
			
			// print book rating -- xpath("//*[@id="acrCustomerReviewLink"]/i")
			String ele1 = driver.findElement(By.xpath("//*[@id=\"aw-udpv3-customer-reviews_feature_div\"]/span[1]/div/div/a/div/div/div[1]/span")).getText();
			System.out.print("Book Rating: " + ele1);
			
			// add to cart 
			driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
			
			// Search bar send keys 
			driver.findElement(By.xpath("//*[@id=\"nav-search-keywords\"]")).sendKeys("Selenium Book");
			// Search Button click 
			driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[2]/div/input")).click();
			
			//Select 5th selenium book xpath("//*[@id="search"]/span[3]/div[2]/div[7]/div/span/div/div/div[1]/a"
			driver.findElement(By.xpath("//*[@id=\"search\"]/span[3]/div[2]/div["+ searchResult2 +"]/div/span/div/div/div[1]/a")).click();
						
			//Selecting book rating 
			driver.findElement(By.xpath("//*[@id=\"acrCustomerReviewLink\"]/span[1]")).click();
			// Print User comments - All comments
			String ele2 = driver.findElement(By.xpath("//*[@id=\"aw-udpv3-customer-reviews_feature_div\"]")).getText();
			System.out.print("Customer Reviews: " + ele2);
			
			// add to cart
			driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
			// Select Shopping Cart
			driver.findElement(By.xpath("//*[@id=\"nav-button-cart\"]")).click();
			// Cart total
			String ele3 = driver.findElement(By.xpath("//*[@id=\"sc-proceed-to-checkout-params-form\"]/div[1]")).getText();
			System.out.println(ele3);
			
			
			
		
		
		}
		
		}
		
		
		
	


