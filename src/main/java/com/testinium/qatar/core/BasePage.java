package com.testinium.qatar.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage extends DriverFactory{
    AndroidDriver<MobileElement> appiumDriver;

    public void writeTextById(String by, String text) {
        getDriver().findElementById(by).sendKeys(text);
            logger.info(text + " text write");
    }
    public void writeTextByXpath(String xpath, String text){
        getDriver().findElementByXPath(xpath).sendKeys(text);
        logger.info(text + " text write");
    }

    public void clickId(String by) {
        getDriver().findElementById(by).click();
        logger.info(by + " element click");
    }
    public void clickAccessibilityId(String by){
        getDriver().findElementByAccessibilityId(by).click();
        logger.info(by + " element click");
    }
    public void clickByXpath(String xpath){
        getDriver().findElementByXPath(xpath).click();
        logger.info(xpath + " element click");
    }
    public void clear(String xpath){
        getDriver().findElementByXPath(xpath).clear();
        logger.info(xpath + " element clear");
    }
    public void swipeUntilFindText(String text) {
        int size = appiumDriver.findElements(By.xpath("//*[contains(@text,'"+text+"')]")).size();
        int timeOutCounter = 0;
        while(size==0 && timeOutCounter!=10)
        {
            scroll();
            size = appiumDriver.findElements(By.xpath("//*[contains(@text,'"+text+"')]")).size();
            timeOutCounter++;
        }
    }
    public void scroll() {
        TouchAction action = new TouchAction(appiumDriver);
        Dimension dimensions = appiumDriver.manage().window().getSize();
        int startPoint = (int) (dimensions.getHeight() * 0.8);
        int endPoint = (int) (dimensions.getHeight() * 0.2);
        action.longPress(PointOption.point(500,startPoint));
        action.moveTo(PointOption.point(500,endPoint));
        action.release();
        action.perform();
    }
    public void clickRandomByID(String id) {
        List<MobileElement> elements = appiumDriver.findElements(By.id(id));
        Random rand = new Random();
        int randomNumber = rand.nextInt(elements.size());
        elements.get(randomNumber).click();
    }
    public void clickRandomByXpath(String xpath) {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));
        Random rand = new Random();
        int randomNumber = rand.nextInt(elements.size());
        elements.get(randomNumber).click();
    }
    public void clickByXpathMethod(String xpath){
        appiumDriver.findElementByXPath(xpath).click();
    }
    public void navigateTo(){
        appiumDriver = DriverFactory.getDriver();
    }
    public void checkOnOrCountinue(String by , int times) throws InterruptedException {
        logger.info(times +" check on click in time");
        boolean isElementExist = doesElementExistById(by,times);
        System.out.println(isElementExist);
        if(!isElementExist)
        {
            clickId(by);
            logger.info(by + " clicked element");
        }
        else
        {
            logger.info(by + " element not found and countinue");
            Thread.sleep(2);

        }

    }
    public boolean doesElementExistById(String text, int time) {
        try {
            WebDriverWait elementExist = new WebDriverWait(appiumDriver, time);
            elementExist.until(ExpectedConditions.invisibilityOfElementLocated(By.id(text)));
            return true;
        } catch (Exception e) {
            logger.info(text + " id element not found");
            return false;
        }
    }
    public void checkOnElement(String by){
        Assertions.assertTrue(appiumDriver.findElementById(by).isDisplayed() , "not show notified message");
        logger.info(by + " show the element");
    }
    public void waitBySecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
            logger.info( seconds + " wait ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
