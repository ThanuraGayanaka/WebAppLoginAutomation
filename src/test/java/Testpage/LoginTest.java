package Testpage;

import Basepage.BasePage;
import Pages.Loginpage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTest extends BasePage {

    @BeforeMethod
    @Override
    public void setup() throws InterruptedException, FileNotFoundException {
        super.setup();  // Initialize the WebDriver before each test
    }

    @AfterMethod
    @Override
    public void teardown() {
        super.teardown();  // Clean up after each test (close driver)
    }

    @Test(priority = 0)
    public void ValidLogin() throws FileNotFoundException {
        Loginpage loginpage = new Loginpage(driver);  // driver will be inherited from BasePage
        loginpage.login("standard_user", "secret_sauce");

        // Expected URL after successful login
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }
    @Test(priority = 1, enabled = true)
    public void WithoutAnyCredentials() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.clickLogin();

        // Validate error message
        String actualError = loginpage.getErrorMessage();
        String expectedError = "Epic sadface: Username is required";
        Assert.assertEquals(actualError, expectedError, "Error message mismatch!");

        // Ensure user remains on login page
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "User should not be logged in without credentials.");
    }


    @Test(priority = 2)
    public void WithoutPassword_andUsename() {
        Loginpage loginpage = new Loginpage(driver);

        // Enter no username and no password
        loginpage.enterUsername("");  // Leave username blank
        loginpage.enterPassword("");  // Leave password blank

        // Click the login button
        loginpage.clickLogin();

        // Validate error message
        String actualError = loginpage.getErrorMessage();
        String expectedError = "Epic sadface: Username is required";
        Assert.assertEquals(actualError, expectedError, "Error message mismatch for missing credentials!");

        // Ensure user remains on login page
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "User should not be logged in without providing username and password.");
    }



    @Test(priority = 3)
    public void InvalidUsername() {
        Loginpage loginpage = new Loginpage(driver);

        // Enter an invalid username and a valid password
        loginpage.enterUsername("invalid_user");
        loginpage.enterPassword("secret_sauce");

        // Click the login button
        loginpage.clickLogin();

        // Validate error message
        String actualError = loginpage.getErrorMessage();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualError, expectedError, "Error message mismatch for invalid username!");

        // Ensure user remains on login page
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "User should not be logged in with an invalid username.");
    }


    @Test(priority = 4)
    public void WithoutPassword() {
        Loginpage loginpage = new Loginpage(driver);

        // Enter username and leave the password field empty
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("");  // Empty password

        // Click the login button
        loginpage.clickLogin();

        // Validate error message
        String actualError = loginpage.getErrorMessage();
        String expectedError = "Epic sadface: Password is required";
        Assert.assertEquals(actualError, expectedError, "Error message mismatch for empty password!");

        // Ensure user remains on login page
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "User should not be logged in with empty password.");
    }

    @Test(priority = 5)
    public void InvalidUsernameFormat() {
        Loginpage loginpage = new Loginpage(driver);

        // Enter an invalid username format and valid password
        loginpage.enterUsername("invalid_user@123");  // Invalid username
        loginpage.enterPassword("secret_sauce");

        // Click the login button
        loginpage.clickLogin();

        // Validate error message
        String actualError = loginpage.getErrorMessage();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualError, expectedError, "Error message mismatch for invalid username format!");

        // Ensure user remains on login page
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "User should not be logged in with an invalid username format.");
    }

}
