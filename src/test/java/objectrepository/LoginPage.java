package objectrepository;

import org.openqa.selenium.By;

public class LoginPage {
	public static By signInLink = By.linkText("Sign in");
	public static By txtUserNameId = By.id("email");
	public static By txtPasswordId = By.id("passwd");
	public static By signInBtn = By.id("SubmitLogin");
}
