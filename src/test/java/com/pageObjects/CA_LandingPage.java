package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.base.BasePage;

public class CA_LandingPage extends BaseClass {
	public WebDriver ldriver;
	SoftAssert softassert = new SoftAssert();
	public CA_LandingPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Looking for Job WebElement
	@FindBy(xpath="//*[@id=\"collapsibleNavbar\"]/ul[2]/li[3]/a")
	@CacheLookup
	WebElement look_for_job;
	
	public void click_LookForJob()
	{
		look_for_job.click();
	}
	
	//Looking for SignUp WebElement
	@FindBy(xpath="/html/body/div/main/section[1]/div/div/div/div/div/a[2]")
	@CacheLookup
	WebElement signup;
	
	//Performing click operations for SignUp WebElement
	public void clickSignup() {
		signup.click();
		
	}
	
}
