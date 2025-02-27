package Testpage;

import Basepage.BasePage;
import Pages.Homepage;
import Pages.Loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

public class HomepageTest extends BasePage {

    private Homepage homepage;

    @BeforeClass
    @Override
    public void setup() throws InterruptedException, FileNotFoundException {
        super.setup();
        Loginpage loginpage = new Loginpage(driver);
       homepage  =loginpage.login("standard_user", "secret_sauce");
    }

    @Override
    public void teardown() {

    }

    @Test
    public void validateTheHeader() {
       // Homepage homepage = new Homepage(driver);

        String actualTitle = homepage.checkHeaderTitle();

        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle, "Header title does not match the expected value!");
    }

}
