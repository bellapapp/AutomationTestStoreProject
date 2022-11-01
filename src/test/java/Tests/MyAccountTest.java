package Tests;

import Utils.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class MyAccountTest extends BaseTest{

    @Test
    public void changePassword() throws InterruptedException {
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.doLogin(Constants.VALID_USERNAME_FOR_UPDATE_PASSWORD, Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD);
        Assert.assertTrue(myAccountPage.navigateToChangePassword());
        Assert.assertTrue(changePasswordPage.verifyCurrentPasswordFieldIsEnabledAndSet(Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD));

        String passwordPlus = RandomStringUtils.randomAlphanumeric(5);
        Assert.assertTrue(changePasswordPage.verifyNewPasswordFieldIsEnabledAndSet(Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD + "" + passwordPlus));
        Assert.assertTrue(changePasswordPage.verifyConfirmPasswordFieldIsEnabledAndSet(Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD + "" + passwordPlus));
        changePasswordPage.clickOnContinueButton();
        Assert.assertTrue(myAccountPage.verifyPasswordUpdateAlertSuccessMessage());
        homePage.clickOnLogoutInFooter();
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.doLogin(Constants.VALID_USERNAME_FOR_UPDATE_PASSWORD, Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD + "" + passwordPlus);
        Assert.assertEquals(Constants.VALID_USER_FIRSTNAME_FOR_UPDATE_PASSWORD, myAccountPage.verifyValidUserIsLoggedIn());
        Assert.assertTrue(myAccountPage.navigateToChangePassword());
        Assert.assertTrue(changePasswordPage.verifyCurrentPasswordFieldIsEnabledAndSet(Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD + "" + passwordPlus));
        Assert.assertTrue(changePasswordPage.verifyNewPasswordFieldIsEnabledAndSet(Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD));
        Assert.assertTrue(changePasswordPage.verifyConfirmPasswordFieldIsEnabledAndSet(Constants.VALID_PASSWORD_FOR_UPDATE_PASSWORD));
        changePasswordPage.clickOnContinueButton();
        Assert.assertTrue(myAccountPage.verifyPasswordUpdateAlertSuccessMessage());
        navigateToMailinatorSite();
        mailinatorPage.setSearchField(Constants.VALID_USER_EMAIL_NAME_FOR_UPDATE_PASSWORD);
        Assert.assertTrue(mailinatorPage.clickNotificationEmail());
        Assert.assertTrue(mailinatorPage.verifyUpdatedPasswordConfirmationEmail());
    }

    @Test
    public void manageAddressBook() {
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.doLogin(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        Assert.assertTrue(myAccountPage.navigateToManageAddressBook());

        // to continue
    }
}
