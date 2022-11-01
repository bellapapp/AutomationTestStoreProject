package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@class='logo']/img")
    WebElement pageLogo;

    @FindBy(xpath = "//*[@class='info_links_footer']/li//*[contains(text(),'Login')]")
    WebElement loginInFooter;

    @FindBy(xpath = "//*[@class='info_links_footer']/li//*[contains(text(),'Logoff')]")
    WebElement logOutInFooter;

    @FindBy(css = "#customer_menu_top [href*='login']")
    WebElement loginOrRegisterInHeader;

    @FindBy(css = "#topnav .menu_account")
    WebElement accountMenu;

    @FindBy(xpath = "//*[@id='main_menu_top']//*[@data-id='menu_account']//*[@class='sub menu_login']")
    WebElement loginInsideAccountMenu;

    @FindBy(css = "#main_menu_top .top.menu_specials")
    WebElement specials;

    @FindBy(xpath = "//*[@id='categorymenu']//a[contains(text(),'Apparel')]")
    WebElement apparelMenu;

    @FindBy(xpath = "//*[@id='categorymenu']//a[contains(text(),'Apparel')]//following-sibling::div[@class='subcategories']//a[contains(text(),'Shoes')]")
    WebElement shoesSubMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPageLogoIsDisplayed() {
        try {
            return pageLogo.isDisplayed();
        }
        catch (NoSuchElementException error) {
            return false;
        }
    }

    public void clickOnLoginInFooter() {
        loginInFooter.click();
    }

    public void clickOnLoginOrRegisterInHeader() {
        loginOrRegisterInHeader.click();
    }

    public void navigateToAndClickOnLoginInsideAccountMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountMenu).perform();
        actions.moveToElement(loginInsideAccountMenu).perform();
        actions.click().build().perform();
    }

    public void clickOnAccountInTopMenu() {
        accountMenu.click();
    }

    public void clickOnLogoutInFooter() {
        logOutInFooter.click();
    }

    public void navigateToSpecials() {
        specials.click();
    }

    public void navigateToShoesSubmenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(apparelMenu).build().perform();
        actions.moveToElement(shoesSubMenu).click().build().perform();
    }
}