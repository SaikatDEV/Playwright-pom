package com.qa.opencart.factory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import org.testng.ITestResult;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.opencart.utilities.ConfigProperties;

import jline.internal.Log;

public class PlaywrightFactory{
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	
//	Properties prop;

	public static Playwright getPlaywright(){
		return tlPlaywright.get();
	}
	
	public static Browser getBrowser(){
		return tlBrowser.get();
	}
	
	public static BrowserContext getBrowserContext(){
		return tlBrowserContext.get();
	}
	
	public static Page getPage(){
		return tlPage.get();
	}
	
	public Page initBrowser(String browserName) {
		
		Log.info("Browser name is: " + browserName);	
	
		playwright = Playwright.create();
		tlPlaywright.set(playwright);
		
		switch (browserName) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(browser);
			
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(browser);
			
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(browser);

			break;
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			tlBrowser.set(browser);

			break;
			
		default:
			Log.info("Please enter the correct Browser type!");
			break;
		}
		
		browserContext = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
		tlBrowserContext.set(browserContext);
		
		page = browserContext.newPage();
		tlPage.set(page);
		
		getPage().navigate(ConfigProperties.URL);
		
		return getPage();
	}
	
	/* 
	// This method will initiaze the properties from config file
	public Properties init_prop(){
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return prop;
	}
	*/
	
	// Method to capture screenshot on test failure
    public void captureScreenshotOnFailure(ITestResult result) {
        try {
            // Capture screenshot
            byte[] screenshot = page.screenshot();

            // Save screenshot to a file
            File screenshotFile = new File("screenshots/" + result.getName() + ".png");
            Files.copy(new ByteArrayInputStream(screenshot), screenshotFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Log the screenshot file path
            Log.info("Screenshot captured: " + screenshotFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		
}
