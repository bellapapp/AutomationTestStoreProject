package Tests;

import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void logoTest() {
        Assert.assertTrue(homePage.verifyPageLogoIsDisplayed());
    }
}
