package MobilePlaygroud;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;


import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	@Test(priority=4,enabled=false)
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
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		 int count =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		 for(int i=1;i<count;i++)  {
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
	
	@Test(priority=5,enabled=false)
	public void general_validate_product_test() throws MalformedURLException, InterruptedException {
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
		
		WebElement get_cart=driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0);
		touchtap.tap(tapOptions().withElement(element(get_cart))).perform();		
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		 int count =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		 for(int i=1;i<count;i++)  {
		    String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

		       if(text.equalsIgnoreCase("Jordan 6 Rings")) {
 		    	   WebElement addtoCart=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i);
 		    	   touchtap.tap(tapOptions().withElement(element(addtoCart))).perform();
		    	   break;
		    }   }
		 
		   	    WebElement cart_button=driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		   	    touchtap.tap(tapOptions().withElement(element(cart_button))).perform();
		  Thread.sleep(3000); 	   
		  String amount1= driver.findElements(By.xpath("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		  		 amount1=amount1.substring(1);  //removing $ sign
		  double amount1value=Double.parseDouble(amount1); //converting string to double	
		  System.out.println("amount1 ="+amount1value);		
		  
		  String amount2=driver.findElements(By.xpath("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		  		 amount2=amount2.substring(1); 	//removing $ sing
		  double amount2value=Double.parseDouble(amount2); //converting string to double
		  		 System.out.println("amount2 ="+amount2value);	
		  double sumOfproducts=amount1value+amount2value; 
		  System.out.println("Sum of products= "+sumOfproducts);
		  
		  String total=driver.findElement(By.xpath("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		  		 total=total.substring(1);
		  double total_amount=Double.parseDouble(total); 
		  		 System.out.println("total amount "+total_amount);
         	
         Assert.assertEquals(total_amount, sumOfproducts);		
         		 
	}
	
	@Test(priority=6,enabled=true)
	public void newtest() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=myCap();

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

	     driver.hideKeyboard();

	     driver.findElement(By.xpath("//*[@text='Female']")).click();

	     driver.findElement(By.id("android:id/text1")).click();

	     

	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

	     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	     

	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	Thread.sleep(4000);

	int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

	double sum=0;

	for(int i=0;i<count;i++)

	{

	String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();

	double amount=getAmount(amount1);

	sum=sum+amount;//280.97+116.97

	}

	System.out.println(sum+"sum of products");



	String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();



	total= total.substring(1);

	double totalValue=Double.parseDouble(total);

	System.out.println(totalValue+"Total value of products");

	Assert.assertEquals(sum, totalValue); 



	//Mobile Gestures

	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

	TouchAction t=new TouchAction(driver);

	t.tap(tapOptions().withElement(element(checkbox))).perform();



	WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));

	t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

	driver.findElement(By.id("android:id/button1")).click();

	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	Thread.sleep(7000);
	Set<String>context=driver.getContextHandles();
	for(String contextname:context) 
	{
		System.out.println(contextname);
		
	}
	driver.context("WEBVIEW_com.androidsample.generalstore");
	driver.findElement(By.name("q")).sendKeys("Appium tutorial");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));


	}

	public static double getAmount(String value)

	{

	value= value.substring(1);

	double amount2value=Double.parseDouble(value);

	return amount2value;
	}
	

}
