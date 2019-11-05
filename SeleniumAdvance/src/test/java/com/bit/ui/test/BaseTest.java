package com.bit.ui.test;

import org.testng.annotations.Test;

import utility.Helper;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	Properties prop;
	Logger log;

	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
		log = Logger.getLogger(BaseTest.class);
		log.info("log file initialized");

		
		log.info("logger instance initialized");

	}

	@BeforeTest
	public void beforeTest() {
		prop = Helper.readPropertyFile("/Users/bittech/eclipse-workspace/SeleniumAdvance/config.properties");
		log.info("property file initialized");
	}
	
	

	@BeforeMethod
	public void beforeMethod() {
		if (prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			log.info("chromeDriver initialized");

		} else if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			log.info("FireFoxDriver initialized");

		}
		driver.get(prop.getProperty("url"));
		log.info("Navigate to url");

	}

	@AfterMethod
	public void afterMethod(ITestResult r) throws IOException {
		switch (r.getStatus()) {
		case ITestResult.FAILURE: {
			System.out.println("took screen shotttt");
			Helper.screenShot(driver);
		}
		case ITestResult.SUCCESS: {
			System.out.println(r.getName() + " is passed");
		}
		}

	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
