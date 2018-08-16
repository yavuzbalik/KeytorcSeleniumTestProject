package com.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavouriteN11Page extends BaseN11Page {

	@FindBy(xpath = "//*[@class='myAccountMenu hOpenMenu']/div[1]/a[2]")
	private WebElement favoriPopupButton;

	@FindBy(xpath = "//*[@class='wishGroupListItem favorites']/div[1]/a[1]")
	private WebElement linkToList;

	@FindBy(xpath = "//* [@id='view']/ul/li/div/div/a/h3")
	private List<WebElement> productTitles;

	@FindBy(xpath = "//*[@id='view']/ul/li/div/div[3]/span")
	private WebElement linkDeleteProduct;

	@FindBy(className = "message")
	private WebElement message;

	@FindBy(className = "closeBtn")
	private WebElement closeBtn;

	public FavouriteN11Page(WebDriver driver) {
		super(driver);
	}

	public void clickPopupMyFavorite() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", favoriPopupButton);
		waitForPageLoad();
	}

	public void myFavoriteListShow() {
		linkToList.click();
		waitForPageLoad();
	}

	public List<WebElement> myFavoriteList() {
		return productTitles;
	}

	public void clickLinkDeleteProduct() {
		linkDeleteProduct.click();
	}

	public String getMessage() {
		return message.getText();
	}

	public void closeContent() {
		closeBtn.click();
		waitForPageLoad();
	}
}
