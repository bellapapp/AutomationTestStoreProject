package Tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void validRegister() {
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.navigateToRegisterPage();
        Assert.assertTrue(registerPage.verifyRegisterPage());
        registerPage.setFirstName(RandomStringUtils.randomAlphabetic(5));
        registerPage.setLastName(RandomStringUtils.randomAlphabetic(5));

        String email = RandomStringUtils.randomAlphabetic(5);

        registerPage.setEmail(email + "@mailinator.com");
        registerPage.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        registerPage.setCity(RandomStringUtils.randomAlphabetic(5));
        registerPage.selectRegion(2);
        registerPage.setPostCode(RandomStringUtils.randomAlphanumeric(6));
        registerPage.setLoginName(RandomStringUtils.randomAlphabetic(10));

        String password = RandomStringUtils.randomAlphanumeric(10);

        registerPage.setPassword(password);
        registerPage.setPasswordConfirm(password);
        registerPage.subscribeToNewsletter();
        registerPage.clickOnAccountFormAgree();
        registerPage.submitRegister();
        Assert.assertTrue(myAccountPage.verifyMainTextAfterRegister());
        Assert.assertTrue(myAccountPage.verifyMyAccountBoxIsDisplayed());
        navigateToMailinatorSite();
        mailinatorPage.setSearchField(email);
        Assert.assertTrue(mailinatorPage.verifyRegisterConfirmation());
    }
}
