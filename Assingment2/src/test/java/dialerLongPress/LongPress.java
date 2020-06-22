package dialerLongPress;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LongPress {

	public static AndroidDriver<MobileElement> driver;
	
	
	public static void main(String[] args) throws MalformedURLException {

			DesiredCapabilities capabilities = new DesiredCapabilities ();
			
			capabilities.setCapability("automationName","UiAutomator1");
			capabilities.setCapability("deviceName","Pixel 3 XL API 24");
			capabilities.setCapability("platformVersion", "7");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.android.dialer");
			capabilities.setCapability("appActivity",".DialtactsActivity");
			
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
			
			//com.android.dialer:id/floating_action_button - this is the dialer button
			driver.findElements(By.id("com.android.dialer:id/floating_action_button")).get(0).click();
			
			//driver.findElements(By.id("com.android.dialer:id/zero")).get(0).click();
			WebElement ele = driver.findElement((By.id("com.android.dialer:id/zero")));
	
			AndroidTouchAction touch = new AndroidTouchAction (driver);
			touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).release().perform();
			
			String dialerText = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText")).getText();
			System.out.print("Value from Dialer textbox " + dialerText);
		

	}

}
