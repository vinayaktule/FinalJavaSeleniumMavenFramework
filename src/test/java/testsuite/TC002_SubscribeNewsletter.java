package testsuite;

import org.testng.annotations.Test;

import common.CommonFuntions;
import config.Browser;
import objectrepository.HomePage;

public class TC002_SubscribeNewsletter extends Browser {
	@Test
	public void testSubscribeToNewsletter() throws Exception {
		Browser.parentTest = Browser.parentTest.createNode("Subscribe Newsletter test");
		CommonFuntions commomFunction = new CommonFuntions();
		HomePage homePage = new HomePage();
		commomFunction.login();
		homePage.subscribeNewsletter("admin1@xyz.com");
		commomFunction.logout();
	}
}
