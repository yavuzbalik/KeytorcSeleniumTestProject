package com.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configs {
	protected static WebDriver driver;

	@BeforeClass
	public static void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void after() throws InterruptedException {
		Thread.sleep(3000);
	}

	public WebDriver getDriver() {
		return driver;
	}
}
