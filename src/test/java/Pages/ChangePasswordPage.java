package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BasePage {

    @FindBy(id = "PasswordFrm")
    WebElement passwordForm;

    @FindBy(id = "PasswordFrm_current_password")
    WebElement currentPasswordField;

    @FindBy(id = "PasswordFrm_password")
    WebElement newPasswordField;

    @FindBy(id = "PasswordFrm_confirm")
    WebElement confirmPasswordField;

    @FindBy(css = "#PasswordFrm button[title='Continue']")
    WebElement continueButton;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean passwordFormIsPresent() {
        try {
            return passwordForm.isDisplayed();
        } catch (NoSuchElementException error) {
            return false;
        }
    }

    public boolean verifyNewPasswordFieldIsEnabledAndSet(String newPassword) {
        if (newPasswordField.isEnabled()) {
            newPasswordField.sendKeys(newPassword);
            return true;
        }
        return false;
    }

    public boolean verifyConfirmPasswordFieldIsEnabledAndSet(String confirmPassword) {
        if (confirmPasswordField.isEnabled()) {
            confirmPasswordField.sendKeys(confirmPassword);
            return true;
        }
        return false;
    }

    public boolean verifyCurrentPasswordFieldIsEnabledAndSet(String currentPassword) {
        if (currentPasswordField.isEnabled()) {
            currentPasswordField.sendKeys(currentPassword);
            return true;
        }
        return false;
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
