package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductsCatalogPage extends BasePage {

    @FindBy(css = ".dropdown-menu.currency li a")
    List<WebElement> currencyList;

    @FindBy(xpath = "//*[@class='dropdown-menu currency']//preceding-sibling::a[contains(@class,'dropdown-toggle')]/span")
    WebElement actualCurrency;

    @FindBy(css = ".language .dropdown.hover a.dropdown-toggle")
    WebElement currencyDropdown;

    @FindBy(xpath = "//*[contains(@class,'grid')]//*[@class='price']//*[@class='oneprice' or @class='pricenew']")
    List<WebElement> priceList;

    @FindBy(css = ".grid .price")
    List<WebElement> priceListForLoop;

    public ProductsCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getActualCurrency() {
        return actualCurrency.getText();
    }

    public boolean changeToAnotherCurrency() {

        Actions actions = new Actions(driver);
        actions.moveToElement(currencyDropdown).build().perform();
        for (WebElement element : currencyList) {
            if (!(element.getText().equalsIgnoreCase(getActualCurrency()))) {
                actions.moveToElement(currencyDropdown).build().perform();
                actions.moveToElement(element).click().build().perform();
                return true;
            }
        }
        return false;
    }

    public boolean changeToATargetedCurrency(String currency) {
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyDropdown).build().perform();
        for (WebElement element : currencyList) {
            if (element.getText().contains(currency)) {
                actions.moveToElement(element).click().build().perform();
                return true;
            }
        }
        return false;
    }


    public String getCurrencySymbol(String currency) {
        return currency.replace(" US DOLLAR", "").replace(" EURO", "").replace(" POUND STERLING", "");
    }

    public boolean verifyCurrencyPrices(String currencySymbol) {
        boolean price = false;
        for (WebElement element : priceList) {
            if (element.getText().contains(currencySymbol)) {
                price = true;
                System.out.println(element.getText());
            } else {
                price = false;
                break;
            }
        }
        return price;
    }

    public boolean verifySalePrices() {
        for (WebElement element : priceListForLoop) {
            if (getIntFromPrice(element.findElement(By.cssSelector(".pricenew")).getText()) > getIntFromPrice(element.findElement(By.cssSelector(".priceold")).getText())) {
                return false;
            }
        }
        return true;
    }
}
