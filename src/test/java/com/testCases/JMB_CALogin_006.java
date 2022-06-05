package com.testCases;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage;
import com.pageObjects.LoginPage;
import com.utilities.ReadConfig;

public class JMB_CALogin_006 extends BaseClass{
	
	@Test(priority=1)
	public void loginTest06() throws IOException{
		
		 ReadConfig  readconfig = new ReadConfig();//Creating object of ReadConfig
		// Integrating data from ReadConfig
		String invalidpass=readconfig.getInvalidPassword(); //getting invalid password from config.properties file
		String invalidemail=readconfig.getInvalidUsername(); //getting invalid email from config.properties file
		String expectedCredentialsText = "Invalid credentials.";
		
		logger.debug("Invalid email login test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		
		LoginPage loginpg = new LoginPage(driver);
		logger.debug("Login page opened");
		loginpg.settxtemail(invalidemail);		//enter invalid email
		loginpg.settxtpassword(invalidpass);	//enter valid password
		loginpg.clkbtnSubmit();             //Click on submit button\
		
	
		logger.debug("Username invalid email and valid password entered");
	
		/*	System.out.println(invalidpass);
		System.out.println(invalidemail);*/
		
		
		String actualCredentialsText = loginpg.displayInvalidCredentialsMessage();
		SoftAssert softassert = new SoftAssert(); 
		if(expectedCredentialsText.equals(actualCredentialsText)) //Checking for successful login page
		{
			softassert.assertTrue(true);
			logger.debug("Test Passed! Login Successful!");
			System.out.println(actualCredentialsText);
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			captureScreen(driver,"loginTest06");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_06 Logintest!");
		
	}

}
