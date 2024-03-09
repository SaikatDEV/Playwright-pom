package com.qa.opencart.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.utilities.ConfigProperties;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	
	protected HomePage homePage;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();

		page = pf.initBrowser(ConfigProperties.BROWSER);
		homePage = new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
