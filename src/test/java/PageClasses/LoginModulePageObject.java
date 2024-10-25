package PageClasses;


import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Excel_Utility.Excel_Utility_LoginModule;
import java.awt.Desktop;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginModulePageObject extends Excel_Utility_LoginModule {
	RemoteWebDriver driver;
	WebDriverWait wait;

	WebElement emailfield = null;
	WebElement password1 = null;
	WebElement Login = null;
	String window;
	String parentwindow;
	Set<String> windowhandles;
	File file;

	ExtentReports ext = new ExtentReports();

	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	ExtentSparkReporter SparkReporter;

	SoftAssert softassert=new SoftAssert();



	public void ExtentReportSetup() {
		ext=new ExtentReports();
		file = new File("reportLoginModule.html");
		SparkReporter=new ExtentSparkReporter(file);
		ext.attachReporter(SparkReporter);
	}

	Excel_Utility_LoginModule exceldata = new Excel_Utility_LoginModule();

	public void scenario_1() throws Exception {
		System.out.println("Scenario - 1");
		System.out.println("Expected results : Verify that user is able to naviagate on the Login Page");
		ExtentTest test1 = ext.createTest("1. Verify that user is able to naviagate on the Login Page");

		try {
			WebElement logo	=  driver.findElement(By.xpath("//h2[text()='Welcome Back']"));		

			if(logo.getText().contains("Welcome Back")) {
				System.out.println("Actual results : User Navigated to Login page");
				test1.pass("User Navigated to Login page");
			}
		} catch (Exception e) {
			System.out.println("Actual results : User not able to Navigate to the login page");
			test1.fail("User should not be able to navigate to the Login Page");
			test1.addScreenCaptureFromPath(capturescreenshot(driver));
		}		

		emailfield = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		password1 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		Login = driver.findElement(By.xpath("//button[text()='Login']"));
		System.out.println("===================================****===================================");
	}

	public void scenario_2() throws Exception {

		System.out.println("Scenario - 9");
		System.out.println("Expected results : Verify the error message('This field is required') will come after entering no inpput in the 'Email' field and no input in the 'Password' field ");
		System.out.println("Without Email and Without Password");
		ExtentTest test2 = ext.createTest("9. Verify the error message('This field is required') will come after entering no inpput in the 'Email' field and no input in the 'Password' field ");

		try {
			emailfield.click();
			password1.click();
			WebElement emailfeildrequired = driver.findElement(By.xpath("(//p[text() = '*This field is required.'])[1]"));		


			if(emailfeildrequired.getText().contains("*This field is required.")) {
				System.err.println("Actual results : Email feild is required");
				test2.pass("This field is required");

			}
		} catch (Exception e) {
			System.out.println("Actual results : Email entered");
			test2.fail("Email entered ");
			test2.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		Thread.sleep(2000);
		emailfield.click();

		WebElement passfeildrequired = driver.findElement(By.xpath("(//p[text() = '*This field is required.'])[2]"));
		if(passfeildrequired.getText().contains("*This field is required.")) {
			System.err.println("Actual results : Password feild is required");
		} else{
			System.out.println("Actual results : password is entered");
		}

		Thread.sleep(2000);
		emailfield.clear();
		password1.clear();
		System.out.println("===================================****===================================");
	}

	public void scenario_3() throws Exception {

		System.out.println("Scenario - 8");
		System.out.println("Expected results : Verify the 'Login' button after entering no input in the ' Email' field and no input in the 'Password' filed ");

		ExtentTest test3 = ext.createTest("8. Verify the 'Login' button after entering no input in the ' Email' field and no input in the 'Password' filed ");

		try {
			WebElement loginbutton2 = driver.findElement(By.xpath("//button[text() = 'Login']"));
			System.out.println("Without email : ");
			System.out.println("Without password : ");


			if(!loginbutton2.isEnabled()) {
				System.out.println("Actual results : Login button is disabled");	
				test3.pass("Login button is disabled");

			}
		} catch (Exception e) {
			System.err.println("Actual results : Login button is Enabled ");
			test3.fail("Login button is Enabled");
			test3.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		emailfield.clear();
		password1.clear();
		System.out.println("===================================****===================================");
	}

	public void scenario_4() throws Exception {
		
		System.out.println("Scenario - 6");
		System.out.println("Expected results :6. Verify that 'Login' button after entering the valid input in 'Email' field and no input in the 'Password' field ");
		ExtentTest test4 = ext.createTest("Verify that 'Login' button after entering the valid input in 'Email' field and no input in the 'Password' field");

		try {
			 excel1();
			emailfield.sendKeys(validemail4);
			//password1.sendKeys(withoutpassword4);

			WebElement loginbutton3 = driver.findElement(By.xpath("//button[text() = 'Login']"));


			if(!loginbutton3.isEnabled()) {
				System.out.println("Actual results : Login button is disabled ");	
				test4.pass("Login button is disabled");

			}
		} catch (Exception e) {
			System.err.println("Actual results : Login button is Enabled");
			test4.fail("Login button is Enabled");
			test4.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		Thread.sleep(2000);
		System.out.println("===================================****===================================");

		System.out.println("Scenario - 2");
		System.out.println("Expected results :Verify user enters the valid input in the Email text field ");

		ExtentTest test5 = ext.createTest("2. Verify user enters the valid input in the Email text field ");

		try {
			String userentered = emailfield.getAttribute("value");	
			System.out.println("Valid Email	: "+validemail4);
			System.out.println("Without Password : ");


			if(userentered.equals(validemail4)) {
				System.out.println("Actual Results : User was able to enter the email in the email feild");
				test5.pass("User should accept the valid input in the text field ");
			} 
		} catch (Exception e) {
			System.err.println("Actual Results : User not able to enter the email");
			test5.fail("User should accept the valid input in the text field ");
			test5.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		parentwindow = driver.getWindowHandle();
		emailfield.clear();
		password1.clear();
		System.out.println("===================================****===================================");

	}

	public void scenario_5() throws Exception {

		System.out.println("Scenario - 7");
		System.out.println("Expected Results : Verify that 'Login button' after entering the valid input in the 'Password' filed and no input in the 'Email' field ");
		ExtentTest test6 = ext.createTest("7. Verify that 'Login button' after entering the valid input in the 'Password' filed and no input in the 'Email' field ");
		try {
			 excel1();
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://codetrue-poc--stage-parspec-app.netlify.app/login");	

			driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("");

			driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(validpassword5);
			System.out.println("Without Email = ");
			System.out.println("Valid Password = "+validpassword5);
			WebElement loginbutton4 = driver.findElement(By.xpath("//button[text()='Login']"));		


			if(!loginbutton4.isEnabled()) {
				System.out.println("Actual Results : Login button is disabled");	

				test6.pass("Login button is disabled");

			} 
		} catch (Exception e) {
			System.err.println("Actual Results : Login button is Enabled");
			test6.fail(" Login button is Enabled");
			test6.addScreenCaptureFromPath(capturescreenshot(driver));
		}

		windowhandles = driver.getWindowHandles();
		for(String wind :windowhandles ) {
			if(!wind.equals(parentwindow)) {
				window = wind;
				//driver.close();
			}
		}		
		driver.switchTo().window(parentwindow);
		System.out.println("===================================****===================================");
	}

	public void scenario_6() throws Exception {
		System.out.println("Scenario - 3 ");
		System.out.println("Expected Results : Verify error (Incorrect Login credentials) will come after entering the invalid inputs in the 'Email' text field and valid input in the 'Password' field ");		
		ExtentTest test7 = ext.createTest("3. Verify error (Incorrect Login credentials) will come after entering the invalid inputs in the 'Email' text field and valid input in the 'Password' field ");
		try {
			 excel1();
			Thread.sleep(3000);

			emailfield.sendKeys(invalidemail1);
			password1.sendKeys(validpassword1);
			Login.click();
			System.out.println("Invalid Email : "+invalidemail1);
			System.out.println("Valid Password : "+validpassword1);
			WebElement invalidlogincred1 =
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Incorrect login credentials']")));


			if(invalidlogincred1.getText().contains("Incorrect login credentials")) {
				System.err.println("Actual Results : Incorrect login credentials");
				test7.pass("Incorrect login credentials");
			}
		} catch (Exception e) {
			System.out.println("Actual Results : Valid credentials");
			test7.fail("Valid credentials");
			test7.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		Thread.sleep(2000);
		emailfield.clear();
		password1.clear();
		System.out.println("===================================****===================================");

	}

	public void scenario_7() throws Exception {
		

		System.out.println("Scenario - 4 ");
		System.out.println("Expected Results : Verify error message('Incorrect Login Credentials') will come after entering the valid input in the Email text field and invalid input in the Password field");
		ExtentTest test8 = ext.createTest("4. Verify error message('Incorrect Login Credentials') will come after entering the valid input in the Email text field and invalid input in the Password field");

		try {
			 excel1();
			emailfield.sendKeys(validemail2);
			password1.sendKeys(invalidpassword2);
			emailfield.click();
			Login.click();

			WebElement invalidlogincred2 =
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Incorrect login credentials']")));
			System.out.println("Valid Email 	 : "+validemail2);
			System.out.println("Invalid Password : "+invalidpassword2);


			if(invalidlogincred2.getText().contains("Incorrect login credentials")) {
				System.err.println("Actual results : Incorrect login credentials");
				test8.pass("Incorrect login credentials");
			}
		} catch (Exception e) {
			System.out.println("Actual results : Valid credentials");
			test8.fail("Valid credentials");
			test8.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		Thread.sleep(2000);
		emailfield.clear();
		password1.clear();
		System.out.println("===================================****===================================");
	}
	
	public void scenario_8() throws Exception {

		

		System.out.println("Scenario - 5 ");
		System.out.println("Expexted Results : Verify error message ('Invalid Login Credentials') will come after entering the invalid input in the Email text field and invalid input in the password text field ");
		ExtentTest test9 = ext.createTest("5. Verify error message ('Invalid Login Credentials') will come after entering the invalid input in the Email text field and invalid input in the password text field");
		try {
			 excel1();
			emailfield.sendKeys(invalidemail3);
			password1.sendKeys(invalidpassword3);

			Login.click();

			WebElement invalidlogincred3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Incorrect login credentials']")));
			System.out.println("Invalid Email 	 : "+invalidemail3);
			System.out.println("Invalid Password : "+invalidpassword3);

			if(invalidlogincred3.getText().contains("Incorrect login credentials")) {
				System.err.println("Actual Results : Incorrect login credentials");
				test9.pass("Incorrect login credentials");
			}} catch (Exception e) {
				System.out.println("Actual results : Valid credentials");
				test9.fail("Valid credentials");
				test9.addScreenCaptureFromPath(capturescreenshot(driver));
			}
		emailfield.clear();
		password1.clear();

		System.out.println("===================================****===================================");

	}

	public void scenario_9() throws Exception {

		System.out.println("Scenario - 10 ");
		System.out.println("Expected Results : Verify the 'Terms of Service' link will be accessible also when no input is provided in theb Email field and Password field ");

		ExtentTest test10 = ext.createTest("10. Verify the 'Terms of Service' link will be accessible also when no input is provided in theb Email field and Password field");
		
		try {
			WebElement tandc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Terms of Service ']")));
			tandc.click();		
			if(tandc.getText().contains("Terms of Service")) {
				System.out.println("Actual Results : User Navigated to Terms of Service page ");
				test10.pass("User Navigated to Terms of Service page ");
			}} catch (Exception e) {
				System.err.println("Actual Results : User not able to Navigate to the Terms of Service page");
				test10.fail("User not able to Navigate to the Terms of Service page");
				test10.addScreenCaptureFromPath(capturescreenshot(driver));
			}
		System.out.println("===================================****===================================");
	}

	public void chromeopen() throws MalformedURLException {

		spark.config().setTheme(Theme.DARK);	
		spark.config().setDocumentTitle("MyReport");	
		ext.attachReporter(spark);

		//WebDriverManager.chromedriver().setup(); 

		
		
		
		
		DesiredCapabilities dc=new DesiredCapabilities();
	       dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	       driver = new RemoteWebDriver(new URL("http://codetru.org:4444/wd/hub"),dc);
	      // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/usr/bin/google-chrome");
	       ChromeOptions cop = new ChromeOptions();
	       driver = new RemoteWebDriver(cop);
	       cop.addArguments("--allow-running-insecure-content");	

		driver.get("https://codetrue-poc--stage-parspec-app.netlify.app/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public static String capturescreenshot(WebDriver driver) throws Exception {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationfilepath=new File("C:\\Users\\Codetru\\eclipse-workspace\\SampleCodetruProject\\Parspec_Project\\target\\Images"+System.currentTimeMillis()+".png");    
		String absolutepathlocation =destinationfilepath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinationfilepath);
		return absolutepathlocation;
	}
	public void closeallbrowsers()
	{
		driver.quit();
	}
	public void teardown() throws Exception {
		ext.flush();
		Desktop.getDesktop().browse(new File("reportLoginModule.html").toURI());        
	}
//	public void BrowserLaunch() throws MalformedURLException {
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("MyReport");
//		ext.attachReporter(spark);
//		//WebDriverManager.chromedriver().setup();
//		//String current = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\Drivers\\chromedriver.exe");
//		//WebDriver driver = new ChromeDriver();
//		ChromeOptions cop = new ChromeOptions();
//		cop.addArguments("--allow-running-insecure-content");
//		DesiredCapabilities dc=new DesiredCapabilities();
//
//	//	dc.setBrowserName(BrowserType.CHROME);
//		dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//		driver = new RemoteWebDriver(new URL("http://codetru.org:4444/wd/hub"),dc);
//		driver = new ChromeDriver(cop);
//		driver.get("https://codetrue-poc--stage-parspec-app.netlify.app/login");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	}

}
