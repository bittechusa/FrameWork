package com.bit.ui.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SmokeTest{
	WebDriver driver;
	
	@Test
	public void test5() {
		DOMConfigurator.configure("log4j.xml");
		Logger log=Logger.getLogger(SmokeTest.class);
		log.fatal("fatal");
		log.error("error");
		log.warn("warn");
		log.info("info");
		log.debug("debug");
		log.trace("trace");
	}
	
	@Test
	public void test1() throws MalformedURLException {
		new  DesiredCapabilities();
		//log.info("test1 started");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		System.out.println(2);
		cap.setPlatform(Platform.MAC);
		cap.setBrowserName("chrome");
		//cap.setVersion("");
		ChromeOptions c=new ChromeOptions();
		c.merge(cap);
		System.out.println(3);
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), c);
		driver.get("http://www.facebook.com");
	}
	@Test
	public void test2() throws MalformedURLException {
		new  DesiredCapabilities();
		//log.info("test1 started");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		System.out.println(2);
		cap.setPlatform(Platform.MAC);
		cap.setBrowserName("chrome");
		//cap.setVersion("");
		ChromeOptions c=new ChromeOptions();
		c.merge(cap);
		System.out.println(3);
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), c);
		driver.get("http://www.google.com");
	}
	
	@Test
	public void test3() throws MalformedURLException {
		new  DesiredCapabilities();
		//log.info("test1 started");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		System.out.println(2);
		cap.setPlatform(Platform.WIN10);
		cap.setBrowserName("chrome");
		//cap.setVersion("");
		ChromeOptions c=new ChromeOptions();
		c.merge(cap);
		System.out.println(3);
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), c);
		driver.get("http://www.yahoo.com");
	}
	

}
