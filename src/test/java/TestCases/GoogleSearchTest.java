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

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set Chrome options to run in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");   // Run Chrome in headless mode
        options.addArguments("--disable-gpu"); // Disables GPU hardware acceleration
        options.addArguments("--window-size=1920,1080"); // Sets a consistent viewport size
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() {
        String searchQuery = "Selenium";  // Search query is set to "Selenium"

        // Open Google
        driver.get("https://www.google.com");

        // Find the search box, input the search term, and submit
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchQuery);
        searchBox.submit();

        // Wait briefly for results to load (simple pause; use WebDriverWait for a more robust solution)
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Verify that results page contains search query
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(searchQuery.toLowerCase()),
                "The search query was not found in the page title.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

