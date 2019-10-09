package WorkMarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public WebDriverWait smallWait;
	private static final long DEFAULT_WAIT_IN_SECONDS = 20;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, DEFAULT_WAIT_IN_SECONDS);
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Join as an individual']")
	public WebElement buttonJoinAsAIndividual;

	@FindBy(xpath = "//input[@id='firstname']")
	public WebElement textBoxFirstName;

	@FindBy(xpath = "//input[@id='lastname']")
	public WebElement textBoxLastName;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement textBoxEmail;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement textBoxPassword;
	
	@FindBy(xpath = "//input[@type='checkbox']//parent::div")
	public WebElement textCheckBox;
	

	@FindBy(xpath = "//button[@data-component-identifier='wm-validating-form__submit']")
	public WebElement buttonRegister;
	
	@FindBy(xpath = "//h2[normalize-space()='Thank You from CoName_6225']")
	public WebElement headerThankYoufromCoName_6225;

	public void registrationPageValidation(String firstName, String lastName, String email, String password ,String check)  {
		try
		{
			
			    driver.get("https://dev.workmarket.com/register/campaign/10081C503B209A0C8E7F05FDCC1AA98D4C904DEEF5F73265CAE38C744E7EAD3E");
			    
				wait.until(ExpectedConditions.visibilityOf(buttonJoinAsAIndividual)).click();
				wait.until(ExpectedConditions.visibilityOf(textBoxFirstName)).clear();
				wait.until(ExpectedConditions.visibilityOf(textBoxFirstName)).sendKeys(firstName);
				wait.until(ExpectedConditions.visibilityOf(textBoxLastName)).clear();
				wait.until(ExpectedConditions.visibilityOf(textBoxLastName)).sendKeys(lastName);
				wait.until(ExpectedConditions.visibilityOf(textBoxEmail)).clear();
				wait.until(ExpectedConditions.visibilityOf(textBoxEmail)).sendKeys(email);
				wait.until(ExpectedConditions.visibilityOf(textBoxPassword)).clear();
				wait.until(ExpectedConditions.visibilityOf(textBoxPassword)).sendKeys(password);		
				if(check.equalsIgnoreCase("yes"))
				wait.until(ExpectedConditions.elementToBeClickable(textCheckBox)).click();
		
				if ((firstName.length() > 1) && (lastName.length() > 1) && (email.length() > 1) && (password.length() > 1) && (check.equalsIgnoreCase("yes"))) {
		
					buttonRegister.click();
					
					System.out.println("Registration successfull");
					
					wait.until(ExpectedConditions.visibilityOf(headerThankYoufromCoName_6225));
					String ThankYoufromCoName = headerThankYoufromCoName_6225.getText().toString().trim();	
					Assert.assertEquals(ThankYoufromCoName, "Thank You from CoName_6225");
		
				}
		
				else {
					
					
					boolean status = buttonRegister.isEnabled();
					System.out.println("Status of register button is "+status);
					
					Assert.assertEquals(status, false);
		
				}
				
		        
				
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage().toString());
		}
		
	}
}
