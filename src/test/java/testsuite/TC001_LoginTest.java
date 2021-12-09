package testsuite;

import org.testng.annotations.Test;

import common.CommonFuntions;
import config.Browser;

public class TC001_LoginTest extends Browser{
	
	@Test
	public void testLogin_Logout() throws Exception {
		Browser.parentTest = Browser.parentTest.createNode("End to end Login test");
		CommonFuntions commomFunction = new CommonFuntions();
		commomFunction.login();
		commomFunction.logout();
	}

}
