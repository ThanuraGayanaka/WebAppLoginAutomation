package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public Homepage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is null! Make sure to initialize it.");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased timeout
    }

    // Locators
    private By headerTitleLocator = By.xpath("//div[@class='app_logo']");


    // Method to check the header title
    public String checkHeaderTitle() {
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitleLocator));
        return headerElement.getText();
    }
}
