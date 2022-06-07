package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class LoginPage {

	public WebDriver ldriver;

	// Constructor

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Capture email field
	@FindBy(id = "email")
	@CacheLookup
	WebElement txtemail;

	// Capture password field
	@FindBy(id = "password-field")
	@CacheLookup
	WebElement txtpassword;

	// Capture Submit button
	@FindBy(id = "sbBt")
	@CacheLookup
	WebElement btnSubmit;

	// Capture "invalid credentials text"
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div[2]")
	@CacheLookup
	WebElement invalidCredentialsText;

	// Capture "sign up" link in login page
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/nav/ul/li/a")
	@CacheLookup
	WebElement signUpLink;

	// Capture "candidate sign up" link in login page
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/nav/ul/li/div/div/a[1]")
	@CacheLookup
	WebElement candidateSignUpLink;

	// Capture "forgot password" link
	@FindBy(xpath = "//*[@id=\"candidateLogin\"]/div[3]/div[3]/div[1]/a")
	@CacheLookup
	WebElement forgotPasswordLink;

	//capture please enter  email
	@FindBy(xpath = ".//*[@id='candidateLogin']/div[3]/div[1]/div/span")
	WebElement emailError;

	//capture please enter  password
	@FindBy(xpath = ".//*[@id='candidateLogin']/div[3]/div[2]/div/div/span")
	WebElement passError;

	// ==================Action methods===========================//

	// Send text to the email field
	public void settxtemail(String email) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txtemail));
		txtemail.sendKeys(email);
	}

	// Send text to password field
	public void settxtpassword(String pwd) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txtpassword));
		txtpassword.sendKeys(pwd);
	}

	// Click on submit button
	public void clkbtnSubmit() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(btnSubmit));
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmit.click();
	}

	// display "invalid credentials" message
	public String displayInvalidCredentialsMessage() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(invalidCredentialsText));
		return invalidCredentialsText.getText();
	}


	// click on sign up link
	public void clickOnSignUpLink() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(signUpLink));
		signUpLink.click();
	}

	// click on candidate sign up link
	public void clickOnCandidateSignUpLink() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(candidateSignUpLink));
		candidateSignUpLink.click();
	}

	// click on forgot password link
	public void clickOnForgotPasswordLink() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));
		forgotPasswordLink.click();
	}

	// to display email text box in login page
	public Boolean isEmailTextBoxDisplayed() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txtemail));
		return txtemail.isDisplayed();
	}

	// to display password text box in login page
	public Boolean isPasswordTextBoxDisplayed() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txtpassword));
		return txtpassword.isDisplayed();
	}

	// to display submit button in login page
	public Boolean isSubmitButtonDisplayed() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(btnSubmit));
		return btnSubmit.isDisplayed();
	}

	//To return email error message
	public String getEmailErrorMessage(){
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(emailError));
		String message = 	emailError.getText();
		return message;

	}
	//To return password error message
	public String getPasswordErrorMessage(){
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(passError));
		String message = 	passError.getText();
		return message;

	}

}
