package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.pageObjects.Homepage;
import com.pageObjects.LoginPage;
import com.utilities.Reporting;;

public class JMB_CALogin_008 extends BaseClass{

	@Test(priority=1)
	public void loginTest08() throws IOException, InterruptedException{
	
		logger.debug("Signup test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		LoginPage lp = new LoginPage(driver); //creating Object of LoginPage
		lp.clickOnForgotPasswordLink();
		logger.debug("Clicked forgot password");
	
		//Checking for if landed on Signup page
		SoftAssert softassert = new SoftAssert(); 
		if(driver.getTitle().equals("Forgot Password"))
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Landed on forgot password page!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! forgot password page not found");
			captureScreen(driver,"loginTest08");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_08 Forgotpassword Test!");
		
	}

}
