package Testpage;

import Basepage.BasePage;
import Pages.Loginpage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
    }

    @AfterMethod
    @Override
    public void teardown() {
        super.teardown();
    }

    @Test
    public void ValidLogin () throws InterruptedException {
        Loginpage loginpage = new Loginpage(driver);  // driver will be inherited from BasePage
        loginpage.login("standard_user","secret_sauce");

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }
}
