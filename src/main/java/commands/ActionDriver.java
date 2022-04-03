package commands;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import config.Browser;

public class ActionDriver {
	WebDriver driver;
	private static final Logger log = Logger.getLogger(ActionDriver.class);
	public ActionDriver() {
		// TODO Auto-generated constructor stub
		driver = Browser.driver;
		log.info("Browser is initiated");
	}
	
	public void navigateToApplication(String url) {
		try {
			driver.get(url);
			Browser.childTest.pass("Successfully opened application URL");
			log.info("Opened application url > "+url);
		} catch (Exception e) {
			Browser.childTest.fail("unable to open application URL");
			log.error("Failed to open url"+url);
		}
	
	}
	
	public void click(By locator, String eleName){
		try {
			driver.findElement(locator).click();
			Browser.childTest.pass("Successfully clicked on : "+eleName);
		}catch (Exception e) {
			Browser.childTest.fail("Unabled to click on : "+eleName, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotWithDebugInfo()).build());
			Browser.childTest.info(e);
			throw e;
		}
	}
	
	public void type(By locator, String text, String eleName) throws Exception {
		try {
		driver.findElement(locator).sendKeys(text);
		Browser.childTest.pass("Successfully typed in : "+eleName+" with data "+text);
		}catch (Exception e) {
			Browser.childTest.fail("Unabled to click on : "+eleName+" with data "+text+"\n",
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotWithDebugInfo()).build());
			Browser.childTest.info(e);
			throw e;
		}
		
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String ScreenshotWithDebugInfo() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
