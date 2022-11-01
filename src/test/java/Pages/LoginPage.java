package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(css = ".newcustomer")
    WebElement registerForm;

    @FindBy(css = ".returncustomer")
    WebElement loginForm;

    @FindBy(id = "loginFrm_loginname")
    WebElement loginFormLoginName;

    @FindBy(id = "loginFrm_password")
    WebElement loginFormPassword;

    @FindBy(xpath = "//*[@id='loginFrm']//button[@title='Login']")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//*[@id='loginFrm']//a[contains(text(),'Forgot your login?')]")
    WebElement forgotLoginLink;

    @FindBy(xpath = "//*[@id='loginFrm']//a[contains(text(),'Forgot your password?')]")
    WebElement forgotPasswordLink;

    @FindBy(className = "alert-success")
    WebElement alertSuccess;

    @FindBy(className = "maintext")
    WebElement mainText;

    @FindBy(css = "#accountFrm button[title='Continue']")
    WebElement continueToRegisterPageButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyRegisterFormIsDisplayed() {
        try {
            return registerForm.isDisplayed();
        }
        catch (NoSuchElementException error) {
            return false;
        }
    }

    public boolean verifyLoginFormIsDisplayed() {
        try {
            return loginForm.isDisplayed();
        }
        catch (NoSuchElementException error) {
            return false;
        }
    }

    public boolean verifyLoginNameIsEnabledAndSet(String loginFormLoginName) {
        if(this.loginFormLoginName.isEnabled()) {
            this.loginFormLoginName.sendKeys(loginFormLoginName);
            return true;
        }
        return false;
    }

    public boolean verifyPasswordIsEnabledAndSet(String loginFormPassword) {
        if(this.loginFormPassword.isEnabled()) {
            this.loginFormPassword.sendKeys(loginFormPassword);
            return true;
        }
        return false;
    }

    public void setLoginFormLoginName(String loginFormLoginName) {
        this.loginFormLoginName.sendKeys(loginFormLoginName);
    }

    public void setLoginFormPassword(String loginFormPassword) {
        this.loginFormPassword.sendKeys(loginFormPassword);
    }

    public void submitLogin() {
        loginSubmitButton.click();
    }

    public void doLogin(String userName, String password) {
        setLoginFormLoginName(userName);
        setLoginFormPassword(password);
        submitLogin();
    }

    public void clickOnForgotLogin() {
        forgotLoginLink.click();
    }

    public void clickOnForgotPassword() {
        forgotPasswordLink.click();
    }

    public boolean verifyAlertSuccessMessageIsDisplayed() {
        try {
            return alertSuccess.isDisplayed();
        }
        catch (NoSuchElementException error) {
            return false;
        }
    }

    public boolean verifyForgottenLoginNameAlertSuccessMessage() {
        return alertSuccess.getText().contains("Success: Your login name reminder has been sent to your e-mail address.");
    }

    public boolean verifyForgottenPasswordAlertSuccessMessage() {
        return alertSuccess.getText().contains("Success: Password reset link has been sent to your e-mail address.");
    }

    public boolean verifyLogout() {
        return mainText.getText().equalsIgnoreCase("Account Logout");
    }

    public void navigateToRegisterPage() {
        continueToRegisterPageButton.click();
    }
}
