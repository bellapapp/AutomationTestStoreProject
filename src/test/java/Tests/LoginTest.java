package Tests;

import Utils.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginPageFromLoginOrRegisterInHeader() {
        homePage.clickOnLoginOrRegisterInHeader();
        Assert.assertTrue(loginPage.verifyRegisterFormIsDisplayed());
        Assert.assertTrue(loginPage.verifyLoginFormIsDisplayed());
    }

    @Test
    public void verifyLoginPageFromLoginInFooter() {
        homePage.clickOnLoginInFooter();
        Assert.assertTrue(loginPage.verifyRegisterFormIsDisplayed());
        Assert.assertTrue(loginPage.verifyLoginFormIsDisplayed());
    }

    @Test
    public void verifyLoginPageFromAccountInTopMenu() {
        homePage.clickOnAccountInTopMenu();
        Assert.assertTrue(loginPage.verifyRegisterFormIsDisplayed());
        Assert.assertTrue(loginPage.verifyLoginFormIsDisplayed());
    }

    @Test
    public void verifyLoginPageFromLoginSubmenuInsideTheAccountMenu() {
        homePage.navigateToAndClickOnLoginInsideAccountMenu();
        Assert.assertTrue(loginPage.verifyRegisterFormIsDisplayed());
        Assert.assertTrue(loginPage.verifyLoginFormIsDisplayed());
    }

    @Test
    public void validLogin() {
        homePage.clickOnLoginOrRegisterInHeader();
        Assert.assertTrue(loginPage.verifyLoginNameIsEnabledAndSet(Constants.VALID_USERNAME));
        Assert.assertTrue(loginPage.verifyPasswordIsEnabledAndSet(Constants.VALID_PASSWORD));
        loginPage.submitLogin();
        Assert.assertTrue(myAccountPage.verifyMyAccountBoxIsDisplayed());
        Assert.assertEquals(Constants.VALID_USER_FIRSTNAME, myAccountPage.verifyValidUserIsLoggedIn());
    }

    @Test
    public void validLoginNameForgot() throws InterruptedException {
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.clickOnForgotLogin();
        Assert.assertTrue(forgottenLoginNamePage.verifyForgottenFormLastNameIsEnabled());
        forgottenLoginNamePage.setForgottenFormLastName(Constants.VALID_USER_LASTNAME);
        Assert.assertTrue(forgottenLoginNamePage.verifyForgottenFormEmailIsEnabled());
        forgottenLoginNamePage.setForgottenFormEmail(Constants.VALID_USER_EMAIL);
        forgottenLoginNamePage.clickOnContinueButton();
        Assert.assertTrue(loginPage.verifyAlertSuccessMessageIsDisplayed());
        Assert.assertTrue(loginPage.verifyForgottenLoginNameAlertSuccessMessage());
        navigateToMailinatorSite();
        mailinatorPage.setSearchField(Constants.VALID_USER_EMAIL_NAME);
        Assert.assertTrue(mailinatorPage.clickLoginNameReminderEmail());
        Assert.assertTrue(mailinatorPage.verifyLoginNameEmail(Constants.VALID_USERNAME));
        navigateToBaseSite();
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.doLogin(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        Assert.assertTrue(myAccountPage.verifyMyAccountBoxIsDisplayed());
        Assert.assertEquals(Constants.VALID_USER_FIRSTNAME, myAccountPage.verifyValidUserIsLoggedIn());
    }

    @Test
    public void validForgotPassword() throws InterruptedException {
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.clickOnForgotPassword();
        Assert.assertTrue(forgottenPasswordPage.verifyForgottenFormLoginNameIsEnabled());
        forgottenPasswordPage.setForgottenFormLoginName(Constants.VALID_USERNAME_FOR_CHANGE_PASSWORD);
        Assert.assertTrue(forgottenPasswordPage.verifyForgottenFormEmailIsEnabled());
        forgottenPasswordPage.setForgottenFormEmail(Constants.VALID_USER_EMAIL_FOR_CHANGE_PASSWORD);
        forgottenPasswordPage.clickOnContinueButton();
        Assert.assertTrue(loginPage.verifyAlertSuccessMessageIsDisplayed());
        Assert.assertTrue(loginPage.verifyForgottenPasswordAlertSuccessMessage());
        navigateToMailinatorSite();
        mailinatorPage.setSearchField(Constants.VALID_USER_EMAIL_NAME_FOR_CHANGE_PASSWORD);
        Assert.assertTrue(mailinatorPage.clickPasswordResetEmail());
        mailinatorPage.clickPasswordResetLink();
        switchToTheAnotherTab();
        Assert.assertTrue(changePasswordPage.passwordFormIsPresent());
        String newPassword = RandomStringUtils.randomAlphanumeric(10);

        Assert.assertTrue(changePasswordPage.verifyNewPasswordFieldIsEnabledAndSet(newPassword));
        Assert.assertTrue(changePasswordPage.verifyConfirmPasswordFieldIsEnabledAndSet(newPassword));
        changePasswordPage.clickOnContinueButton();
        Assert.assertTrue(myAccountPage.verifyAlertSuccessMessageIsDisplayed());
        Assert.assertTrue(myAccountPage.verifyPasswordUpdateAlertSuccessMessage());
        loginPage.doLogin(Constants.VALID_USERNAME_FOR_CHANGE_PASSWORD, newPassword);
        myAccountPage.verifyMyAccountBoxIsDisplayed();
        Assert.assertEquals(Constants.VALID_USER_FIRSTNAME_FOR_CHANGE_PASSWORD, myAccountPage.verifyValidUserIsLoggedIn());
        navigateToMailinatorSite();
        mailinatorPage.setSearchField(Constants.VALID_USER_EMAIL_NAME_FOR_CHANGE_PASSWORD);
        mailinatorPage.waitForPasswordUpdatedConfirmationEmailAndClickOnIt();
        Assert.assertTrue(mailinatorPage.verifyLoginResetPasswordConfirmationEmail());
    }

    @Test
    public void logOutTest() {
        homePage.clickOnLoginOrRegisterInHeader();
        loginPage.doLogin(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        homePage.clickOnLogoutInFooter();
        Assert.assertTrue(loginPage.verifyLogout());
    }

}
