package Tests;

import Pages.*;
import Utils.Constants;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;
public class BaseTest {

    WebDriver driver;

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    ForgottenLoginNamePage forgottenLoginNamePage;
    ForgottenPasswordPage forgottenPasswordPage;
    MailinatorPage mailinatorPage;
    ChangePasswordPage changePasswordPage;
    RegisterPage registerPage;
    ProductsCatalogPage productsCatalogPage;
    AddressBookPage addressBookPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driverResources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(Constants.BASE_URL);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        forgottenLoginNamePage = new ForgottenLoginNamePage(driver);
        mailinatorPage = new MailinatorPage(driver);
        forgottenPasswordPage = new ForgottenPasswordPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);
        registerPage = new RegisterPage(driver);
        productsCatalogPage = new ProductsCatalogPage(driver);
        addressBookPage = new AddressBookPage(driver);
    }

    public void navigateToMailinatorSite() {
        driver.get(Constants.MAILINATOR_URL);
    }

    public void navigateToBaseSite() {
        driver.get(Constants.BASE_URL);
    }

    public void switchToTheAnotherTab() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String childWindow : allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println(driver.getCurrentUrl());
            }
        }
    }
}
