import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HackerNoonTest {
    public static void main(String[] args) {
        
        // 1.Specifying the location (Path) of ChromeDriver
        // Windows : "C:\\path\\to\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // 2. Opening the browser (Chrome)
        WebDriver driver = new ChromeDriver();

        try {
            // 3. Go to website
            driver.get("https://hackernoon.com");
            
            // Maximizing the window
            driver.manage().window().maximize();

            // Waiting 3 seconds for the website to load
            Thread.sleep(3000);

            // 4. Finding the Search Button (The search icon on HackerNoon is usually identified by an ID)
            // Note: Website IDs may change from time to time.
            WebElement searchIcon = driver.findElement(By.CSS_SELECTOR, "button[aria-label='Search']");
            searchIcon.click();

            // 5. Type "QA Automation" in the search bar and enter.
            WebElement searchInput = driver.findElement(By.NAME, "query"); 
            searchInput.sendKeys("QA Automation");
            searchInput.sendKeys(Keys.ENTER);

            // 6. Wait 5 seconds to see the results.
            Thread.sleep(5000);
            
            System.out.println("Test Case Passed: Search successful!");

        } catch (Exception e) {
            System.out.println("Test Case Failed: " + e.getMessage());
        } finally {
            // 7. Closing the browser
            driver.quit();
        }
    }
}