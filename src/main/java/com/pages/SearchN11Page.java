package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchN11Page extends BaseN11Page {

	@FindBy(id = "searchData")
	private WebElement searchData;

	@FindBy(className = "searchBtn")
	private WebElement searchBtn;

	@FindBy(xpath = "//*[@class='resultText ']/strong")
	private WebElement countResult;

	@FindBy(xpath = "//*[@class='pagination']/a[2]")
	private WebElement secondButton;

	@FindBy(xpath = "//li[3]/div/div[2]/span[2]")
	private WebElement thirdProductInList;

	@FindBy(xpath = "//li[3]/div/div/a/h3")
	private WebElement thirdProductName;

	@FindBy(xpath = "//li[3]/div/div[2]/span[2]")
	private WebElement favoriAddButton;

	public SearchN11Page(WebDriver driver) {
		super(driver);
	}

	public void enterDataForSearch(String data) {
		this.searchData.clear();
		this.searchData.sendKeys(data);
	}

	public void submitForSearch() {
		searchBtn.click();
	}

	public String getCountResult() {
		return countResult.getText();
	}

	public void clickSecondButton() {
		secondButton.click();
	}

	public void selectThirdProduct() {
		wait.until(elementClickableByXpad(thirdProductInList));
		setSelectedFavoriteProduct(thirdProductName.getText());
		favoriAddButton.click();
	}

	public void addFavoriteProduct() {
		favoriAddButton.click();
	}
}
