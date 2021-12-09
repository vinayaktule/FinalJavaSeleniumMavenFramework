package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commands.ActionDriver;
import config.Browser;

public class HomePage {
	
	WebDriver driver;
	ActionDriver actionDriver;
	
	public HomePage() {
		driver = Browser.driver;
		actionDriver = new ActionDriver();
	}
	
	public static By linkSignOut = By.linkText("Sign out");
	public static By newletterField = By.id("newsletter-input");
	public static By submitNewsletterBtn = By.name("submitNewsletter");
	
	
	public void subscribeNewsletter(String email) throws Exception {
		actionDriver.type(newletterField, email, "newletterField");
		actionDriver.click(submitNewsletterBtn, "submitNewsletterBtn");
	}
}
