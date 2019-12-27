package MobilePlaygroud;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> myCap() throws MalformedURLException {
				  
			
			//Invoking .apk 
					File file = new File("src");
					//File file_source=new File(file,"ApiDemos-debug.apk");
					  File file_source = new File(file,"General-Store.apk");
					
			//Declare DesireCapabilities 
					 
					DesiredCapabilities mycap = new DesiredCapabilities();
					//mycap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
					mycap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2oreo");
					//mycap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomatior2");
					mycap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
					mycap.setCapability(MobileCapabilityType.APP, file_source.getAbsolutePath());
					
			//initialize driver 
				
						AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),mycap);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						return driver;

					
					
				}

		

	}

	


