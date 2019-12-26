package MobilePlaygroud;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class GestureTest extends Base{
	
	

	
	@Test(priority=1,enabled=false)
	public void tapTest() throws MalformedURLException, InterruptedException  {
		System.out.println("Thsi is a test");
		AndroidDriver<AndroidElement> driver = myCap();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		Thread.sleep(3000);
		driver.closeApp();
	}
	
	
	@Test(priority=0,enabled=false)
	public void swipeTest() {
		System.out.println("Test swipe");
	}

	/*
	 * 888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
	 * // GENERAL_STORE //
	 * 888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
	 */	
	/**
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@Test(priority=2,enabled=false)
	public void general_store_form_Test() throws MalformedURLException {
		System.out.println("Running general_store_form_Test...");
		AndroidDriver<AndroidElement> driver = myCap();
		TouchAction touchtap = new TouchAction (driver);
		WebElement country_list = driver.findElement(By.id("android:id/text1"));
		touchtap.tap(tapOptions().withElement(element(country_list))).perform();
		//use TAP here as well
		
		//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollintoView(text(\"Bangladesh\"));");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Bangladesh" + "\").instance(0))"));     
		WebElement country_name=driver.findElement(By.xpath("//*[@text='Bangladesh']"));
		touchtap.tap(tapOptions().withElement(element(country_name))).perform();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("ZAMAN");
		driver.hideKeyboard();
		WebElement radio_button=driver.findElementByXPath("//android.widget.RadioButton[@text='Female']");
		touchtap.tap(tapOptions().withElement(element(radio_button))).perform();

		WebElement submit_button=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		touchtap.tap(tapOptions().withElement(element(submit_button))).perform();
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.closeApp();
							
	}
	
	@Test(priority=3,enabled=false)
	public void general_toast_test() throws MalformedURLException {
		System.out.println("Running general toast test");
		AndroidDriver<AndroidElement> driver = myCap();
		TouchAction touchtap = new TouchAction(driver);
		WebElement submit_button=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		touchtap.tap(tapOptions().withElement(element(submit_button))).perform();
		String toast_message=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println("Toast message: "+toast_message);
		Assert.assertEquals("Please enter your name",toast_message);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.closeApp();
				
	}
	
	@Test(priority=4,enabled=true)
	public void general_dynamin_selection_test() throws MalformedURLException, InterruptedException {
		System.out.println("Runnding general_dynamin_selection_test");
		AndroidDriver<AndroidElement> driver = myCap();
		TouchAction touchtap = new TouchAction(driver);
		WebElement country_list = driver.findElement(By.id("android:id/text1"));
		touchtap.tap(tapOptions().withElement(element(country_list))).perform();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Bangladesh" + "\").instance(0))"));     
		
		WebElement country_name=driver.findElement(By.xpath("//*[@text='Bangladesh']"));
		touchtap.tap(tapOptions().withElement(element(country_name))).perform();
		
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("ZAMAN");
		driver.hideKeyboard();
		
		WebElement radio_button=driver.findElementByXPath("//android.widget.RadioButton[@text='Female']");
		touchtap.tap(tapOptions().withElement(element(radio_button))).perform();
		
		WebElement submit_button=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		touchtap.tap(tapOptions().withElement(element(submit_button))).perform();
		
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		 int count =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		 for(int i=0;i<count;i++)  {
		    String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

		       if(text.equalsIgnoreCase("Jordan 6 Rings")) {
 		    	   WebElement addtoCart=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i);
 		    	   touchtap.tap(tapOptions().withElement(element(addtoCart))).perform();
		    	   break;
		    }   }

		   	    WebElement cart_button=driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		   	    touchtap.tap(tapOptions().withElement(element(cart_button))).perform();
		   	    String lastpageText=    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
         		Assert.assertEquals("Jordan 6 Rings", lastpageText);
         	
         		Thread.sleep(3000);
         		 
	}
	

}
