package Testpage;

import Basepage.BasePage;
import Pages.Loginpage;
import jdk.jfr.Enabled;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTest extends BasePage {

    @BeforeMethod
    @Override
    public void setup() throws InterruptedException, FileNotFoundException {
        super.setup();
    }

   // @AfterMethod
   @Override
   public void teardown() {
   }

    @Test(priority = 0)
    public void ValidLogin () throws InterruptedException, FileNotFoundException {
        Loginpage loginpage = new Loginpage(driver);  // driver will be inherited from BasePage
        loginpage.login("standard_user","secret_sauce");

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }
    @Test(priority = 2)
    public void Without_any_Credectional() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.clickLogin();

        // Validate error message
        By errorLocator = By.xpath("//h3[@data-test='error']");  // Adjust the locator if needed
        WebElement errorElement = driver.findElement(errorLocator);
        String actualError = errorElement.getText();

        String expectedError = "Epic sadface: Username is required";
        Assert.assertEquals(actualError, expectedError, "Error message mismatch!");

        // Ensure user remains on login page
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "User should not be logged in without credentials.");
    }


    @Test(priority = 3)

    public void WithWrongPassword() throws InterruptedException, FileNotFoundException {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("test","dfwsdwsdw");

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Epic sadface: Username and password do not match any user in this service\n");


    }

    @Test(priority = 4)
    public void LoginWithLockedOutUser() throws InterruptedException, FileNotFoundException {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("locked_out_user", "secret_sauce");

        // Verify error message
//       WebElement errorElement = driver.findElement(errorLocator);
      //  String actualError = errorElement.getText();

        String expectedError = "Epic sadface: Sorry, this user has been locked out.\n";
       // Assert.assertEquals(actualError, expectedError, "Error message mismatch for locked out user.");
    }



}


