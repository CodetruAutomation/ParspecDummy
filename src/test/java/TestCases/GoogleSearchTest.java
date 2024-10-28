package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestUtilities;

import java.time.Duration;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = TestUtilities.initWebDriver();
        TestUtilities.initExtentReports();
        TestUtilities.startTest("Google Search Test", "Verifies Google search functionality.");
    }

    @Test
    public void testGoogleSearch() {
        String searchQuery = "Selenium java";
        TestUtilities.logInfo("Starting test with search query: " + searchQuery);

        // Open Google and perform search
        driver.get("https://www.google.com");
        TestUtilities.logInfo("Opened Google homepage.");

        WebElement searchBox = TestUtilities.waitForElement(By.name("q"), Duration.ofSeconds(10));
        searchBox.sendKeys(searchQuery);
        TestUtilities.logInfo("Entered search query: " + searchQuery);
        searchBox.submit();
        TestUtilities.logInfo("Submitted search form.");

        // Wait for search results and verify title
        WebElement firstResult = TestUtilities.waitForElement(By.cssSelector("h3"), Duration.ofSeconds(10));
        String pageTitle = driver.getTitle().toLowerCase();
        Assert.assertTrue(pageTitle.contains(searchQuery.toLowerCase()), "The search query was not found in the page title.");
        TestUtilities.logInfo("Test assertion passed: Page title contains search query.");
    }

    @AfterClass
    public void tearDown() {
        TestUtilities.captureScreenshot("testGoogleSearch.png");  // Capture screenshot after test
        TestUtilities.closeWebDriver();
        TestUtilities.flushReports();
    }
}
