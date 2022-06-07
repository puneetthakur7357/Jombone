package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.pageObjects.Homepage;
import com.pageObjects.LoginPage;
import com.utilities.ReadConfig;
import com.utilities.Reporting;;

public class JMB_CALogin_009 extends BaseClass{

	@Test(priority=1)
	public void loginTest09() throws IOException, InterruptedException{
		
		logger.debug("Company Login test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		
		LoginPage loginpg = new LoginPage(driver);
		
		// Creating variables to capture the return value of primary content. if they are visible to login page or not
		Boolean emaildisplay =loginpg.isEmailTextBoxDisplayed(); 
		Boolean passdisplay =loginpg.isPasswordTextBoxDisplayed();
		Boolean submitdisplay =loginpg.isSubmitButtonDisplayed();
		
		
		SoftAssert softassert = new SoftAssert(); 
		
		System.out.println(emaildisplay);
		System.out.println(passdisplay);
		System.out.println(submitdisplay);
		if(emaildisplay && passdisplay && submitdisplay == true)  //asserting if all fields are captured
			
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Candidate Login Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			captureScreen(driver,"loginTest09");
		}
		softassert.assertAll();
		logger.debug("Completed JMB_CALogin_009");
		
	}

}
