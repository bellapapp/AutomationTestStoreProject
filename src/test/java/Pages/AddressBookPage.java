package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressBookPage extends BasePage {

    @FindBy(css = "a[title='New Address']")
    WebElement newAddress;

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
