package com.zoopla.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Common {

	public static WebDriver d;
    public static String url="https://www.zoopla.co.uk";
    public static String  browser="FF";
 
    @BeforeTest
	public static void setUp() {
		// Launch browser
		if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\selenium driver\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			d = new FirefoxDriver();
		}

		else if (browser.equals("GC")) {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium driver\\chromedriver_win32\\chromedriver.exe");
			d = new ChromeDriver();
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\selenium driver\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			d = new InternetExplorerDriver();
		}

		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		d.manage().deleteAllCookies();

		

	}
    @AfterTest
	public static void tearDown() {
		d.quit();

	}
}
