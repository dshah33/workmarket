package WorkMarket.TestCases;



import org.testng.annotations.Test;

import WorkMarket.Pages.LoginPage;

import WorkMarket.Pages.UtilityClass;

public class TestCasesLoginPage extends UtilityClass  {
	
	@Test
	public void LoginPage_Testcase(){
		
		
		
		
		LoginPage LP = new LoginPage(driver);
		LP.loginpageTestOccuranceValidation("qa+candidatetest@workmarket.com", "candidate123");
	    
	}
	
	

}
