package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Helper {
	static Actions a;

	public static Properties readPropertyFile(String path) {
		FileInputStream f = null;
		Properties prop = null;
		try {
			f = new FileInputStream(new File(path));
			prop = new Properties();
			prop.load(f);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}

	public static void screenShot(WebDriver driver) throws IOException {
		int num = (int) Math.random();
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("/Users/bittech/eclipse-workspace/TestNGProject190613E/result/shot" + num + ".png"));

	}

	public static void performRightClick(WebDriver driver, WebElement target) {
		a = new Actions(driver);
		a.contextClick(target).build().perform();

	}

	public static void multipleWindowHandle(WebDriver driver, WebElement target) {
		a = new Actions(driver);
		String pWind = driver.getWindowHandle();
		a.contextClick(target).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build()
				.perform();
		Set<String> cwind = driver.getWindowHandles();
		for (String wind : cwind) {
			if (!wind.equals(pWind)) {
				driver.switchTo().window(wind);
			}
			// driver.switchTo().defaultContent(); to go back to Parent window
		}

	}

	public static void hoverOver(WebDriver driver, WebElement target) {
		a = new Actions(driver);
		a.moveToElement(target).build().perform();

	}

	public static void alertHandle(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.accept(); // to click OK button
		a.dismiss(); // to click cancel button
		a.sendKeys("hei"); // to type on a prompt text box
		a.getText(); // to get the text from alert box

	}

	public static void iframeHandling(WebDriver driver, String framename) {
		driver.switchTo().frame(0);
		driver.switchTo().frame("frameName");
		driver.switchTo().frame(driver.findElement(By.className("")));
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();// To go back to my Website
		// if we have more than one dynamic frame
		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
		for (WebElement frame : allFrames) {
			if (frame.getAttribute("name").equals(framename)) {
				driver.switchTo().frame(framename);
			}

		}

	}
	
	
	
	
	
	
	
	

}
