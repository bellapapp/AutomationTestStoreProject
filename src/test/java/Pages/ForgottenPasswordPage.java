package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage extends BasePage{

    @FindBy(id = "forgottenFrm_loginname")
    WebElement forgottenFormLoginName;

    @FindBy(id = "forgottenFrm_email")
    WebElement forgottenFormEmail;

    @FindBy(css = "#forgottenFrm button[title='Continue']")
    WebElement continueButton;


    public ForgottenPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyForgottenFormLoginNameIsEnabled() {
        return forgottenFormLoginName.isEnabled();
    }

    public boolean verifyForgottenFormEmailIsEnabled() {
        return forgottenFormEmail.isEnabled();
    }

    public void setForgottenFormLoginName(String forgottenFormLoginName) {
        this.forgottenFormLoginName.sendKeys(forgottenFormLoginName);
    }

    public void setForgottenFormEmail(String forgottenFormEmail) {
        this.forgottenFormEmail.sendKeys(forgottenFormEmail);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
