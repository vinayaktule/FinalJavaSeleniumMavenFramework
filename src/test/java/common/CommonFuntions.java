package common;

import org.openqa.selenium.WebDriver;

import commands.ActionDriver;
import config.Browser;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import util.ConfigSupport;

public class CommonFuntions {
	WebDriver driver;
	ActionDriver actionDriver;
	ConfigSupport configSupport = new ConfigSupport("config.properties");
	
	public CommonFuntions() {
		driver = Browser.driver;
		actionDriver = new ActionDriver();
	}
	
	public void login() throws Exception {
		Browser.childTest = Browser.parentTest.createNode("Login to Appliaction");
		actionDriver.navigateToApplication(configSupport.getProperty("base_url"));
		actionDriver.click(LoginPage.signInLink, "Sign In Link");
		actionDriver.type(LoginPage.txtUserNameId, configSupport.getProperty("username"), "username");
		actionDriver.type(LoginPage.txtPasswordId, configSupport.getProperty("password"), "password");
		actionDriver.click(LoginPage.signInBtn, "SignIn button");
	}
	
	public void logout() throws Exception {
		Browser.childTest = Browser.parentTest.createNode("Logout to Appliaction");
		actionDriver.click(HomePage.linkSignOut, "Sign out link");
	}

	
	

}
