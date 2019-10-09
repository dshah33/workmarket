package WorkMarket.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='login-email']")
	public WebElement textBoxEmailAddress;

	@FindBy(xpath = "//input[@id='login-password']")
	public WebElement textBoxPasswordLoginPage;

	@FindBy(xpath = "//button[@id='login_page_button']")
	public WebElement buttonLoginPage;

	@FindBy(xpath = "(//div[text()='Find Talent'])[1]")
	public WebElement linkFindTalent;

	@FindBy(xpath = "//input[@id='input-text']")
	public WebElement textBoxSearch;

	@FindBy(xpath = "//input[@id='input-text']")
	public WebElement testOccurrence;

	public void loginpageTestOccuranceValidation(String userName, String passWord) {

		try {
			
			System.out.println("coming here ");
			driver.get("https://dev.workmarket.com/login");
			
			wait.until(ExpectedConditions.visibilityOf(textBoxEmailAddress)).sendKeys(userName);
			wait.until(ExpectedConditions.visibilityOf(textBoxPasswordLoginPage)).sendKeys(passWord);
			wait.until(ExpectedConditions.elementToBeClickable(buttonLoginPage)).click();
			wait.until(ExpectedConditions.elementToBeClickable(linkFindTalent)).click();
			wait.until(ExpectedConditions.visibilityOf(textBoxSearch)).sendKeys("test");
			textBoxSearch.sendKeys(Keys.RETURN);
			
			List<WebElement> tests = driver
					.findElements(By.xpath("//a[@class='profile-card--name open-user-profile-popup']"));
			for (int i = 0; i < tests.size(); i++) {

				String Testocurance = tests.get(i).getText();
				System.out.println(Testocurance);

				if (Testocurance.contains("test") || Testocurance.contains("Test")) {
					System.out.println("Test occurance is present");
				} else {
					System.out.println("Test occurance is not present");
				}

			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
		}

	}

}
