package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginN11Page extends BaseN11Page {

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(className = "user")
	private WebElement userName;

	public LoginN11Page(WebDriver driver) {
		super(driver);
	}

	public void enterLoginForm(String email, String password) {
		this.email.clear();
		this.email.sendKeys(email);

		this.password.clear();
		this.password.sendKeys(password);
	}

	public void submit() {
		loginButton.click();
	}

	public String getUserName() {
		return userName.getText();
	}
}
