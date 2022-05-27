package com.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;


public class Homepage extends BasePage{


	// Constructor
	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//capture the login link on the homepage
	@FindBy(xpath="//a[@href='/login']")
	WebElement loginlink;
	
	
	//click on the login on homepage
	public void clicklogin(){
		loginlink.click();
		
	}

}
