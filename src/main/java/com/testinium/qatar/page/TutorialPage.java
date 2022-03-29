package com.testinium.qatar.page;

import com.testinium.qatar.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class TutorialPage extends BasePage {
    private static AndroidDriver<MobileElement> appiumDriver;

    public void advanceTutorial() {
            appiumDriver.findElementById("com.m.qr:id/skip_button ").click();
    }
}
