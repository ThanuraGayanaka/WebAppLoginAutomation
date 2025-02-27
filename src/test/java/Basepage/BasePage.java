package Basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;


    public void setup() throws InterruptedException, FileNotFoundException {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.saucedemo.com/");

            // ✅ Wait explicitly for the login field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-button']")));
            loginButton.click();

        }
    }


    @AfterSuite
    public void teardown(){

        driver.quit();

    }

    /*
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

     */


}
