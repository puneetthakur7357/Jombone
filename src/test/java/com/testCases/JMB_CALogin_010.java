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

public class JMB_CALogin_010 extends BaseClass{

	@Test(priority=1)
	public void loginTest10() throws IOException, InterruptedException{
		 ReadConfig  readconfig = new ReadConfig();//Creating object of ReadConfig
		 String cUsername = readconfig.getCompanyUsername();
		 String cPassword = readconfig.getCompanyPassword();
		logger.debug("Company Login test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		
		LoginPage loginpg = new LoginPage(driver);
		logger.debug("Login page opened");
		loginpg.settxtemail(cUsername);		//Pass username1 declared in config file
		
		loginpg.settxtpassword(cPassword);	//Pass password declared in config file
		loginpg.clkbtnSubmit();             //Click on submit button
		
		logger.debug("Username and password entered");
	
		
		SoftAssert softassert = new SoftAssert(); 
		if(driver.getTitle().equals("Dashboard"))
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Candidate Login Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			captureScreen(driver,"loginTest10");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_Company_02 Logintest!");
		
	}

}
