package com.testCases;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage;
import com.pageObjects.LoginPage;

public class Testcase_02 extends BaseClass{
	
	@Test(priority=1)
	public void loginTest02() throws IOException{
		String expemailerrmess = "Please enter valid email."; // Expected error message for blank username
		
		
		logger.debug("Blank email login test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		
		LoginPage loginpg = new LoginPage(driver);
		logger.debug("Login page opened");
		//loginpg.settxtemail("puneet.thakur@hotmail.com");		//Pass blank username
		loginpg.settxtpassword(password);	//Pass password declared in config file
		loginpg.clkbtnSubmit();             //Click on submit button\
		
	
		logger.debug("Username blank and valid password entered");
		SoftAssert softassert = new SoftAssert(); 
		if(loginpg.getEmailErrorMessage().equals(expemailerrmess)) //Checking if the actual email error message is equals to expected error message
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Login Successful!");
			System.out.print(loginpg.getEmailErrorMessage());
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			captureScreen(driver,"Logintest");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_02 Logintest!");
		
	}

}
