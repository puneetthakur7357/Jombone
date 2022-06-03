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

public class Testcase_07 extends BaseClass{

	@Test(priority=1)
	public void candidateSignup() throws IOException, InterruptedException{
	
		logger.debug("Signup test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		LoginPage lp = new LoginPage(driver); //creating Object of LoginPage
		lp.clickOnSignUpLink(); //click on login
		logger.debug("Clicked on Signup");
		lp.clickOnCandidateSignUpLink();
		logger.debug("Clicked on Candidate Signup");
	
		//Checking for if landed on Signup page
		SoftAssert softassert = new SoftAssert(); 
		if(driver.getTitle().equals("Signup"))
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Landed on Signup page!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Signup page not found");
			captureScreen(driver,"Sign up page");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_07 Signup Test!");
		
	}

}
