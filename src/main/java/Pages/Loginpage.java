package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    WebDriver driver;
    WebDriverWait wait;

    public Loginpage(WebDriver driver) {
        // Null check to avoid NullPointerException
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is null! Make sure to initialize it.");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait of 10 seconds
    }

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButtonField = By.xpath("//input[@id='login-button']");
    private By errorLocator = By.xpath("//h3[@data-test='error']");
    private By homeHeader = By.className("app_logo");

    // Method to enter username
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    // Method to click login
    public void clickLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonField));
        loginButton.click();
    }

    // Reusable login method
    public Homepage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();

        // Wait for homepage to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeHeader));

        return new Homepage(driver); // Return the homepage object after successful login
    }

    // Method to check for login errors
    public String getErrorMessage() {
        try {
            WebElement errorElement = driver.findElement(errorLocator);
            return errorElement.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
