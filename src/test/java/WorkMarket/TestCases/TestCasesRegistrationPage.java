package WorkMarket.TestCases;
import java.time.Instant;
import org.testng.annotations.Test;
import WorkMarket.Pages.*;
import WorkMarket.Pages.UtilityClass;


public class TestCasesRegistrationPage extends UtilityClass {
	
	@Test
	public void RegistrationPage_Testcase1(){
		
		long now=Instant.now().toEpochMilli();
		
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("Darshan"+now, "Shah"+now, "d.shah2811"+now+"@gmail.com", "Darshan123"+now ,"yes");
		
	}
	
	@Test
	public void RegistrationPage_Testcase_emptyFirstName(){
		
		long now=Instant.now().toEpochMilli();
		
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("", "Shah", "d.shah2811"+now+"@gmail.com", "Darshan123","yes");		
	}
	
	@Test
	public void RegistrationPage_Testcase_emptyLastName(){
		long now=Instant.now().toEpochMilli();
		
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("Darshan", "", "d.shah2811"+now+"@gmail.com", "Darshan123","yes");	
		
	}
	
	@Test
	public void RegistrationPage_Testcase_emptyEmailId(){
		
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("Darshan", "Shah", "", "Darshan123","yes");	
		
	}
	
	@Test
	public void RegistrationPage_Testcase_emptyPassword(){
		
		
		long now=Instant.now().toEpochMilli();
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("Darshan", "Shah", "d.shah2811"+now+"@gmail.com", "","yes");
				
	}
	
	@Test
	public void RegistrationPage_Testcase_onlyCheckedChexbox(){
		
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("", "", "", "","yes");
		
		
	}
	
	@Test
	public void RegistrationPage_Testcase_emptyFields_and_Checkbox(){
		
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("", "", "", "","No");
				
	}
	
	@Test
	public void RegistrationPage_Testcase_UncheckedCheckBox(){
		
		long now=Instant.now().toEpochMilli();
		
		RegistrationPage RP = new RegistrationPage(driver);
		RP.registrationPageValidation("Darshan"+now, "Shah"+now, "d.shah2811"+now+"@gmail.com", "Darshan123"+now ,"No");
				
	}
	
	
	
	
   
}
