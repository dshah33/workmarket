package WorkMarket.Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class UtilityClass {

	public static WebDriver driver;

	@BeforeTest
	public void setupDriver() throws Exception {

		Reporter.log("======+w+++ Browser Session Started ++++======", true);
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DARSHAN/Documents/chromedriver/77_version/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Driver is initialized");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void closeApp() {

		driver.quit();
		Reporter.log("======++++ Brwoser Session Ended ++++======", true);
	}

}
