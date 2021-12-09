package config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ConfigSupport;

public class Browser {
	public static WebDriver driver;
	public static ExtentSparkReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;	
	ConfigSupport configSupport = new ConfigSupport("config.properties");
	@BeforeTest
	public void report() {
		htmlreporter = new ExtentSparkReporter("reports/report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
	}

	@BeforeMethod
	public void method(Method method) {
		parentTest = extent.createTest(method.getName());
	}

	@BeforeClass
	public void beforeClass() {
		
		if(configSupport.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(configSupport.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else
			System.out.println("Please provide valid broswer name");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	  
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
		extent.flush();
	}

}
