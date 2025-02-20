package Testpage;

import Basepage.BasePage;
import Pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageTest extends BasePage {
@BeforeMethod
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void validateTheHeader() {
        // Instantiate the Homepage object
        Homepage homepage = new Homepage(driver);

        // Get the header title text from the page
        String actualTitle = homepage.checkHeaderTitle();

        // Assert that the actual title is equal to the expected title
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle, "Header title does not match the expected value!");
    }
}
