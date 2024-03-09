package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.AppConstants;
import com.qa.opencart.utilities.ConfigProperties;
import jline.internal.Log;

public class HomePageTest extends BaseTest{
	
	@Test(description = "This test will verify the home page title", priority = 1)
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
		Log.info("Home Page Title has been verified");
	}
	
	@Test(description = "This test will verify the home page URL", priority = 2)
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL, ConfigProperties.URL);
		Log.info("Home Page URL has been verified");
	}
	
	// Data provider with two dimensional Object array
	@DataProvider
	public Object[][] getproductData(){
		return new Object[][]{
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
	@Test(description = "This test will verify the search results", priority = 3, dataProvider = "getproductData")
	public void searchTest(String productName) {
		String actualHeader = homePage.doSearch(productName);
		Log.info("Verifying data for: " + productName);
		Assert.assertEquals(actualHeader, "Search - " + productName);
	}
}
