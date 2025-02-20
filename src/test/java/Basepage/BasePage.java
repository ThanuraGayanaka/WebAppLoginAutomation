package Basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
    protected WebDriver driver; // Protected to allow access in subclasses

  // Runs before each test
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }

   // @AfterMethod // Runs after each test
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Getter method to access WebDriver
    public WebDriver getDriver() {
        return driver;
    }
}
