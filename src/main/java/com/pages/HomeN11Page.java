package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeN11Page extends BaseN11Page {

	private static String Url = "https://www.n11.com/";

	@FindBy(className = "btnSignIn")
	private WebElement btnSignIn;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	public HomeN11Page(WebDriver driver) {
		super(driver);
	}

	public void getLoginPage() {
		btnSignIn.click();
		wait.until(elementClickableById(loginButton));
	}

	public String getUrl() {
		return Url;
	}

}
