package com.testinium.qatar.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static AndroidDriver<MobileElement> appiumDriver;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static AndroidDriver<MobileElement> getDriver() {
        if(appiumDriver == null) {
            try {
                createDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return appiumDriver;
    }

    private static AndroidDriver<MobileElement> createDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "HBE4C18605003717");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.m.qr");
        desiredCapabilities.setCapability("appActivity", "com.m.qr.home.onboarding.ui.OnBoardingActivity");

        appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return appiumDriver;
    }

    public static void killDriver() {
      //  if(appiumDriver != null) {
        //    appiumDriver.quit();
          //  appiumDriver = null;
       // }
    }

}

