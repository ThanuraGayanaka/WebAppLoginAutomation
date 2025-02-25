package Basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;

    @BeforeSuite
    public void setup() throws InterruptedException {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.saucedemo.com/");
            driver.manage().deleteAllCookies();

            // ✅ Wait explicitly for the login field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        }
    }


    @AfterSuite
    public void teardown() {
        System.out.println("Executing teardown method...");
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the instance
            System.out.println("Browser closed successfully.");
        } else {
            System.out.println("Driver is already null, skipping quit.");
        }
    }


}
