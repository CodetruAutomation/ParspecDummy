package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUtilities {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;
    private static final Logger logger = Logger.getLogger(TestUtilities.class.getName());

    // Setup WebDriver with Chrome options
    public static WebDriver initWebDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
            driver = new ChromeDriver(options);
            logger.log(Level.INFO, "Initialized ChromeDriver in headless mode.");
        }
        return driver;
    }

    // Setup Extent Reports
    public static ExtentReports initExtentReports() {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
            htmlReporter.config().setDocumentTitle("Test Report");
            htmlReporter.config().setReportName("Automation Test Report");
            htmlReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            logger.log(Level.INFO, "Initialized Extent Reports.");
        }
        return extent;
    }

    // Start Extent Test
    public static ExtentTest startTest(String testName, String description) {
        test = extent.createTest(testName, description);
        return test;
    }

    // Utility method for logging
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
        if (test != null) test.info(message);
    }

    // Utility method to wait for an element to be visible
    public static WebElement waitForElement(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Utility method for capturing a screenshot
    public static void captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(srcFile.toPath(), Paths.get(screenshotName));
            logInfo("Screenshot taken: " + screenshotName);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error capturing screenshot: " + screenshotName, e);
        }
    }

    // Close WebDriver
    public static void closeWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.log(Level.INFO, "Closed WebDriver.");
        }
    }

    // Flush Extent Reports
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
            logger.log(Level.INFO, "Flushed Extent Reports.");
        }
    }
}
