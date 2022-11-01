package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{

    @FindBy(className = "myaccountbox")
    WebElement myAccountMenu;

    @FindBy(css = ".heading1 .subtext")
    WebElement userFirstNameInHeading1;

    @FindBy(className = "maintext")
    WebElement mainText;

    @FindBy(css = ".alert-success")
    WebElement alertSuccess;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyMyAccountBoxIsDisplayed() {
        try {
            return myAccountMenu.isDisplayed();
        }
        catch(NoSuchElementException error) {
            return false;
        }
    }

    public String verifyValidUserIsLoggedIn() {
        return userFirstNameInHeading1.getText();
    }

    public boolean verifyMainTextAfterRegister() {
        return mainText.getText().equalsIgnoreCase("YOUR ACCOUNT HAS BEEN CREATED!");
    }

    public boolean navigateToChangePassword() {
        myAccountMenu.findElement(By.linkText("Change password")).click();
        return mainText.getText().contains("CHANGE PASSWORD");
    }

    public boolean verifyAlertSuccessMessageIsDisplayed() {
        try {
            return alertSuccess.isDisplayed();
        }
        catch (NoSuchElementException error) {
            return false;
        }
    }

    public boolean verifyPasswordUpdateAlertSuccessMessage() {
        return alertSuccess.getText().contains("Success: Your password has been successfully updated.");
    }

    public boolean navigateToManageAddressBook() {
        myAccountMenu.findElement(By.linkText("Manage Address Book")).click();
        return mainText.getText().contains("ADDRESS BOOK");
    }
}
