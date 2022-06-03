package com.testCases;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage;
import com.pageObjects.LoginPage;

public class Testcase_03 extends BaseClass{
	
	@Test(priority=1)
	public void loginTest03() throws IOException{
		String exppasserrmess = "Please enter password"; // Expected error message for blank username
		
		
		logger.debug("Blank password login test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		
		LoginPage loginpg = new LoginPage(driver);
		logger.debug("Login page opened");
		loginpg.settxtemail(username1);		//sent username
		//loginpg.settxtpassword("password");	//passed blank password
		loginpg.clkbtnSubmit();             //Click on submit button\
		
	
		logger.debug("Username valid email and blank password entered");
		SoftAssert softassert = new SoftAssert(); 
		if(loginpg.getPasswordErrorMessage().equals(exppasserrmess)) //Checking if the actual password error message is equals to expected error message
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Login Successful!");
			System.out.println(loginpg.getPasswordErrorMessage());
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			captureScreen(driver,"Logintest");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_03 Logintest!");
		
	}

}
