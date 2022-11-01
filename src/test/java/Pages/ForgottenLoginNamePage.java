package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenLoginNamePage extends BasePage{

    @FindBy(id = "forgottenFrm_lastname")
    WebElement forgottenFormLastName;

    @FindBy(id = "forgottenFrm_email")
    WebElement forgottenFormEmail;

    @FindBy(css = "#forgottenFrm button[title='Continue']")
    WebElement continueButton;

    public ForgottenLoginNamePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyForgottenFormLastNameIsEnabled() {
        return forgottenFormLastName.isEnabled();
    }

    public boolean verifyForgottenFormEmailIsEnabled() {
        return forgottenFormEmail.isEnabled();
    }

    public void setForgottenFormLastName(String forgottenFormLastName) {
        this.forgottenFormLastName.sendKeys(forgottenFormLastName);
    }

    public void setForgottenFormEmail(String forgottenFormEmail) {
        this.forgottenFormEmail.sendKeys(forgottenFormEmail);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
