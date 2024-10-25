package PageClasses;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.awt.Desktop;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Excel_Utility.Excel_Utility_ForgotModule;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotModulePageObject extends Excel_Utility_ForgotModule
{
	RemoteWebDriver driver;
	WebDriverWait wait;
	String     mainwindow;
	public   WebElement email ;
	WebElement yopmail;
	WebElement forgot_password_Btn;
	WebElement error_messege;
	String     emailpage;
	WebElement emailvalidation;
	WebElement resetpassword_link;
	String     emailwindow;
	WebElement new_password ;
	WebElement confirmpassword;
	WebElement forgot_password_Btn1;
	WebElement popup_messege;
	WebElement password_inst;
	WebElement passwordRequirement;
	String     passwordRequirementText;
	WebElement password_not_matched;
	WebElement subheading;
	WebElement element;
	WebElement passwordRequirement_1;
	String     passwordRequirementText_1;
	String     reset_passwordpage;
	String     Forgotpage;
	WebElement save_btn;
	WebElement pass_change_sucess;
	WebElement signinpage;
	WebElement createsubmit_btn;
	WebElement dashboardpage = null;

	File file;

	ExtentReports ext = new ExtentReports();

	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	ExtentSparkReporter SparkReporter;

	SoftAssert softassert=new SoftAssert();
	Excel_Utility_ForgotModule exe= new Excel_Utility_ForgotModule();

	// Excel_Utility_ForgotModule exce = new Excel_Utility_ForgotModule();


	//    public void BrowserLaunch() throws MalformedURLException {
	//        spark.config().setTheme(Theme.DARK);
	//        spark.config().setDocumentTitle("MyReport");
	//        ext.attachReporter(spark);
	//       // WebDriverManager.chromedriver().setup();
	//        String current = System.getProperty("user.dir");
	//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
	//        ChromeOptions cop = new ChromeOptions();
	//        cop.addArguments("--allow-running-insecure-content");
	//        cop.addArguments("--remote-allow-origins=*");
	//        driver = new ChromeDriver(cop);
	//        DesiredCapabilities dc=new DesiredCapabilities();
	//        dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	//        
	//      //  dc.setBrowserName(BrowserType.);
	//
	//     //   dc.setBrowserName(BrowserType.);
	//        driver = new RemoteWebDriver(new URL("http://codetru.org:4444/wd/hub"),dc);
	//        
	//       
	//        driver.get("https://codetrue-poc--stage-parspec-app.netlify.app/login");
	//        driver.manage().window().maximize();
	//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//    }
	public void BrowserLaunch() throws MalformedURLException {
		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setDocumentTitle("MyReport");
		ext.attachReporter(SparkReporter);
		ChromeOptions cop = new ChromeOptions();
		cop.addArguments("--headless");
		cop.addArguments("--no-sandbox"); // Bypass OS security model
       	cop.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
       	cop.addArguments("--window-size=1920x1080"); // Set the win
		cop.addArguments("--allow-running-insecure-content");

		driver = new ChromeDriver(cop);
		DesiredCapabilities dc=new DesiredCapabilities();
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/usr/bin/google-chrome");
		dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		driver = new RemoteWebDriver(new URL("http://codetru.org:4444/wd/hub"),dc);

		driver.get("https://codetrue-poc--stage-parspec-app.netlify.app/login");
		// WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));



	}

	public void ExtentReportSetup() 
	{
		ext=new ExtentReports();
		file = new File("reportForgotModule.html");
		SparkReporter=new ExtentSparkReporter(file);
		ext.attachReporter(SparkReporter);
	}

	public void Test_0() throws Exception {
		forgot_excel();
		//Verify user redirects to the forgot password pop up after clicking the forgot password link 
		System.out.println("Scenario_01");
		System.out.println("Expected Result-Verify user redirects to the forgot password pop up after clicking the forgot password link");
		ExtentTest test0=ext.createTest("1. Verify user redirects to the forgot password pop up after clicking the forgot password link");
		try {
			mainwindow = driver.getWindowHandle();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Forgot Password?']"))).click();
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='subheading']")));
			element.getText();
			System.out.println("Reset Password page"+element.getText());
			Forgotpage = driver.getPageSource();

			if (Forgotpage.contains(element.getText())) {
				System.out.println("User should redirect to the forgot password page after clicking the forgot password link ");

				test0.pass("User should redirect to the forgot password page after clicking the forgot password link ");
			}
		} catch (Exception e) { 
			System.out.println("User unable to redirect the forgot password page");

			test0.fail("User unable to redirect the forgot password page");
			test0.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_1() throws Exception{
		forgot_excel();
		// Verify that reset password button get active after entering the valid email in the email text field
		System.out.println("***************************************************************************");
		System.out.println("Scenario_02");
		System.out.println("Expected Result- Verify that reset password button get active after entering the valid email in the email text field");
		ExtentTest test1=ext.createTest("Verify that reset password button get active after entering the valid email in the email text field");

		try {
			email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='email']")));
			email.sendKeys(invalidemail1);
			Thread.sleep(3000);
			forgot_password_Btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Reset Password']")));



			if (forgot_password_Btn.isEnabled()) {

				System.out.println("Reset password button is enabled after giving valid data in email text field");
				test1.fail("Reset password button is enabled after giving invalid data in email text field");
				test1.addScreenCaptureFromPath(capturescreenshot(driver));
			}
		} catch (Exception e)  {
			System.err.println("Reset password button is disabled after giving invalid data in email text field");
			test1.pass("Reset password button is disabled after giving invalid data in email text field");
		}
	}

	public void Test_2() throws Exception {
		forgot_excel();
		// verifying reset password button after entering numeric input in email field
		System.out.println("***************************************************************************");
		System.out.println("Scenario_05");
		System.out.println("Expected Result-verifying reset password button after entering numeric input in email field");
		try {
			email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='email']")));
			email.clear();
			email.sendKeys(numericdata);
			if (forgot_password_Btn.isEnabled()) {
				System.out.println("Reset Password' button is be enabled when user entered the numeric input");
				ExtentTest test2=ext.createTest("verifying reset password button after entering numeric input in email field");
				test2.pass("Reset Password' button should be enabled when user entered the numeric input");
			} 
		} catch (Exception e) {
			ExtentTest test2=ext.createTest("verifying reset password button after entering numeric input in email field");
			test2.pass("Reset Password' button should not be enabled when user entered the numeric input");
			test2.addScreenCaptureFromPath(capturescreenshot(driver));
			System.err.println("Reset Password' button should not be enabled when user entered the numeric input");
		}
	}

	public void Test_3()throws Exception {
		forgot_excel();
		//Verify the error message appearing after entering the invalid email ID in the 'Forgot Password' page
		System.out.println("***************************************************************************");
		System.out.println("Scenario_04");
		System.out.println("Expected Result-Verify the error message appearing after entering the invalid email ID in the 'Forgot Password' page ");
		try {
			email.clear();
			email.sendKeys(invalidemail2);
			Thread.sleep(3000);
			forgot_password_Btn.click();
			Thread.sleep(3000);
			error_messege = driver.findElement(By.xpath("//span[.='Email not registered']"));
			error_messege.getText();
			driver.getPageSource();

			if (driver.getPageSource().contains(error_messege.getText())) {
				System.err.println("Error message ('Email not registered') should come after entering the invalid Email ID in the 'Forgot Password' Page ");
				ExtentTest test3=ext.createTest("Verify the error message appearing after entering the invalid email ID in the 'Forgot Password' page ");
				test3.pass("This test is passeError message ('Email not registered') should come after entering the invalid Email ID in the 'Forgot Password' Paged");
			}
		} catch (Exception e) {
			System.out.println("Error message ('Email not registered') should not come after entering the invalid Email ID in the 'Forgot Password' Page");
			ExtentTest test3=ext.createTest("Verify the error message appearing after entering the invalid email ID in the 'Forgot Password' page ");
			test3.fail("This test is passeError message ('Email not registered') should not come after entering the invalid Email ID in the 'Forgot Password' Paged");
			test3.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_4() throws Exception {
		forgot_excel();
		// verifying Reset password button is enabled after giving valid data in email text field
		System.out.println("***************************************************************************");
		System.out.println("Scenario_02");
		System.out.println("Expected Result-verifying Reset password button is enabled after giving valid data in email text field");
		try {
			email.clear();
			email.sendKeys(validemail);
			Thread.sleep(3000);
			if (forgot_password_Btn.isEnabled()) {
				System.out.println("Reset password button is enabled after giving valid data in email text field");
				ExtentTest test4=ext.createTest("verifying Reset password button is enabled after giving valid data in email text field");
				test4.pass("Reset password button is enabled after giving valid data in email text field");
			} 
		} catch (Exception e) {
			System.out.println("Reset password button is disabled after giving invalid data in email text field");
			ExtentTest test4=ext.createTest("verifying Reset password button is enabled after giving valid data in email text field");
			test4.fail("Reset password button is disabled after giving invalid data in email text field");
			test4.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_5() throws Exception {
		forgot_excel();
		// Verify that 'Password Reset E-mail Sent' pop up appearing after click on the 'Reset Password' button
		System.out.println("***************************************************************************");
		System.out.println("Scenario_06");
		System.out.println("Expected Result-Verify that 'Password Reset E-mail Sent' pop up appearing after click on the 'Reset Password' button");
		try {
			email.clear();
			email.sendKeys(validemail);
			Thread.sleep(3000);
			forgot_password_Btn.click();
			Thread.sleep(3000);
			popup_messege = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Password Reset E-mail Sent']")));
			popup_messege.getText();
			driver.getPageSource();

			if (driver.getPageSource().contains(popup_messege.getText())) {
				System.out.println("Password Reset E-mail Sent\' pop up should be appear ");
				ExtentTest test5=ext.createTest("Verify that 'Password Reset E-mail Sent' pop up appearing after click on the 'Reset Password' button");
				test5.pass("Password Reset E-mail Sent\\' pop up should be appear");
			}
		} catch (Exception e) {
			System.out.println("Password Reset E-mail Sent\' pop up should not be appear ");
			ExtentTest test5=ext.createTest("Verify that 'Password Reset E-mail Sent' pop up appearing after click on the 'Reset Password' button");
			test5.fail("Password Reset E-mail Sent\\' pop up should not be appear");
			test5.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_6() throws Exception {
		forgot_excel();
		// Verify reset password email sent to the mail ID after clicking the Reset password button 
		System.out.println("***************************************************************************");
		System.out.println("Scenario_03");
		System.out.println("Expected Result-Verify reset password email sent to the mail ID after clicking the Reset password button ");
		try {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://yopmail.com/");
			emailwindow = driver.getWindowHandle();
			driver.findElement(By.id("login")).sendKeys(validemail);
			driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
			driver.switchTo().frame("ifmail");
			emailvalidation = driver.findElement(By.xpath("//p[contains(text(),'Hey CodeTru, looks like you submitted a request to')]"));
			emailvalidation.getText();
			System.out.println(emailvalidation.getText());
			emailpage = driver.getPageSource();
			if (emailpage.contains(emailvalidation.getText())) {
				System.out.println("Reset Password email should send to the mail ID after clicking the Reset Password button ");
				ExtentTest test6=ext.createTest("Verify reset password email sent to the mail ID after clicking the Reset password button");
				test6.pass("Reset Password email should send to the mail ID after clicking the Reset Password button ");
			}
		} catch (Exception e) {
			System.out.println("Reset Password email not send to the mail ID after clicking the Reset Password button ");
			ExtentTest test6=ext.createTest("Verify reset password email sent to the mail ID after clicking the Reset password button");
			test6.fail("Reset Password email should send to the mail ID after clicking the Reset Password button ");
			test6.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		driver.switchTo().defaultContent();
	}

	public void Test_7() throws Exception {
		forgot_excel();
		// Verify that user get the 'Reset Password' link in their respective email
		System.out.println("***************************************************************************");
		System.out.println("Scenario_07");
		System.out.println("Expected Result-Verify that user get the 'Reset Password' link in their respective email");
		try {
			driver.switchTo().frame("ifmail");
			resetpassword_link = driver.findElement(By.xpath("//img[@alt='Reset Password']"));
			resetpassword_link.getText();

			if (emailpage.contains(resetpassword_link.getText())) {
				System.out.println("user get the 'Reset Password' link in their respective email sucessfully ");
				ExtentTest test7=ext.createTest("Verify that user get the 'Reset Password' link in their respective email");
				test7.pass("user get the 'Reset Password' link in their respective email sucessfully ");
			}
		} catch (Exception e) {
			System.out.println("user not get the 'Reset Password' link in their respective email ");
			ExtentTest test7=ext.createTest("Verify that user get the 'Reset Password' link in their respective email");
			test7.fail("user not get the 'Reset Password' link in their respective email ");
			test7.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_8() throws Exception {
		forgot_excel();
		//Verify user navigating on 'Reset Password' pop up after clicking on the 'Reset Password' link
		System.out.println("***************************************************************************");
		System.out.println("Scenario_08");
		System.out.println("Expected Result-Verify user navigating on 'Reset Password' pop up after clicking on the 'Reset Password' link");
		resetpassword_link.click();
		Set<String> WindowHandles = driver.getWindowHandles();
		for (String window : WindowHandles) {
			if (!window.equals(emailwindow)) {
				if (!window.equals(mainwindow)) {
					driver.switchTo().window(window);
					subheading = driver.findElement(By.xpath("//p[@class='subheading']"));
					System.out.println(subheading.getText());

					try {
						if (driver.getPageSource().contains(subheading.getText())) {
							System.out.println("User navigated on the 'Reset Password' pop up after clicking on the 'Reset Password' link sucessfully");
							ExtentTest test8=ext.createTest("Verify user navigating on 'Reset Password' pop up after clicking on the 'Reset Password' link");
							test8.pass("User navigated on the 'Reset Password' pop up after clicking on the 'Reset Password' link sucessfully");
						}
					} catch (Exception e) {
						System.out.println("User unable to navigated on the 'Reset Password' pop up after clicking on the 'Reset Password' link ");
						ExtentTest test8=ext.createTest("Verify user navigating on 'Reset Password' pop up after clicking on the 'Reset Password' link");
						test8.fail("User unable to navigated on the 'Reset Password' pop up after clicking on the 'Reset Password' link ");
						test8.addScreenCaptureFromPath(capturescreenshot(driver));
					}
				}
			}
		}
	}

	public void Test_9() throws Exception {
		forgot_excel();
		//Verify user see the Password Instruction while start entering the password
		System.out.println("***************************************************************************");
		System.out.println("Scenario_10");
		System.out.println("Expected Result-Verify user see the Password Instruction while start entering the password");
		new_password = driver.findElement(By.xpath("//input[@autocomplete=\'new-password\']"));
		new_password.sendKeys(onechar);
		confirmpassword = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		password_inst=driver.findElement(By.xpath("//span[text()='Password must contain:']"));
		password_inst.getText();
		System.out.println(password_inst.getText());
		assert password_inst.isDisplayed();
		System.out.println("User able to see password instruction");
		ExtentTest test9=ext.createTest("Verify user see the Password Instruction while start entering the password");
		test9.pass("User able to see password instruction");
	}

	public void Test_10() throws Exception {
		forgot_excel();
		//Verify the 'Password Requirement' is matching the criteria
		System.out.println("***************************************************************************");
		System.out.println("Scenario_15");
		System.out.println("Expected Result-Verify the 'Password Requirement' is matching the criteria");
		new_password.clear(); 
		new_password.sendKeys(invalidcriteria);
		passwordRequirement= driver.findElement(By.xpath("//input[@placeholder=\'Password\']"));
		passwordRequirementText=passwordRequirement.getAttribute("value");
		System.out.println(passwordRequirementText);

		assertFalse(passwordRequirementText.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}") );
		System.out.println("password not matches the criteria");
		ExtentTest test10=ext.createTest("Expected Result-Verify the 'Password Requirement' is matching the criteria");
		test10.pass("Password not matches the criteria");
		new_password.clear(); 
		new_password.sendKeys(validcriteria);
		passwordRequirement_1= driver.findElement(By.xpath("//input[@placeholder=\'Password\']"));
		passwordRequirementText_1=    passwordRequirement_1.getAttribute("value");
		System.out.println(passwordRequirementText_1);

		assertTrue(passwordRequirementText_1.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}"));
		System.out.println("Password matches the criteria");
		ExtentTest test_10=ext.createTest("Expected Result-Verify the 'Password Requirement' is matching the criteria");
		test_10.pass("Password matches the criteria");
	}

	public void Test_11() throws Exception {
		forgot_excel();
		//Verify 'Save' button not enabled until user entered the valid 'Password' & valid 'Confirm Password' input
		System.out.println("***************************************************************************");
		System.out.println("Scenario_09");
		System.out.println("Expected Result-Verify 'Save' button not enabled until user entered the valid 'Password' & valid 'Confirm Password' input");
		try {
			new_password.clear(); 
			new_password.sendKeys(invalidnewpassword);
			confirmpassword.clear();
			confirmpassword.sendKeys(invalidconfpass);

			if(!driver.findElement(By.xpath("//button[.=' Save ']")).isEnabled()) {
				System.out.println("Save button is enabled after user enter valid data in both password and confirm password");
				ExtentTest test11=ext.createTest("Verify 'Save' button not enabled until user entered the valid 'Password'");
				test11.pass("Save button is enabled user enter invalid data in both password and confirm password");
			}
		} catch (Exception e) { 
			System.err.println("Save button is disabled user enter invalid data in both password and confirm password"); 
			ExtentTest test11=ext.createTest("Verify 'Save' button not enabled until user entered the valid 'Password'");
			test11.fail("Save button is disabled user enter invalid data in both password and confirm password");
			test11.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_12() throws Exception {
		try {
			forgot_excel();
			new_password.clear();
			new_password.sendKeys(validpassword);
			confirmpassword.clear(); 
			confirmpassword.sendKeys(validpassword);


			if(driver.findElement(By.xpath("//button[.=' Save ']")).isEnabled()) {
				System.out.println("Save button is enabled after user enter valid data in both password and confirm password");
				ExtentTest test121=ext.createTest("Verify 'Save' button not enabled until user entered the valid 'Password'");
				test121.pass("Save button is enabled after user enter valid data in both password and confirm password");
			}
		} catch (Exception e) { 
			System.err.println("Save button is disabled user enter invalid data in both password and confirm password"); 
			ExtentTest test121=ext.createTest("Verify 'Save' button not enabled until user entered the valid 'Password'");
			test121.fail("Save button is enabled after user enter valid data in both password and confirm password");
			test121.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_13() throws Exception {
		forgot_excel();
		//    Verify that validation message is appearing when 'Password' do no  match with 'Confirm Password
		System.out.println("***************************************************************************");
		System.out.println("Scenario_11");
		System.out.println("Expected Result-Verify that validation message is appearing when 'Password' do no  match with 'Confirm Password'");
		try {
			new_password.clear();
			new_password.sendKeys(validpassword);
			confirmpassword.clear();
			confirmpassword.sendKeys(passnotmatch);
			password_not_matched=driver.findElement(By.xpath("//span[.='Password entries do not match.']"));
			System.out.println(password_not_matched.getText()); 
			reset_passwordpage=driver.getPageSource();


			if(reset_passwordpage.contains(password_not_matched.getText())) {
				System.err.println("Password entries do not matched"); 
				ExtentTest test12=ext.createTest("Verify that validation message is appearing when 'Password' do no  match with 'Confirm Password'");
				test12.pass("Password entries do not matched");
			}
		} catch (Exception e) {
			System.out.println("password entries are matched");
			ExtentTest test12=ext.createTest("Verify that validation message is appearing when 'Password' do no  match with 'Confirm Password'");
			test12.fail("Password entries are matched");
			test12.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_14() throws Exception {
		forgot_excel();
		//Verify that a popup of password change succesfull will come after clicking the save button
		System.out.println("***************************************************************************");
		System.out.println("Scenario_12");
		System.out.println("Expected Result-Verify that a popup of password change succesfull will come after clicking the save button");
		try {
			new_password.clear(); 
			new_password.sendKeys(validpassword);
			confirmpassword.clear();
			confirmpassword.sendKeys(validpassword); 
			save_btn=driver.findElement(By.xpath("//button[.=' Save ']"));


			if(save_btn.isEnabled()){
				save_btn.click(); 
				pass_change_sucess=driver.findElement(By.xpath("//h2[normalize-space()='Password Change Successfull!']"));
				pass_change_sucess.getText();
				System.out.println(pass_change_sucess.getText());
				if(driver.getPageSource().contains(pass_change_sucess.getText())) {
					System.out.println("Password changed sucessfully");
					ExtentTest test13=ext.createTest("Verify that a popup of password change succesfull will come after clicking the save button ");
					test13.pass("Password changed sucessfully");
				}
			}
		}

		catch (Exception e) {
			System.err.println("Password didnt changed sucessfully");
			ExtentTest test13=ext.createTest("Verify that a popup of password change succesfull will come after clicking the save button ");
			test13.fail("Password didnt changed sucessfully");
			test13.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public void Test_15()throws Exception {
		forgot_excel();
		//Verify that user navigate to the login page after clicking the login button in the Password Change Successfull' pop up
		System.out.println("***************************************************************************");
		System.out.println("Scenario_13");
		System.out.println("Expected Result-Verify that user navigate to the login page after clicking the login button in the Password Change Successfull' pop up");
		try {
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			signinpage=driver.findElement(By.xpath("//p[@class='subheading']"));
			signinpage.getText();

			if(driver.getPageSource().contains(signinpage.getText())) { 
				System.out.println("User can navigate to the login page after clicking the login button in the 'Password change Successfull' pop up "); 
				ExtentTest test14=ext.createTest("Verify that user navigate to the login page after clicking the login button in the Password Change Successfull' pop up ");
				test14.pass("User can navigate to the login page after clicking the login button in the 'Password change Successfull' pop up ");
			}
		} catch (Exception e) {
			{ 
				System.err.println("User cannot navigate to the login page after clicking the login button in the 'Password change Successfull' pop up "); 
				ExtentTest test14=ext.createTest("Verify that user navigate to the login page after clicking the login button in the Password Change Successfull' pop up ");
				test14.fail("User cannot navigate to the login page after clicking the login button in the 'Password change Successfull' pop up ");
				test14.addScreenCaptureFromPath(capturescreenshot(driver));
			}
		}
	}

	public void Test_16() throws Exception {

		forgot_excel();
		System.out.println("***************************************************************************");
		System.out.println("Scenario_14");
		System.out.println("Expected Result-Verify user able to login to login with recently change password\n");
		//Verify user able to login to login with recently change password
		try {
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(validemail);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(validpassword);
			assert driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			Thread.sleep(3000);
			dashboardpage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dashboard']")));
			if(dashboardpage.isDisplayed()) {
				System.out.println("User is able to login with newly changed password successfully"); 
				ExtentTest test15=ext.createTest("Verify user able to login to login with recently change password ");
				test15.pass("User is able to login with newly changed password successfully");
			}
		} catch (Exception e) { 
			System.err.println("User is not able to login with newly changed password");
			ExtentTest test15=ext.createTest("Verify user able to login to login with recently change password ");
			test15.fail("User unable to login with newly changed password successfully");
			test15.addScreenCaptureFromPath(capturescreenshot(driver));
		}
	}

	public static String capturescreenshot(WebDriver driver) throws Exception {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationfilepath=new File("C:\\Users\\Codetru\\eclipse-workspace\\SampleCodetruProject\\Parspec_Project\\target\\Images"+System.currentTimeMillis()+".png");    
		String absolutepathlocation =destinationfilepath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinationfilepath);
		return absolutepathlocation;
	}


	public void afterTest() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	public void teardown() throws Exception {
		ext.flush();
		Desktop.getDesktop().browse(new File("reportForgotModule.html").toURI());        
	}

}
