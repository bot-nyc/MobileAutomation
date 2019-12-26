package AppDemo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class mobileBasic extends appDemoTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='1. Preferences from XML']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementByXPath("//android.widget.CheckBox[@resource-id='android:id/checkbox']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='android:id/edit']").sendKeys("tmobile");
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.closeApp();
	}

}
