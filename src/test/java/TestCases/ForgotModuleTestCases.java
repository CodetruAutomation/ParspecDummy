package TestCases;
import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageClasses.ForgotModulePageObject;

public class ForgotModuleTestCases extends ForgotModulePageObject
{
	ForgotModulePageObject ForgotPageclass = new ForgotModulePageObject();
	@BeforeSuite
	public void ExtentReportSetup1() {
		ForgotPageclass.ExtentReportSetup();
	}

	@Test(priority = 0)
	public void Scenario_0() throws Exception {
		ForgotPageclass.Test_0();  
	}

	@Test(priority = 1)
	public void Scenario_1() throws Exception {
		ForgotPageclass.Test_1();
	}

	@Test(priority =2)
	public void Scenario_2() throws Exception {
		ForgotPageclass.Test_2();
	}

	@Test(priority =3 )
	public void Scenario_3() throws Exception {
		ForgotPageclass.Test_3();
	}

	@Test(priority =4 )
	public void Scenario_4() throws Exception {
		ForgotPageclass.Test_4();
	}

	@Test(priority = 5)
	public void Scenario_5() throws Exception {
		ForgotPageclass.Test_5();
	}

	@Test(priority =6 )
	public void Scenario_6() throws Exception {
		ForgotPageclass.Test_6();
	}

	@Test(priority = 7)
	public void Scenario_7() throws Exception {
		ForgotPageclass.Test_7();
	}

	@Test(priority = 8)
	public void Scenario_8() throws Exception {
		ForgotPageclass.Test_8();
	}

	@Test(priority =9 )
	public void Scenario_9() throws Exception {
		ForgotPageclass.Test_9();
	}

	@Test(priority =10 )
	public void Scenario_10() throws Exception {
		ForgotPageclass.Test_10();
	}

	@Test(priority = 11)
	public void Scenario_11() throws Exception {
		ForgotPageclass.Test_11();
	}
	@Test(priority = 12)
	public void Scenario_12() throws Exception {
		ForgotPageclass.Test_12();
	}
	

	@Test(priority = 13)
	public void Scenario_13() throws Exception {
		ForgotPageclass.Test_13();
	}

	@Test(priority =14 )
	public void Scenario_14() throws Exception {
		ForgotPageclass.Test_14();
	}

	@Test(priority = 15)
	public void Scenario_15() throws Exception
	{
		ForgotPageclass.Test_15();
	}

	@Test(priority = 16)
	public void Scenario_16() throws Exception {
		ForgotPageclass.Test_16();
	}

	@BeforeTest
	public void chrome_Setup() throws MalformedURLException {

		ForgotPageclass.BrowserLaunch();
	
	}
	@AfterTest
	public void closebrowser() throws Exception {
		ForgotPageclass.afterTest();
	}
	@AfterSuite
	 public void teardown1() throws Exception {

	        ForgotPageclass.teardown();
	    }
	
}
