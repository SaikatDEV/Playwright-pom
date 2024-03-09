package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.AppConstants;
import jline.internal.Log;

public class LoginPageTest extends BaseTest{
	
	@Test(description = "This test will verify User is able to logged in Successfully", priority = 1)
	public void verifySuccesfullyLoggedIn() {
		loginPage = homePage.navigateToLoginPage();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
		boolean linkExist = loginPage.isForgotPasswordLinkExist();
		Assert.assertTrue(linkExist);
		Log.info("Pageword link is exists");
	}

}