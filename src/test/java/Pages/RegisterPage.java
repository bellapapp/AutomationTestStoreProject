package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    @FindBy(className = "maintext")
    WebElement mainText;

    @FindBy(id = "AccountFrm_firstname")
    WebElement firstName;

    @FindBy(id = "AccountFrm_lastname")
    WebElement lastName;

    @FindBy(id = "AccountFrm_email")
    WebElement email;

    @FindBy(id = "AccountFrm_address_1")
    WebElement address1;

    @FindBy(id = "AccountFrm_city")
    WebElement city;

    @FindBy(id = "AccountFrm_zone_id")
    WebElement region;

    @FindBy(id = "AccountFrm_postcode")
    WebElement postCode;

    @FindBy(id = "AccountFrm_country_id")
    WebElement country;

    @FindBy(id = "AccountFrm_loginname")
    WebElement loginName;

    @FindBy(id = "AccountFrm_password")
    WebElement password;

    @FindBy(id = "AccountFrm_confirm")
    WebElement passwordConfirm;

    @FindBy(id = "AccountFrm_newsletter1")
    WebElement yesSubscribeRadioButton;

    @FindBy(id = "AccountFrm_agree")
    WebElement accountFormAgree;

    @FindBy(css = "#AccountFrm button[title='Continue']")
    WebElement submitRegister;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyRegisterPage() {
        return mainText.getText().equalsIgnoreCase("Create Account");
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setAddress1(String address1) {
        this.address1.sendKeys(address1);
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setPostCode(String postCode) {
        this.postCode.sendKeys(postCode);
    }

    public void setLoginName(String loginName) {
        this.loginName.sendKeys(loginName);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm.sendKeys(passwordConfirm);
    }

    public void subscribeToNewsletter() {
        yesSubscribeRadioButton.click();
    }

    public void clickOnAccountFormAgree() {
        accountFormAgree.click();
    }

    public void submitRegister() {
        submitRegister.click();
    }

    public void selectRegion(int region) {
        Select select = new Select(this.region);
        select.selectByIndex(region);
    }

    public void selectCountry(int country) {
        Select select = new Select(this.country);
        select.selectByIndex(country);
    }
}
