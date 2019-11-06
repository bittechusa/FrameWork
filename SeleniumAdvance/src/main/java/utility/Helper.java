package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import com.google.common.base.Function;
import com.google.common.io.Files;

import 	org.openqa.selenium.WebDriver.Options;

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
	public static void scrollDownAndUp(WebElement element) {
		Coordinates c=((Locatable)element).getCoordinates();
		c.inViewPort();
		
		
		
	}
	public static void playWithJavaScript(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//to scroll up or down
		js.executeScript("window.scrollBy(0,2000)" );
		//to click
		js.executeScript("document.getElementById('email').value='user1'");
		
		// using salenium code
		
		js.executeScript("arguments[0].click()", element);
		
		
		
	}
	public static Cookie[] playwithCokies(WebDriver driver) {
		Set <Cookie> allCookie =driver.manage().getCookies();
		Cookie c[]=new Cookie[allCookie.size()];
		int i=0;

		for(Cookie cookie:allCookie) {
			
			c[i]=cookie;
			i++;
			
			
			
		}
		return c;
		
		
	}
	public static void deleteCookie(WebDriver driver,String cookiename) {
		Set <Cookie> allCookie =driver.manage().getCookies();
		
		

		for(Cookie cookie:allCookie) {
			if(cookie.getName().equals(cookiename)) {
				driver.manage().deleteCookieNamed(cookiename);
				
			}
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	public static void keyBoardHandling(WebDriver driver) {
		Keyboard k=((HasInputDevices)driver).getKeyboard();
		k.sendKeys(Keys.chord(Keys.COMMAND,Keys.SHIFT),"n");
		
		
		
		
	}
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions a= new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		a.dragAndDropBy(source, 20, 200).build().perform();
		
		
		
		
	}
	public static void dropDownMenu(WebElement element) {
		Select s= new Select(element);
		List<WebElement> allValue=s.getOptions();
		allValue.size();
		s.getFirstSelectedOption();
		for(int i=0;i<=allValue.size();i++) {
			s.selectByIndex(i);
		}
		
		
		
	}
	public static void someCommonMethods() {
		WebDriver driver=null;
		driver.getPageSource().contains("Jasim");
		
		
		
		
		
		TargetLocator t=driver.switchTo();
		
		
		
		t.frame(1);
		t.window("");
		
		Alert a= t.alert();
		
		
		Navigation n= driver.navigate();
		n.back();
		n.forward();
		n.refresh();
		n.to("");
	
		
		
		
	Options o= driver.manage();
	//o.addCookie(cookie);
	o.timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	o.window().maximize();
	o.window().getSize();
	//o.window().setSize(targetSize);
	
		
		
		
		
	}
	
	public static WebElement explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait ww= new WebDriverWait(driver, 10);
		ww.until(ExpectedConditions.elementToBeClickable(element));
		//or
		ExpectedConditions.elementToBeClickable(element);
		return element;
		
		
		
		
		
		
		
		
	}
	public static void fluentWait(WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

			WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
			{
			  public WebElement apply(WebDriver driver) {
			  return driver.findElement(By.id("foo"));
			}
			});
	}
	

}
