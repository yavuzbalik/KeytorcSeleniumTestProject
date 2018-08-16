package com.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import com.pages.FavouriteN11Page;
import com.pages.HomeN11Page;
import com.pages.LoginN11Page;
import com.pages.SearchN11Page;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases extends Configs {

	@Test
	public void test_1_1_homePageControl() {
		HomeN11Page homePage = new HomeN11Page(driver);
		driver.get(homePage.getUrl());
		homePage.waitForPageLoad();
	}

	@Test
	public void test_1_2_loginPage() {
		HomeN11Page home = new HomeN11Page(driver);
		home.getLoginPage();
	}

	@Test
	public void test_1_3_signIn() {
		LoginN11Page loginPage = new LoginN11Page(driver);
		loginPage.enterLoginForm("yavuzbalik@gmail.com", "Nurben123");
		loginPage.submit();
		loginPage.waitForPageLoad();
		Assert.assertTrue(loginPage.getUserName().equals("Yavuz Balik"));

	}

	@Test
	public void test_1_4_dataSearch() throws InterruptedException {
		SearchN11Page searchPage = new SearchN11Page(driver);
		searchPage.enterDataForSearch("samsung");
		searchPage.submitForSearch();
		Thread.sleep(100);
		Assert.assertTrue(!searchPage.getCountResult().equals(""));

	}

	@Test
	public void test_1_5_searchSecondPage() throws InterruptedException {
		Thread.sleep(100);
		SearchN11Page searchPage = new SearchN11Page(driver);
		searchPage.clickSecondButton();
		searchPage.waitForPageLoad();
		Assert.assertTrue(driver.getTitle().contains("Samsung - n11.com - 2/"));

	}

	@Test
	public void test_1_6_selectThirdProductAndAddToFavorites() {
		SearchN11Page searchPage = new SearchN11Page(driver);
		searchPage.selectThirdProduct();
		searchPage.addFavoriteProduct();

	}

	@Test
	public void test_1_7_clickMyFavorites() {
		FavouriteN11Page favouritePage = new FavouriteN11Page(driver);
		favouritePage.clickPopupMyFavorite();

	}

	@Test
	public void test_1_8_openMyFavorites() {
		FavouriteN11Page favouritePage = new FavouriteN11Page(driver);
		favouritePage.myFavoriteListShow();

	}

	@Test
	public void test_1_9_findFavoriteProduct() {
		FavouriteN11Page favouritePage = new FavouriteN11Page(driver);
		for (WebElement productTitle : favouritePage.myFavoriteList()) {
			String watchesProduct = productTitle.getText();
			if (watchesProduct.equals(favouritePage.getSelectedFavoriteProduct())) {
				Assert.assertTrue(watchesProduct.equals(favouritePage.getSelectedFavoriteProduct()));
			}
		}
	}

	@Test
	public void test_2_1_webSiteDeleteProduct() throws InterruptedException {
		FavouriteN11Page favouritePage = new FavouriteN11Page(driver);
		favouritePage.clickLinkDeleteProduct();
		Thread.sleep(3000);
		Assert.assertTrue(favouritePage.getMessage().equals("Ürününüz listeden silindi."));
		favouritePage.closeContent(); 
	}

	@Test
	public void test_2_2_deleteConfirmationForProduct() {
		boolean controlValue = true;
		FavouriteN11Page favouritePage = new FavouriteN11Page(driver);
		for (WebElement productTitle : favouritePage.myFavoriteList()) {
			String watchesProduct = productTitle.getText();
			if (watchesProduct.equals(favouritePage.getSelectedFavoriteProduct()))
				controlValue = false;
		}
		Assert.assertFalse(controlValue);

	}

}
