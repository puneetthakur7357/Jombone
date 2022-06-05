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

public class JMB_CALogin_001 extends BaseClass{

	@Test(priority=1)
	public void loginTest01() throws IOException{
	
		logger.debug("Login test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		
		LoginPage loginpg = new LoginPage(driver);
		logger.debug("Login page opened");
		loginpg.settxtemail(username1);		//Pass username1 declared in config file
		loginpg.settxtpassword(password);	//Pass password declared in config file
		loginpg.clkbtnSubmit();             //Click on submit button
		
		logger.debug("Username and password entered");
	
		
		SoftAssert softassert = new SoftAssert(); 
		if(driver.getTitle().equals("Dashboard"))
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Login Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			captureScreen(driver,"loginTest01");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_01 Logintest!");
		
	}

}
