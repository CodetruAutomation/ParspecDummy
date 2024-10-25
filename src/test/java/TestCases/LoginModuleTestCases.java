package TestCases;
import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageClasses.LoginModulePageObject;

public class LoginModuleTestCases extends LoginModulePageObject

{
	LoginModulePageObject Login=new LoginModulePageObject();
	@BeforeSuite
	public void ExtentReportSetup1() {
		Login.ExtentReportSetup();
	}
	@BeforeTest
	public void chromeopen() throws MalformedURLException 
	{
		//Login.BrowserLaunch();
		Login.chromeopen();
	}
	
	@Test(priority = 1)
	public void testcase_1() throws Exception {
		System.out.println("Scenario - 1 ");
		System.out.println("Expected results : Verify that user is able to naviagate on the Login Page"); 
		Login.scenario_1();	
	}
	@Test(priority = 2)
	public void testcase_2() throws Exception { 
		System.out.println("Scenario - 9");
		System.out.println("Expected results : Verify the error message('This field is required') will come after entering no inpput in the 'Email' field and no input in the 'Password' field ");
		System.out.println("Without Email and Without Password");
		Login.scenario_2(); 
	}

	@Test(priority = 3)
	public void testcase_3() throws Exception {
		System.out.println("Scenario - 8");
		System.out.println("Expected results : Verify the 'Login' button after entering no input in the ' Email' field and no input in the 'Password' filed ");
		Login.scenario_3();
	}

	@Test(priority = 4)
	public void testcase_4() throws Exception {	
		System.out.println("Scenario - 6");
		System.out.println("Expected results : Verify that 'Login' button after entering the valid input in 'Email' field and no input in the 'Password' field ");
		
		Login.scenario_4();
	}

	@Test(priority = 5)
	public void testcase_5() throws Exception {		
		System.out.println("Scenario - 7");
		System.out.println("Expected Results : Verify that 'Login button' after entering the valid input in the 'Password' filed and no input in the 'Email' field ");
		
		Login.scenario_5();
	}

	@Test(priority = 6)
	public void testcase_6() throws Exception {		
		System.out.println("Scenario - 3 ");
		System.out.println("Expected Results : Verify error (Incorrect Login credentials) will come after entering the invalid inputs in the 'Email' text field and valid input in the 'Password' field ");		
		
		Login.scenario_6();
	}

	@Test(priority = 7)
	public void testcase_7() throws Exception {	
		System.out.println("Scenario - 4 ");
		System.out.println("Expected Results : Verify error message('Incorrect Login Credentials') will come after entering the valid input in the Email text field and invalid input in the Password field");
		
		Login.scenario_7();
	}

	@Test(priority = 8)
	public void testcase_8() throws Exception {	
		System.out.println("Scenario - 5 ");
		System.out.println("Expexted Results : Verify  error message ('Invalid Login Credentials') will come after entering the invalid input in the Email text field and invalid input in the password text field ");
		
		Login.scenario_8();
	}
	@Test(priority = 9)
	public void testcase_9() throws Exception {	
		System.out.println("Scenario - 10 ");
		System.out.println("Expected Results : Verify the 'Terms of Service' link will be accessible also when no input is provided in theb Email field and Password field ");
		
		Login.scenario_9();
	}

	@AfterTest
	public void closebrowsers()
	{
		Login.closeallbrowsers();
		
	}
	@AfterSuite
	public void teardown_1() throws Exception {
		Login.teardown();
	}

	
}
