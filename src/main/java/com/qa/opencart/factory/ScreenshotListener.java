package com.qa.opencart.factory;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        PlaywrightFactory factory = new PlaywrightFactory();
        factory.captureScreenshotOnFailure(result);
    }
}
