package com.testCases;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage;
import com.pageObjects.LoginPage;
import com.utilities.ReadConfig;

public class JMB_CALogin_004 extends BaseClass{
	
	@Test(priority=1)
	public void loginTest04() throws IOException{
		
		 ReadConfig  readconfig = new ReadConfig();//Creating object of ReadConfig
		// Integrating data from ReadConfig
		String invalidpass=readconfig.getInvalidPassword(); //getting invalid password from config.properties file
		String expectedCredentialsText = "Invalid credentials.";
		
		logger.debug("Invalid password login test case started");  //Loggin the test
		Homepage jHome = new Homepage(driver); //creating Object of homepage
		jHome.clicklogin(); //click on login
		logger.debug("Clicked on login");
		
		LoginPage loginpg = new LoginPage(driver);
		logger.debug("Login page opened");
		loginpg.settxtemail(username1);		//enter valid email
		loginpg.settxtpassword(invalidpass);	//enter invalid password
		loginpg.clkbtnSubmit();             //Click on submit button\
		
	
		logger.debug("Username Valid email and Invalid password entered");
		
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
			captureScreen(driver,"loginTest04");
		}
		softassert.assertAll();
		logger.debug("Completed TestCase_04 Logintest!");
		
	}

}
