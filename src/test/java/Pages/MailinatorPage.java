package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class MailinatorPage extends BasePage {

    @FindBy(css = "input#search")
    WebElement searchField;

    @FindBy(xpath = "//input[@id='search']//following::button[1]")
    WebElement submitSearchButton;

    @FindBy(xpath = "//*[@class='table-striped jambo_table']//tbody//*[contains(text(),'Automation Test Store - Login name reminder')]/following-sibling::td[contains(text(),'just now')]/parent::tr")
    WebElement loginNameReminderEmail;

    @FindBy(xpath = "//*[@class='table-striped jambo_table']//tbody//*[contains(text(),'Automation Test Store - Password reset')]/following-sibling::td[contains(text(),'just now')]/parent::tr")
    WebElement passwordResetEmail;

    @FindBy(xpath = "//*[@class='table-striped jambo_table']//tbody//*[contains(text(),'Automation Test Store - Thank you for registering')]/following-sibling::td[contains(text(),'just now')]/parent::tr")
    WebElement registerConfirmationEmail;

    @FindBy(xpath = "//*[@class='table-striped jambo_table']//tbody//*[contains(text(),'Automation Test Store  Notification')]/following-sibling::td[contains(text(),'just now')]/parent::tr")
    WebElement notificationEmail;

    @FindBy(id = "texthtml_msg_body")
    WebElement emailContentIframe;

    @FindBy(css = "body a")
    WebElement passwordResetLink;

    public MailinatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearchField(String emailName) {
        searchField.sendKeys(emailName);
        submitSearchButton.click();
    }

    public boolean clickLoginNameReminderEmail() {
        try {
            baseFluentWaitForElementToBeVisible(30, 1, loginNameReminderEmail);
            loginNameReminderEmail.click();
            return true;
        } catch (TimeoutException error) {
            System.out.println("The Login name Reminder email hasn't arrived in 30 seconds.");
            return false;
        }
    }

    public boolean clickPasswordResetEmail() {
        try {
            baseFluentWaitForElementToBeVisible(30, 1, passwordResetEmail);
            passwordResetEmail.click();
            return true;
        } catch (TimeoutException error) {
            System.out.println("The Password reset email hasn't arrived in 30 seconds.");
            return false;
        }
    }

    public boolean clickNotificationEmail() {
        try {
            baseFluentWaitForElementToBeVisible(30, 1, notificationEmail);
            notificationEmail.click();
            return true;
        } catch (TimeoutException error) {
            System.out.println("The Notification email hasn't arrived in 30 seconds.");
            return false;
        }
    }

    public void clickPasswordResetLink() {
        driver.switchTo().frame(emailContentIframe);
        baseFluentWaitForElementToBeVisible(10, 1, passwordResetLink);
        passwordResetLink.click();
    }

    public boolean verifyLoginNameEmail(String loginName) throws InterruptedException {
        driver.switchTo().frame(emailContentIframe);
        Thread.sleep(3000);
        return driver.findElement(By.tagName("body")).getText().contains(loginName);
    }

    public boolean verifyUpdatedPasswordConfirmationEmail() throws InterruptedException {
        driver.switchTo().frame(emailContentIframe);
        Thread.sleep(3000);
        return driver.findElement(By.tagName("body")).getText().contains("Your account password has been changed! If you did not do this change, please contact site owner");
    }

    public void waitForPasswordUpdatedConfirmationEmailAndClickOnIt() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@class='table-striped jambo_table']//tbody//*[contains(text(),'Automation Test Store - Password reset')]/following-sibling::td[contains(text(),'just now')]/parent::tr"), 1));
        driver.findElement(By.xpath("//*[@class='table-striped jambo_table']//tbody//*[contains(text(),'Automation Test Store - Password reset')]/following-sibling::td[contains(text(),'just now')]/parent::tr[1]")).click();
    }

    public boolean verifyLoginResetPasswordConfirmationEmail() throws InterruptedException {
        driver.switchTo().frame(emailContentIframe);
        Thread.sleep(3000);
        return driver.findElement(By.tagName("body")).getText().contains("Your password was successfully reset on Automation Test Store.");
    }

    public boolean verifyRegisterConfirmation() {
        try {
            baseFluentWaitForElementToBeVisible(30, 1, registerConfirmationEmail);
            return true;
        } catch (TimeoutException error) {
            System.out.println("The confirmation email hasn't arrived in 30 seconds.");
            return false;
        }
    }


}