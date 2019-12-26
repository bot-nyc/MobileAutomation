package AppDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import static io.appium.java_client.touch.offset.ElementOption.element;

//import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;

public class Gestures extends appDemoTest{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		TouchAction touchtap = new TouchAction(driver);
		WebElement expandlist=driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		touchtap.tap(tapOptions().withElement(element(expandlist))).perform();
		WebElement custom_adapter=driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
		touchtap.tap(tapOptions().withElement(element(custom_adapter))).perform();
		WebElement people_names=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		touchtap.longPress(longPressOptions().withElement(element(people_names)).withDuration(ofSeconds(2))).release().perform();
		WebElement sample_action=driver.findElementByXPath("//android.widget.TextView[@text='Sample action']");
		touchtap.tap(tapOptions().withElement(element(sample_action))).perform();
		

	}

}
