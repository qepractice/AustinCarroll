package assignmentFive;

import java.awt.Desktop.Action;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.MobileElement;

public class AssignmentFive {
	
	public static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities ();
		

		capabilities.setCapability("chromedriverExecutable", "C:\\Users\\aucarroll\\Desktop\\Automation Training\\chromedriver.exe");
		capabilities.setCapability("automationName","UiAutomator1");
		capabilities.setCapability("deviceName","Pixel 3 XL API 24");
		capabilities.setCapability("platformVersion", "7");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("browserName","Chrome");
		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		capabilities.setCapability("unicodeKeyboard",true);
		
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.chase.com"); 
		
		String searchResult1 = "2";
		String feedback = "You're damaged goods, comment box...";
		
				
		// Click Hamburger Menu
		driver.findElement(By.xpath("//*[@id=\"skip-sidemenu\"]")).click();
		
		//Select Customer Service
		driver.findElement(By.xpath("//*[@id=\"side-menu-header\"]/div[5]/div[2]/ul/li[1]/a")).click();
				
		//Click on Popular Topics 
		driver.findElement(By.id("SubHeaderOriginal")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Click on Search more topics and search any random topic and print result
		driver.findElement(By.xpath("//*[@id=\"popular\"]/div[2]/div/div/div/div[2]/div/div/div/div/div/ul/li[8]/a")).click();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// Search bar click
		driver.findElement(By.xpath("//*[@id=\"Module0\"]/section/section[1]/div[4]/form/label/input")).sendKeys("Boat Loans");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
				
		// Print Search Results "//*[@id="Module0"]/section/section[3]"
		String searchResults1 = driver.findElement(By.xpath("//*[@id=\"Module0\"]/section/section[3]")).getText();
		System.out.print("Boat Loan: " + searchResults1);
		
		//Select home page
		driver.findElement(By.xpath("//*[@id=\"skip-sidemenu\"]")).click();

		//Click on Give feedback option 
		driver.findElement(By.xpath("//*[@id=\"side-menu-header\"]/div[5]/div[2]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// Focus to new window
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		driver.switchTo().window("CDwindow-1");
		
		//Fill the form out		
		driver.findElement(By.xpath("//*[@id=\"rater_buttons\"]/div[3]/label")).click();
		driver.findElement(By.id("comment_box")).clear();
		//"//*[@id=\"comment_box\"]"
		driver.findElement(By.xpath("//*[@id=\"comment_box\"]")).sendKeys(feedback);
		String textBox = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]")).getText();
		System.out.print(textBox);
		//Close Home page and feedback page
		driver.close();
		driver.quit();
		
	}

}
