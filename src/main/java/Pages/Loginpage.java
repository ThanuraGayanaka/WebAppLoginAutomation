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

    // Locators (Fixed variable names to follow camelCase convention)
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButtonField = By.xpath("//input[@id='login-button']");

    // Method to enter the username (Corrected spelling)
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
    }

    // Method to enter the password (Corrected spelling)
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    // Method to click the login button
    public void clickLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonField));
        loginButton.click();
    }

    // Reusable method to log in (Fixed spelling of method names)
    public void login(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);

        Thread.sleep(1000);
        clickLogin();
    }
}
