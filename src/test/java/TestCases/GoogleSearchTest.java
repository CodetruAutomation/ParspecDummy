package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GoogleSearchTest {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(GoogleSearchTest.class.getName());

    @BeforeClass
    public void setup() {
        // Set Chrome options to run in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");   // Run Chrome in headless mode
        options.addArguments("--disable-gpu"); // Disables GPU hardware acceleration
        options.addArguments("--window-size=1920,1080"); // Sets a consistent viewport size
        
        logger.log(Level.INFO, "Initializing ChromeDriver in headless mode.");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() {
        String searchQuery = "Selenium";  // Search query is set to "Selenium"
        logger.log(Level.INFO, "Starting test: testGoogleSearch with query: {0}", searchQuery);

        // Open Google
        driver.get("https://www.google.com");
        logger.log(Level.INFO, "Opened Google homepage.");

        // Find the search box, input the search term, and submit
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchQuery);
        logger.log(Level.INFO, "Entered search query: {0}", searchQuery);
        searchBox.submit();
        logger.log(Level.INFO, "Submitted search form.");

        // Wait briefly for results to load (simple pause; use WebDriverWait for a more robust solution)
        try {
            Thread.sleep(2000);
            logger.log(Level.INFO, "Waited for 2 seconds to allow search results to load.");
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "InterruptedException occurred during sleep", e);
        }

        // Verify that results page contains search query
        String pageTitle = driver.getTitle().toLowerCase();
        logger.log(Level.INFO, "Page title after search: {0}", pageTitle);
        Assert.assertTrue(pageTitle.contains(searchQuery.toLowerCase()),
                "The search query was not found in the page title.");
        logger.log(Level.INFO, "Test assertion passed: Page title contains search query.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
            logger.log(Level.INFO, "Closed the browser and ended the test.");
        }
    }
}
