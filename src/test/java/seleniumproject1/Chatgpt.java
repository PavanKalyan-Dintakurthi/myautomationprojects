package seleniumproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chatgpt {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to your chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Flipkart website
        driver.get("https://www.flipkart.com/");

        // Locate the search bar
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")); // Replace with the actual attribute of the search bar

        // Type into the search bar
        searchInput.sendKeys("mobiles ");
        Thread.sleep(5000);

        // Wait for auto-suggestions to appear
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement suggestionsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestions")));
        
        // Click on the first suggestion
        //WebElement suggestion = suggestionsContainer.findElements(By.tagName("li")).get(3);
        //suggestion.click();

        // Perform further actions if needed

        // Close the browser
        driver.quit();
    }
}
